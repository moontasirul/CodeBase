package com.moontasirul.codebasedesignpattern.data.remote;

import com.moontasirul.codebasedesignpattern.data.model.UserModel;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.ApiError;

public interface UserDao {

    void initiateData();
    void updateUI(String status);
    void userRegistration(String status, UserModel userModel);
    void errorMessage(ApiError error);
    void failMessage(Throwable throwable);
}
