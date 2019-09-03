package com.moontasirul.codebasedesignpattern.ui.splash;

import android.os.Handler;


/**
 * Created by moontasirul on 2/01/2019.
 */


public class SplashPresenter implements ISplashContractor.ISplashPresenter {

    private ISplashContractor.ISplashView iSplashView;

    public SplashPresenter(ISplashContractor.ISplashView iSplashView) {
        this.iSplashView = iSplashView;
    }



    @Override
    public void waitSplashScreen(int timeInMillisecond) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (iSplashView != null) {
                    iSplashView.gotToLogin();
                }
            }
        }, timeInMillisecond);
    }
}
