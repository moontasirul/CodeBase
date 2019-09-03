package com.moontasirul.codebasedesignpattern.data.remote.retrofit.model;

import com.google.gson.annotations.SerializedName;
import com.moontasirul.codebasedesignpattern.data.remote.Endpoints;

/**
 * Created by User Moon on 3/5/2018.
 */

public class BaseRequest {
    @SerializedName(Endpoints.TERMINAL_ID)
    private String terminalId;
    @SerializedName(Endpoints.FCM_TOKEN)
    private String fcmToken;
    @SerializedName(Endpoints.TOKEN)
    private String token;

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
