package com.moontasirul.codebasedesignpattern.data.remote;


import com.moontasirul.codebasedesignpattern.data.remote.retrofit.ApiError;

public interface HardwareDao {
    void initiateData();
    void updateUI(String status);
    void errorMessage(ApiError error);
    void faildMessage(Throwable throwable);
    void updateLocalDB(int numberOfRelay, String deviceId, String deviceTitle);
    void notifyUI();
}
