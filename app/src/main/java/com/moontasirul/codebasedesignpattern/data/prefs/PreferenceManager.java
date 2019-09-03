package com.moontasirul.codebasedesignpattern.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.moontasirul.codebasedesignpattern.data.model.UserModel;
import com.moontasirul.codebasedesignpattern.ui.base_ui.CodeBaseDesignPatternApp;
import com.moontasirul.codebasedesignpattern.utils.Constant;


public class PreferenceManager implements IPreferenceHelper {

    private static PreferenceManager mInstance;
    // SharedPreference name key
    private final String PREFERENCE_NAME = "customer_preference";
    // Authentication token key
    private final String CUSTOMER_AUTH_TOKEN = "customer_auth_token";
    // FCM token key
    private final String FCM_TOKEN = "fcm_token";
    // SharedPreference login status key
    private final String PREFERENCE_LOGIN_STATUS = "customer_login_status";
    // SharedPreference user id key
    private final String PREFERENCE_USER_ID = "jt_customer_preference_user_id";
    // SharedPreference user name key
    private final String PREFERENCE_USER_NAME = "customer_name";
    // SharedPreference email key
    private final String PREFERENCE_USER_EMAIL = "jt_customer_preference_user_email";
    // SharedPreference phone key
    private final String PREFERENCE_USER_PHONE = "jt_customer_preference_user_phone";
    // SharedPreference and Editor instance
    private SharedPreferences sharedPreferences;

    /**
     * Default constactor
     */
    private PreferenceManager() {
        sharedPreferences = CodeBaseDesignPatternApp.getAppContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Invoke to get/retrieve PreferenceManager instance. If instance is null
     * then create new instance otherwise return previous one
     *
     * @return mInstance
     */
    public static synchronized PreferenceManager getInstance() {
        if (mInstance == null) {
            mInstance = new PreferenceManager();
        }
        return mInstance;
    }

    /**
     * Invoke to get authentication token
     *
     * @return string
     */
    @Override
    public String getAuthToken() {
        return sharedPreferences.getString(CUSTOMER_AUTH_TOKEN, null);
    }

    /**
     * Invoke to set/save authentication token after login
     *
     * @param token String
     */
    @Override
    public void setAuthToken(String token) {
        sharedPreferences.edit().putString(CUSTOMER_AUTH_TOKEN, token).commit();
    }

    /**
     * Invoke to set/save user info after login
     *
     * @param user
     */
    @Override
    public void saveUserInfo(@NonNull UserModel user) {
        if (user == null) return;
        sharedPreferences.edit()
                .putString(PREFERENCE_USER_NAME, user.getUserName())
                .putString(PREFERENCE_USER_ID, user.getUserId())
                .putString(PREFERENCE_USER_EMAIL, user.getEmail())
                .putString(PREFERENCE_USER_PHONE, user.getPhoneNumber())
                .putString(CUSTOMER_AUTH_TOKEN, user.getUserAuthToken())
                .putBoolean(PREFERENCE_LOGIN_STATUS, true)
                .apply();
    }

    @Override
    public void removeUserInfo() {
        sharedPreferences.edit()
                .remove(PREFERENCE_USER_NAME)
                .remove(PREFERENCE_USER_ID)
                .remove(PREFERENCE_USER_EMAIL)
                .remove(PREFERENCE_USER_PHONE)
                .remove(CUSTOMER_AUTH_TOKEN)
                .remove(PREFERENCE_LOGIN_STATUS)
                .apply();
    }

    /**
     * Invoke to get login status
     */
    @Override
    public boolean isLogin() {
        return sharedPreferences.getBoolean(PREFERENCE_LOGIN_STATUS, false);
    }

    @Override
    public String getUserName() {
        return sharedPreferences.getString(PREFERENCE_USER_NAME, null);
    }

    /**
     * Invoke to get user id
     *
     * @return string
     */
    @Override
    public String getUserId() {
        return sharedPreferences.getString(PREFERENCE_USER_ID, null);
    }

    @Override
    public String getUserEmail() {
        return sharedPreferences.getString(PREFERENCE_USER_EMAIL, null);
    }

    @Override
    public String getUserPhone() {
        return sharedPreferences.getString(PREFERENCE_USER_PHONE, null);
    }

    /**
     * Invoke to retrieve deviceId/terminalId/MacAddress
     *
     * @return string
     */
    @Override
    public String getTerminalId() {
        return sharedPreferences.getString(Constant.TERMINAL_ID, null);
    }

    /**
     * Invoke to save deviceId/terminalId/MacAddress
     *
     * @param terminalId String
     */
    @Override
    public void setTerminalId(String terminalId) {
        sharedPreferences.edit().putString(Constant.TERMINAL_ID, terminalId).commit();
    }

    /**
     * Invoke to retrieve FCM Token
     *
     * @return string
     */
    @Override
    public String getFcmToken() {
        return sharedPreferences.getString(FCM_TOKEN, null);
    }

    /**
     * Invoke to save FirebaseToken
     *
     * @param token string
     */
    @Override
    public void setFcmToken(@NonNull String token) {
        sharedPreferences.edit().putString(FCM_TOKEN, token).commit();
    }

}
