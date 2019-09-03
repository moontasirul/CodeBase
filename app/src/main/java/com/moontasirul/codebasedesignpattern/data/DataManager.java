package com.moontasirul.codebasedesignpattern.data;

import androidx.annotation.NonNull;

import com.moontasirul.codebasedesignpattern.data.model.UserModel;
import com.moontasirul.codebasedesignpattern.data.prefs.IPreferenceHelper;
import com.moontasirul.codebasedesignpattern.data.prefs.PreferenceManager;
import com.moontasirul.codebasedesignpattern.data.remote.ApiManager;
import com.moontasirul.codebasedesignpattern.data.remote.IAPIDao;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.IRetroResponseCallback;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.ChangePasswordRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.LoginRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.OTPRequest;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.UserLogout;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.model.UserRegistration;


/**
 * Created by User Moon on 5/28/2019
 */

public class DataManager implements IAPIDao, IPreferenceHelper {
    /**
     * DataManager instance;
     */
    private static DataManager instance;


    /**
     * IVolleyApiHelper instance;
     */
    private IAPIDao mApiHelper;


    /**
     * IPreferenceHelper instance;
     */
    private IPreferenceHelper mPreferenceHelper;

    /**
     * Default contsructor
     */
    private DataManager() {
        mPreferenceHelper = PreferenceManager.getInstance();
        mApiHelper = ApiManager.getInstance();

    }

    /**
     * Invoke to get DataManager instance. If instance is null,
     * then create new object otherwise return previous one
     *
     * @return mInstance
     */
    public static DataManager getInstance() {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null)
                    instance = new DataManager();
            }
        }
        return instance;
    }

    @Override
    public String getAuthToken() {
        return mPreferenceHelper.getAuthToken();
    }

    @Override
    public void setAuthToken(@NonNull String token) {
        mPreferenceHelper.setAuthToken(token);
    }

    @Override
    public void saveUserInfo(@NonNull UserModel user) {
        mPreferenceHelper.saveUserInfo(user);
    }

    @Override
    public void removeUserInfo() {
        mPreferenceHelper.removeUserInfo();
    }

    @Override
    public boolean isLogin() {
        return mPreferenceHelper.isLogin();
    }

    @Override
    public String getUserName() {
        return mPreferenceHelper.getUserName();
    }

    @Override
    public String getUserId() {
        return mPreferenceHelper.getUserId();
    }

    @Override
    public String getUserEmail() {
        return mPreferenceHelper.getUserEmail();
    }

    @Override
    public String getUserPhone() {
        return mPreferenceHelper.getUserPhone();
    }

    @Override
    public String getTerminalId() {
        return mPreferenceHelper.getTerminalId();
    }

    @Override
    public void setTerminalId(@NonNull String terminalId) {
        mPreferenceHelper.setTerminalId(terminalId);
    }

    @Override
    public String getFcmToken() {
        return mPreferenceHelper.getFcmToken();
    }

    @Override
    public void setFcmToken(@NonNull String token) {
        mPreferenceHelper.setFcmToken(token);
    }

    @Override
    public void invokeLoginApi(LoginRequest body, IRetroResponseCallback callback) {
        mApiHelper.invokeLoginApi(body, callback);
    }

    @Override
    public void invokeRegistrationApi(UserRegistration body, IRetroResponseCallback callback) {
        mApiHelper.invokeRegistrationApi(body, callback);
    }

    @Override
    public void invokeOTPApi(OTPRequest body, IRetroResponseCallback callback) {
        mApiHelper.invokeOTPApi(body, callback);
    }

    @Override
    public void invokeLogoutApi(UserLogout logout, IRetroResponseCallback callback) {

    }

    @Override
    public void invokeChangePasswordApi(ChangePasswordRequest changePasswordRequest, IRetroResponseCallback callback) {

    }
}
