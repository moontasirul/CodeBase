package com.moontasirul.codebasedesignpattern.data.remote.retrofit.model;

import com.google.gson.annotations.SerializedName;
import com.moontasirul.codebasedesignpattern.data.remote.Endpoints;

public class LoginRequest {

    @SerializedName(Endpoints.USER_PHONE)
    private String userPhoneNo;

    @SerializedName(Endpoints.USER_PASSWORD)
    private String userPassword;

    public LoginRequest(String userPhoneNo, String userPassword) {
        this.userPhoneNo = userPhoneNo;
        this.userPassword = userPassword;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
