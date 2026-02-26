package com.bhavesh.controller;

import com.bhavesh.domain.PaymentMethod;
import com.bhavesh.modal.PaymentOrder;
import com.bhavesh.modal.User;
import com.bhavesh.response.PaymentResponse;
import com.bhavesh.service.PaymentService;
import com.bhavesh.service.UserService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/api/payment/{paymentMethod}/amount/{amount}")
    public ResponseEntity<PaymentResponse> paymentHandler(
            @PathVariable PaymentMethod paymentMethod,
            @PathVariable Long amount,
            @RequestHeader("Authorization") String jwt
            )throws Exception,
            RazorpayException,
            StripeException{

        User user= userService.findUserProfileByJwt(jwt);
        PaymentResponse paymentResponse;

        PaymentOrder order = paymentService.createOrder(user,amount,paymentMethod);

        if (paymentMethod.equals(PaymentMethod.RAZORPAY)){
            paymentResponse=paymentService.createRazorpayPaymentLing(user,amount, order.getId());
        }
        else {
            paymentResponse=paymentService.createStripePaymentLing(user,amount,order.getId());
        }

        return  new ResponseEntity<>(paymentResponse, HttpStatus.CREATED);
    }
}
