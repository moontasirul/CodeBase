package com.moontasirul.codebasedesignpattern.data.remote.retrofit.model;

import com.google.gson.annotations.SerializedName;
import com.moontasirul.codebasedesignpattern.data.remote.Endpoints;


public class UserRegistration {

    @SerializedName(Endpoints.USER_NAME)
    private String userName;
    @SerializedName(Endpoints.USER_EMAIL)
    private String userEmail;
    @SerializedName(Endpoints.USER_PHONE)
    private String userPhone;
    @SerializedName(Endpoints.STUDENT_ID)
    private String stduentId;
    @SerializedName(Endpoints.USER_PASSWORD)
    private String password;


    public UserRegistration(String userName, String userEmail, String userPhone, String stduentId, String password) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.stduentId = stduentId;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getStduentId() {
        return stduentId;
    }

    public void setStduentId(String stduentId) {
        this.stduentId = stduentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
