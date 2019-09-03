package com.moontasirul.codebasedesignpattern.ui.splash;

/**
 * Created by moontasirul on 2/01/2019.
 */

public interface ISplashContractor {

    interface ISplashView {
        void gotoHome();
        void gotToLogin();
    }

    interface ISplashPresenter {
        void waitSplashScreen(int timeInMillisecond);
    }
}
