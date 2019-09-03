package com.moontasirul.codebasedesignpattern.ui.login;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.moontasirul.codebasedesignpattern.R;
import com.moontasirul.codebasedesignpattern.data.model.UserModel;
import com.moontasirul.codebasedesignpattern.databinding.LoginFragmentNewBinding;
import com.moontasirul.codebasedesignpattern.ui.base_ui.BaseFragment;
import com.moontasirul.codebasedesignpattern.utils.UtilityFunctions;

import java.util.Objects;

public class LoginFragment extends BaseFragment implements LoginRegistrationViewModel.ViewListener {

    private LoginRegistrationViewModel loginRegistrationViewModel;

    private LoginFragmentNewBinding loginFragmentNewBinding;
    private boolean isLogin;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginRegistrationViewModel = ViewModelProviders.of(this).get(LoginRegistrationViewModel.class);
        loginRegistrationViewModel.setmViewListener(this, getActivity());

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //  return inflater.inflate(R.layout.login_fragment_new, container, false);

        loginFragmentNewBinding = DataBindingUtil.inflate(inflater,
                R.layout.login_fragment_new, container, false);

        loginFragmentNewBinding.setLifecycleOwner(this);
        loginFragmentNewBinding.setLoginRegistrationViewModel(loginRegistrationViewModel);
        View view = loginFragmentNewBinding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel

