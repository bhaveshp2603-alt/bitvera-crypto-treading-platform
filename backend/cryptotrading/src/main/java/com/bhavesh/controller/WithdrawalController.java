package com.bhavesh.controller;

import com.bhavesh.domain.WalletTransactionType;
import com.bhavesh.modal.User;
import com.bhavesh.modal.Wallet;
import com.bhavesh.modal.WalletTransaction;
import com.bhavesh.modal.Withdrawal;
import com.bhavesh.service.TransactionService;
import com.bhavesh.service.UserService;
import com.bhavesh.service.WalletService;
import com.bhavesh.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/api/withdrawal/{amount}")
    public ResponseEntity<?> withdrawalRequest(
            @PathVariable Long amount,
            @RequestHeader("Authorization")String jwt
    )throws Exception{
        User user = userService.findUserProfileByJwt(jwt);
        Wallet userWallet = walletService.getUserWallet(user);

        Withdrawal withdrawal = withdrawalService.requestWithdrawal(amount,user);
        walletService.addBalance(userWallet,-withdrawal.getAmount());

       WalletTransaction walletTransaction = transactionService.createTransaction(
               userWallet,
               WalletTransactionType.WITHDRAWAL,null,
               "bank account withdrawal",
               withdrawal.getAmount()
       );

        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }

    @PatchMapping("/api/admin/withdrawal/{id}/proceed/{accept}")
    public ResponseEntity<?> proceedWithdrawal(
            @PathVariable Long id,
            @PathVariable boolean accept,
            @RequestHeader("Authorization")String jwt
    )throws Exception{
        User user = userService.findUserProfileByJwt(jwt);

        Withdrawal withdrawal = withdrawalService.proceedWithdrawal(id,accept);

        Wallet userWallet = walletService.getUserWallet(user);
        if (!accept){
            walletService.addBalance(userWallet, withdrawal.getAmount());
        }

        return new ResponseEntity<>(withdrawal,HttpStatus.OK);
    }

    @GetMapping("/api/withdrawal")
    public ResponseEntity<List<Withdrawal>> getWithdrawalHistory(
            @RequestHeader("Authorization")String jwt
    )throws Exception{
        User user = userService.findUserProfileByJwt(jwt);

        List<Withdrawal> withdrawal = withdrawalService.getUsersWithdrawalHistory(user);

        return new ResponseEntity<>(withdrawal,HttpStatus.OK);
    }

    @GetMapping("/api/admin/withdrawal")
    public ResponseEntity<List<Withdrawal>> getAllWithdrawalRequest(
            @RequestHeader("Authorization")String jwt
    )throws Exception{
        User user = userService.findUserProfileByJwt(jwt);

        List<Withdrawal> withdrawal = withdrawalService.getAllWithdrawalRequest();

        return new ResponseEntity<>(withdrawal,HttpStatus.OK);
    }

}
