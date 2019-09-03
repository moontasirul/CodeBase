package com.moontasirul.codebasedesignpattern.data.remote.retrofit.model;

import com.google.gson.annotations.SerializedName;
import com.moontasirul.codebasedesignpattern.data.model.UserModel;
import com.moontasirul.codebasedesignpattern.data.remote.Endpoints;

public class UserLogout extends BaseRequest{

    @SerializedName(Endpoints.CUSTOMER)
    private UserModel userId;

    public UserModel getUserId() {
        return userId;
    }

    public void setUserId(UserModel userId) {
        this.userId = userId;
    }
}
