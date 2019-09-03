package com.moontasirul.codebasedesignpattern.data.remote;

import android.util.Log;

import com.moontasirul.codebasedesignpattern.data.remote.retrofit.ApiClient;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.IRetroApiHelper;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.IRetroResponseCallback;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.ResponseParser;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.ChangePasswordRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.LoginRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.OTPRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.UserLogout;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.UserRegistration;


public class ApiManager implements IAPIDao {

    private static final String TAG = ApiManager.class.getSimpleName();

    /**
     * Global instance of ApiManager
     */
    private static ApiManager mInstance;

    /**
     * Global retrofit client
     */
    private static IRetroApiHelper retroApiHelper;

    /**
     * Default private constructor
     */
    private ApiManager() {
        retroApiHelper = ApiClient.createApiClient(IRetroApiHelper.class);
    }

    /**
     * Invoke to get ApiManager instance. If instance is null,
     * then create new object otherwise return previous one
     *
     * @return mInstance
     */
    public static synchronized ApiManager getInstance() {
        if (mInstance == null) {
            mInstance = new ApiManager();
        }
        return mInstance;
    }


    @Override
    public void invokeLoginApi(LoginRequest body, IRetroResponseCallback callback) {
        new ResponseParser(callback).getResponse(retroApiHelper.invokeUserLogin(body));
    }

    @Override
    public void invokeRegistrationApi(UserRegistration body, IRetroResponseCallback callback) {
        new ResponseParser(callback).getResponse(retroApiHelper.invokeUserRegistration(body));
    }

    @Override
    public void invokeOTPApi(OTPRequest body, IRetroResponseCallback callback) {
        Log.i("checkOTPReq",body.getOtp());
        new ResponseParser(callback).getResponse(retroApiHelper.invokeOTP(body));
    }

    @Override
    public void invokeLogoutApi(UserLogout logout, IRetroResponseCallback callback) {

    }


    @Override
    public void invokeChangePasswordApi(ChangePasswordRequest changePasswordRequest, IRetroResponseCallback callback) {

    }
}
