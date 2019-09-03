package com.moontasirul.codebasedesignpattern.data.remote.retrofit;


/**
 * Created by User Moon on 5/28/2019
 */

public interface IRetroResponseCallback {

    <T> void onSuccessResponse(T response);

    void onErrorResponse(ApiError error);

    // void onFailedResponse(String errorMsg);

    void onFailedResponse(Throwable t);
}
