package com.moontasirul.codebasedesignpattern.data.remote.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

    @SerializedName("response")
    private String loginResponse;

    public String getLoginResponse() {
        return loginResponse;
    }

    public void setLoginResponse(String loginResponse) {
        this.loginResponse = loginResponse;
    }
}
