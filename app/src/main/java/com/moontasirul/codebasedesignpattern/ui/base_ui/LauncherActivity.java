package com.moontasirul.codebasedesignpattern.ui.base_ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.moontasirul.codebasedesignpattern.R;
import com.moontasirul.codebasedesignpattern.ui.login.LoginFragment;
import com.moontasirul.codebasedesignpattern.ui.splash.SplashFragment;
import com.moontasirul.codebasedesignpattern.utils.Constant;


public class LauncherActivity extends AppCompatActivity implements IControlWindowBar{
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        initializedToolbar();
        attachedFragment(savedInstanceState);
    }

    /**
     * Invoke to attached fragment while activity is launched
     *
     * @param savedInstanceState
     */
    private void attachedFragment(Bundle savedInstanceState) {



        Fragment fragment;

        boolean isLogout = getIntent().getBooleanExtra(Constant.BUNDLE_KEY_LOGOUT, false);
        if (isLogout) {
            fragment = new LoginFragment();
        } else {
            fragment = new SplashFragment();
        }


        getSupportFragmentManager().beginTransaction().add(R.id.container,
                fragment, Constant.CURRENT_FRAGMENT).commit();


//
//        if (getIntent() != null) {
//            if (savedInstanceState == null) {
//                getSupportFragmentManager().beginTransaction().add(R.id.container,
//                        new SplashFragment(), Constant.CURRENT_FRAGMENT).commit();
//            }
//        }
    }

    private void initializedToolbar() {
//        mToolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(mToolbar);
    }

    /**
     * Invoke to get current attached fragment
     *
     * @return fragment instance
     */
    private Fragment getCurrentFragment() {
        Log.i("getCurrentFragment", "called");
        return getSupportFragmentManager().findFragmentByTag(Constant.CURRENT_FRAGMENT);

    }

    @Override
    public void showToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
        }
    }

    @Override
    public void hideToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }


    @Override
    public void setTitleText(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void showBackArrow() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void hideBackArrow() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public void onBackPressed() {

        Fragment fragment = getCurrentFragment();
       if ((fragment instanceof LoginFragment)) {
            finish();
        }  else {
            if (!((BaseFragment) fragment).popFragment()) {
                super.onBackPressed();
            }
        }
    }
}
