package com.example.videosearch;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.videosearch.dependecyInject.component.ApplicationComponent;
import com.example.videosearch.dependecyInject.component.DaggerApplicationComponent;
import com.example.videosearch.dependecyInject.module.GifModule;
import com.example.videosearch.model.RetroAPI;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GifApplication extends Application {

    private static RetroAPI retroAPI;
    private static ApplicationComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initRetrofit();
        initDagger();
    }

    private void initDagger() {
        sAppComponent = DaggerApplicationComponent.builder()
                .gifModule(new GifModule())
                .build();
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retroAPI = retrofit.create(RetroAPI.class);
    }

    public static RetroAPI getApi() {
        return retroAPI;
    }

    @NonNull
    public static ApplicationComponent getAppComponent() {
        return sAppComponent;
    }

    private OkHttpClient getClient() {
        return new OkHttpClient
                .Builder()
                .build();
    }
}
