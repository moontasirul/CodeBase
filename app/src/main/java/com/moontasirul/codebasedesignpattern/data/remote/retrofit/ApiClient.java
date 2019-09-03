package com.moontasirul.codebasedesignpattern.data.remote.retrofit;


import com.moontasirul.codebasedesignpattern.data.remote.ApiUrls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AtomAP Ltd. 23/02/2018.
 */

public class ApiClient {

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(ApiUrls.BASE_API_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static HttpLoggingInterceptor interceptor =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static <T> T createApiClient(Class<T> serviceClass) {
        if (!httpClient.interceptors().contains(interceptor)) {
            httpClient.addInterceptor(interceptor);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

}
