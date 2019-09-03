package com.moontasirul.codebasedesignpattern.ui.splash;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import androidx.annotation.Nullable;

import com.moontasirul.codebasedesignpattern.R;
import com.moontasirul.codebasedesignpattern.ui.base_ui.BaseFragment;
import com.moontasirul.codebasedesignpattern.ui.base_ui.IControlWindowBar;
import com.moontasirul.codebasedesignpattern.ui.login.LoginFragment;
import com.moontasirul.codebasedesignpattern.utils.UtilityFunctions;


/**
 * Created by moontasirul on 6/05/2019.
 */

public class SplashFragment extends BaseFragment implements ISplashContractor.ISplashView {

    /**
     * Splash screen time
     */
    private static final int SPLASH_TIME = 3000;

    private ISplashContractor.ISplashPresenter mSplashPresenter;




   private Animation downToup, rightToLeft;

    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashPresenter = new SplashPresenter(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        UtilityFunctions.setStatusBarTransparent(getActivity(), true);
        controlledToolbar(false, (IControlWindowBar) getActivity());
        mSplashPresenter.waitSplashScreen(SPLASH_TIME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        return view;
    }

    @Override
    public void gotoHome() {

    }

    @Override
    public void gotToLogin() {
        if (getActivity() != null) {
//            if(!DataManager.getInstance().isUserLogin()){
//                UtilityFunctions.changedFragment(getActivity(), new LoginFragment(), false);
//            }else {
//                startActivity(new Intent(getActivity(), MainActivity.class));
//                getActivity().finish();
//            }
            UtilityFunctions.changedFragment(getActivity(), new LoginFragment(), false);
        }else {
            return;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
