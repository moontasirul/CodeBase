package com.moontasirul.codebasedesignpattern.data.remote.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class OTPResponse {

    @SerializedName("otp_status")
    private String otpStatus;

    public String getOtpStatus() {
        return otpStatus;
    }

    public void setOtpStatus(String otpStatus) {
        this.otpStatus = otpStatus;
    }
}
