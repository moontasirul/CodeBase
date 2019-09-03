package com.moontasirul.codebasedesignpattern.data.remote.retrofit.model;

import com.google.gson.annotations.SerializedName;
import com.moontasirul.codebasedesignpattern.data.model.UserModel;

public class RegistrationResponse extends BaseResponse {

    @SerializedName("response")
    private UserModel userModel;


    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
