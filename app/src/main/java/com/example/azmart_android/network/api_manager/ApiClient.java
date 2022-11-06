package com.example.azmart_android.network.api_manager;

import com.example.azmart_android.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    private static Retrofit retrofit1;

    private static OkHttpClient okClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    Request newRequest = request.newBuilder()
                            .addHeader("x-rapidapi-host", "magic-aliexpress1.p.rapidapi.com")
                            //.addHeader("x-rapidapi-key", "620382942bmsh9db47da95b73ee2p1fa611jsn6bf26de851b1")
                            .addHeader("x-rapidapi-key", "1016dbd964msh96d4653c4c3c82bp119f9fjsn29132d20b88d")
                            .build();
                    return chain.proceed(newRequest);
                })
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }


    public static Retrofit getClientServerApi() {

        if (retrofit1 == null) {
            retrofit1 = new Retrofit.Builder()
                    .baseUrl(BuildConfig.API_URL)
                    .client(okClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit1;
    }


}
