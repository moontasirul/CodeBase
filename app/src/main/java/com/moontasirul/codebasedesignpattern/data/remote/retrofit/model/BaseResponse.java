package com.moontasirul.codebasedesignpattern.data.remote.retrofit.model;

import com.google.gson.annotations.SerializedName;
import com.moontasirul.codebasedesignpattern.data.remote.Endpoints;

/**
 * Created by User Moon on 3/5/2018.
 */

public class BaseResponse {

    @SerializedName(Endpoints.STATUS)
    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
