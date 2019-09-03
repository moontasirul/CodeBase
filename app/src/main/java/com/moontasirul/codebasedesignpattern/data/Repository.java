package com.moontasirul.codebasedesignpattern.data;

import android.util.Log;

import com.moontasirul.codebasedesignpattern.data.remote.UserDao;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.ApiError;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.IRetroResponseCallback;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.LoginRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.LoginResponse;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.OTPRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.OTPResponse;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.RegistrationResponse;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.UserRegistration;


public class Repository implements IRetroResponseCallback {


    private UserDao userDao;


    public Repository(UserDao userDao) {
        this.userDao = userDao;
    }


    public void invokeUserRegistrationApi(String userName, String userEmail, String userPhone, String stdId, String password) {
        UserRegistration userRegistration = new UserRegistration(userName, userEmail, userPhone, stdId, password);
        DataManager.getInstance().invokeRegistrationApi(userRegistration, this);
    }


    public void invokeUserLoginApi(String userPhone, String password) {
        LoginRequest userLogin = new LoginRequest(userPhone, password);
        DataManager.getInstance().invokeLoginApi(userLogin, this);
    }



    public void invokeOTPApi(String otp) {
        OTPRequest otpRequest = new OTPRequest(otp);
        Log.i("chekOTP_Repo",otpRequest.getOtp());
        DataManager.getInstance().invokeOTPApi(otpRequest, this);
    }

    @Override
    public <T> void onSuccessResponse(T response) {
        try {
            if (response instanceof RegistrationResponse) {
                RegistrationResponse baseResponse = (RegistrationResponse) response;

                userDao.userRegistration(baseResponse.getStatus(), baseResponse.getUserModel());
            }else if(response instanceof LoginResponse){
                LoginResponse loginResponse = (LoginResponse) response;
                userDao.updateUI(loginResponse.getLoginResponse());
            }else if (response instanceof OTPResponse){
                OTPResponse otpResponse = (OTPResponse) response;
                userDao.updateUI(otpResponse.getOtpStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    @Override
    public void onErrorResponse(ApiError error) {
        userDao.errorMessage(error);
    }

    @Override
    public void onFailedResponse(Throwable t) {

    }
}
