package com.moontasirul.codebasedesignpattern.data.remote.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class OTPRequest {

    @SerializedName("OTP")
    private String otp;


    public OTPRequest(String otp) {
        this.otp = otp;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
