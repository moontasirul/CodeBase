package com.moontasirul.codebasedesignpattern.ui.base_ui;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LifecycleObserver;

public class CodeBaseDesignPatternApp extends Application implements LifecycleObserver {

    private static CodeBaseDesignPatternApp mInstance;

    public static CodeBaseDesignPatternApp getInstance(){
        return mInstance;
    }

    public static Context getAppContext(){
        return mInstance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
