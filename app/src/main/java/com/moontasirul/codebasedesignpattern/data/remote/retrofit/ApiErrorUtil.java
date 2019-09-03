package com.moontasirul.codebasedesignpattern.data.remote.retrofit;


import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 *
 */

public class ApiErrorUtil {

    public static ApiError parseError(Response<?> response) {
        ApiError error;
        try {
            Converter<ResponseBody, ApiError> converter = ApiClient.getRetrofit()
                    .responseBodyConverter(ApiError.class, new Annotation[0]);
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            error = new ApiError();
        }
        return error;
    }
}
