package com.bhavesh.service;

import com.bhavesh.modal.TwoFactorOTP;
import com.bhavesh.modal.User;

public interface TwoFactorOtpService {

    TwoFactorOTP createTwoFactorOtp(User user,String otp, String jwt);

    TwoFactorOTP findByUser(Long userId);

    TwoFactorOTP findById(String id);

    boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOTP,String otp);

    void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP);
}
