package com.example.rpl2016_04.myapplication;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import okhttp3.OkHttpClient;

/**
 * Created by RPL2016-04 on 10/15/2019.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).build();
        AndroidNetworking.initialize(this, okHttpClient);
    }
}
