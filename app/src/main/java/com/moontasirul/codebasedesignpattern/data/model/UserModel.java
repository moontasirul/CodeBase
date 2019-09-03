package com.moontasirul.codebasedesignpattern.data.model;

import android.util.Patterns;

import com.google.gson.annotations.SerializedName;

public class UserModel {


    /**
     * invoke user Id
     */
    @SerializedName("Id")
    private String userId;


    /**
     * invoke user Id
     */
    @SerializedName("CustomerId")
    private String customerId;


    /**
     * invoke user Name
     */
    @SerializedName("Name")
    private String userName;

    /**
     * invoke user Phone number
     */
    private String userPhoneNo;


    /**
     * invoke user email ID
     */
    @SerializedName("EmailOrPhone")
    private String email;

    /**
     * invoke user password
     */
    @SerializedName("Password")
    private String password;

    /**
     * invoke user old password change
     */
    @SerializedName("OldPassword")
    private String oldPassword;

    /**
     * invoke user new password
     */
    @SerializedName("NewPassword")
    private String newPassword;

    /**
     * invoke user confirm new password
     */
    @SerializedName("ConfirmNewPassword")
    private String confirmNewPassword;

    /**
     * invoke user phone number
     */
    @SerializedName("Phone")
    private String phoneNumber;


    /**
     * invoke user auth token
     */
    @SerializedName("token")
    private String userAuthToken;


    @SerializedName("StudentId")
    private String stdID;


    @SerializedName("OTP")
    private String opt;

    public UserModel() {

    }

    public UserModel(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }


    public UserModel(String name, String email, String phoneNumber, String stdID, String password, String confirmNewPassword) {
        this.userName = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.stdID = stdID;
        this.password = password;
        this.confirmNewPassword = confirmNewPassword;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }


    public boolean isPasswordLengthGreaterThan5() {
        return getPassword().length() >= 5;
    }

    public boolean isOldPasswordLengthGreaterThan5() {
        return getOldPassword().length() >= 5;
    }

    public boolean isNewPasswordLengthGreaterThan5() {
        return getNewPassword().length() >= 5;
    }

    public boolean isConfirmNewPasswordLengthGreaterThan5() {
        return getConfirmNewPassword().length() >= 5;
    }

    public String getUserAuthToken() {
        return userAuthToken;
    }

    public void setUserAuthToken(String userAuthToken) {
        this.userAuthToken = userAuthToken;
    }


    public String getStdID() {
        return stdID;
    }

    public void setStdID(String stdID) {
        this.stdID = stdID;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }
}
