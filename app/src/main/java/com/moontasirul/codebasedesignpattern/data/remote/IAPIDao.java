package com.moontasirul.codebasedesignpattern.data.remote;

import com.moontasirul.codebasedesignpattern.data.remote.retrofit.IRetroResponseCallback;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.ChangePasswordRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.LoginRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.OTPRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.UserLogout;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.UserRegistration;


public interface IAPIDao {
    void invokeLoginApi(LoginRequest body, IRetroResponseCallback callback);

    void invokeRegistrationApi(UserRegistration body, IRetroResponseCallback callback);

    void invokeOTPApi(OTPRequest body, IRetroResponseCallback callback);

    void invokeLogoutApi(UserLogout logout, IRetroResponseCallback callback);

    void invokeChangePasswordApi(ChangePasswordRequest changePasswordRequest, IRetroResponseCallback callback);
}