        loginRegistrationViewModel.getUserForLogin().observe(getActivity(), new Observer<UserModel>() {

            @Override
            public void onChanged(@Nullable UserModel userModel) {
                if (TextUtils.isEmpty(Objects.requireNonNull(userModel).getPhoneNumber())) {
                    loginFragmentNewBinding.textInputLayoutPhone.setError("Enter an Phone");
                    loginFragmentNewBinding.textInputLayoutPhone.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(userModel).getPassword())) {
                    loginFragmentNewBinding.textInputLayoutPassword.setError("Enter Password");
                    loginFragmentNewBinding.textInputLayoutPassword.requestFocus();
                } else if (!userModel.isPasswordLengthGreaterThan5()) {
                    loginFragmentNewBinding.textInputLayoutPassword.setError("Enter at least 6 Digit password");
                    loginFragmentNewBinding.textInputLayoutPassword.requestFocus();
                } else {
                    Log.i("check_repo", "onChanged");
                    //    DataManager.getInstance().setTerminalId(UtilityFunctions.getDeviceId(getActivity()));
                    loginRegistrationViewModel.invokeLoginRequest(userModel.getPhoneNumber(), userModel.getPassword());
                    //onLoginSuccess();

                }
            }
        });


        loginRegistrationViewModel.getUserForRegister().observe(getActivity(), new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel userModel) {
                if (TextUtils.isEmpty(Objects.requireNonNull(userModel).getUserName())) {
                    loginFragmentNewBinding.textInputLayoutUserName.setError("Enter an Name");
                    loginFragmentNewBinding.textInputLayoutUserName.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(userModel).getEmail())) {
                    loginFragmentNewBinding.textInputLayoutEmail.setError("Enter an Email");
                    loginFragmentNewBinding.textInputLayoutEmail.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(userModel).getPhoneNumber())) {
                    loginFragmentNewBinding.textInputLayoutPhone.setError("Enter an Phone");
                    loginFragmentNewBinding.textInputLayoutPhone.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(userModel).getStdID())) {
                    loginFragmentNewBinding.textInputLayoutStdId.setError("Enter Student Id");
                    loginFragmentNewBinding.textInputLayoutStdId.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(userModel).getPassword())) {
                    loginFragmentNewBinding.textInputLayoutPassword.setError("Enter Password");
                    loginFragmentNewBinding.textInputLayoutPassword.requestFocus();
                } else if (!userModel.isPasswordLengthGreaterThan5()) {
                    loginFragmentNewBinding.textInputLayoutPassword.setError("Enter at least 6 Digit password");
                    loginFragmentNewBinding.textInputLayoutPassword.requestFocus();
                } else if (TextUtils.isEmpty(Objects.requireNonNull(userModel).getConfirmNewPassword())) {
                    loginFragmentNewBinding.textInputLayoutConfirmPassword.setError("Enter Confirm Password");
                    loginFragmentNewBinding.textInputLayoutConfirmPassword.requestFocus();
                } else if (!userModel.isPasswordLengthGreaterThan5()) {
                    loginFragmentNewBinding.textInputLayoutConfirmPassword.setError("Enter at least 6 Digit password");
                    loginFragmentNewBinding.textInputLayoutConfirmPassword.requestFocus();
                } else if (!userModel.getPassword().equalsIgnoreCase(userModel.getConfirmNewPassword())) {
                    loginFragmentNewBinding.textInputLayoutConfirmPassword.setError("Password and Confirm Password does not match.");
                    loginFragmentNewBinding.textInputLayoutConfirmPassword.requestFocus();
                } else {
                    Log.i("check_repo", "onChanged");
                    //    DataManager.getInstance().setTerminalId(UtilityFunctions.getDeviceId(getActivity()));
                    loginRegistrationViewModel.invokeRegistrationRequest(userModel.getUserName(),
                            userModel.getEmail(), userModel.getPhoneNumber(),
                            userModel.getStdID(), userModel.getPassword());
                      // onLoginSuccess();

                }

            }
        });
    }

    @Override
    public void onLoginSuccess() {

         //startActivity(new Intent(getActivity(), MainActivity.class));
    }

    @Override
    public void onRegistrationSuccess(UserModel userModel) {
        Log.i("checkOTP", userModel.getOpt());
        //UtilityFunctions.changedFragment(getActivity(), OTPFragment.newInstance(userModel.getOpt()), true);
    }


    @Override
    public void onForgetPassword() {

    }

    @Override
    public void openLoginView() {
        loginFragmentNewBinding.textInputLayoutUserName.setVisibility(View.GONE);
        loginFragmentNewBinding.textInputLayoutConfirmPassword.setVisibility(View.GONE);
        loginFragmentNewBinding.textInputLayoutEmail.setVisibility(View.GONE);
        loginFragmentNewBinding.textInputLayoutStdId.setVisibility(View.GONE);
        loginFragmentNewBinding.viewSignup.setVisibility(View.GONE);
        loginFragmentNewBinding.viewSignin.setVisibility(View.VISIBLE);
        loginRegistrationViewModel.onEntryType("login");

        loginFragmentNewBinding.textInputLayoutPassword.setText("");
        loginFragmentNewBinding.textInputLayoutPhone.setText("");
    }

    @Override
    public void openRegisterView() {
        loginFragmentNewBinding.textInputLayoutUserName.setVisibility(View.VISIBLE);
        loginFragmentNewBinding.textInputLayoutConfirmPassword.setVisibility(View.VISIBLE);
        loginFragmentNewBinding.textInputLayoutEmail.setVisibility(View.VISIBLE);
        loginFragmentNewBinding.textInputLayoutStdId.setVisibility(View.VISIBLE);
        loginFragmentNewBinding.viewSignup.setVisibility(View.VISIBLE);
        loginFragmentNewBinding.viewSignin.setVisibility(View.GONE);
        loginRegistrationViewModel.onEntryType("signup");


        loginFragmentNewBinding.textInputLayoutUserName.setText("");
        loginFragmentNewBinding.textInputLayoutEmail.setText("");
        loginFragmentNewBinding.textInputLayoutConfirmPassword.setText("");
        loginFragmentNewBinding.textInputLayoutPhone.setText("");
        loginFragmentNewBinding.textInputLayoutPassword.setText("");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            loginFragmentNewBinding.textInputLayoutPassword.restoreDefaultFocus();
        }
    }

    @Override
    public void isLogin(boolean userFlag) {
        isLogin = userFlag;
    }

    @Override
    public void showProgress() {
        UtilityFunctions.showProgressBar(getActivity());
    }

    @Override
    public void hideProgress() {
        UtilityFunctions.stopProgressBar(getActivity());
    }
}
