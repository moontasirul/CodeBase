package com.moontasirul.codebasedesignpattern.data.remote.retrofit;



import com.moontasirul.codebasedesignpattern.data.remote.ApiUrls;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.BaseResponse;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.ChangePasswordRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.ChangePasswordResponse;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.LoginRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.LoginResponse;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.OTPRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.OTPResponse;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.RegistrationResponse;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.UserLogout;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.UserRegistration;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IRetroApiHelper {

    @POST(ApiUrls.LOGIN_API_URL)
    Call<LoginResponse> invokeLoginApi(@Body LoginRequest body);

    @POST(ApiUrls.REGISTRATION_API_URL)
    Call<LoginResponse> invokeRegistrationApi(@Body LoginRequest body);

    @POST(ApiUrls.CUSTOMER_LOGOUT_API_URL)
    Call<BaseResponse> invokeLogoutApi(@Body UserLogout logout);


    @POST(ApiUrls.CHANGE_PASSWORD_API)
    Call<ChangePasswordResponse> invokeChangePasswordApi(@Body ChangePasswordRequest changePasswordRequest);


    @POST(ApiUrls.REGISTRATION_API)
    Call<RegistrationResponse> invokeUserRegistration(@Body UserRegistration userRegistration);

    @POST(ApiUrls.LOGIN_API)
    Call<LoginResponse> invokeUserLogin(@Body LoginRequest loginRequest);

    @POST(ApiUrls.OTP_API)
    Call<OTPResponse> invokeOTP(@Body OTPRequest otpRequest);
}
