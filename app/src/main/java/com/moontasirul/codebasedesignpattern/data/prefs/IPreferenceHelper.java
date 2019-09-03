package com.moontasirul.codebasedesignpattern.data.prefs;

import androidx.annotation.NonNull;

import com.moontasirul.codebasedesignpattern.data.model.UserModel;

public interface IPreferenceHelper {
    String getAuthToken();

    void setAuthToken(@NonNull String token);

    void saveUserInfo(@NonNull UserModel user);

    void removeUserInfo();

    boolean isLogin();

    String getUserName();

    String getUserId();

    String getUserEmail();

    String getUserPhone();

    String getTerminalId();

    void setTerminalId(@NonNull String terminalId);

    String getFcmToken();

    void setFcmToken(@NonNull String token);

}
