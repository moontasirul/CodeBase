package com.moontasirul.codebasedesignpattern.ui.login;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moontasirul.codebasedesignpattern.data.Repository;
import com.moontasirul.codebasedesignpattern.data.model.UserModel;
import com.moontasirul.codebasedesignpattern.data.remote.UserDao;
import com.moontasirul.codebasedesignpattern.data.remote.retrofit.ApiError;
import com.moontasirul.codebasedesignpattern.ui.base_ui.IBaseView;


public class LoginRegistrationViewModel extends ViewModel implements UserDao {
    // TODO: Implement the ViewModel

    public MutableLiveData<String> userName = new MutableLiveData<>();
    public MutableLiveData<String> stdId = new MutableLiveData<>();
    public MutableLiveData<String> userPhone = new MutableLiveData<>();
    public MutableLiveData<String> userEmail = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> confirmPassword = new MutableLiveData<>();


    public MutableLiveData<UserModel> userMutableLiveDataLogin;
    public MutableLiveData<UserModel> userMutableLiveDataRegister;
    public ViewListener mViewListener;

    private Activity activity;

    private Repository repository;

    private String entryType = "login";

    public void setmViewListener(ViewListener mViewListener, Activity activity) {
        this.mViewListener = mViewListener;
        this.activity = activity;
        repository = new Repository(this);
    }

    public MutableLiveData<UserModel> getUserForLogin() {

        if (userMutableLiveDataLogin == null) {
            userMutableLiveDataLogin = new MutableLiveData<>();
        }
        return userMutableLiveDataLogin;
    }


    public MutableLiveData<UserModel> getUserForRegister() {

        if (userMutableLiveDataRegister == null) {
            userMutableLiveDataRegister = new MutableLiveData<>();
        }
        return userMutableLiveDataRegister;
    }

    public void invokeLoginRequest(String userPhone, String password) {
        mViewListener.showProgress();
        repository.invokeUserLoginApi (userPhone, password);
    }

    public void invokeRegistrationRequest(String name, String userEmail, String phone, String stdId, String password) {
        mViewListener.showProgress();
        repository.invokeUserRegistrationApi(name, userEmail, phone, stdId, password);
    }


    public void onEntryType(String type) {
        Log.i("check radio", type + "");
        entryType = type;
        if (entryType.equalsIgnoreCase("login")) {
            mViewListener.isLogin(true);
        } else if (entryType.equalsIgnoreCase("signup")) {
            mViewListener.isLogin(false);
        }
    }

    public void loginOnClick(View view) {
        if (entryType.equalsIgnoreCase("login")) {
            UserModel user = new UserModel(userPhone.getValue(), password.getValue());
            userMutableLiveDataLogin.setValue(user);
        } else if (entryType.equalsIgnoreCase("signup")) {
            UserModel user = new UserModel(userName.getValue(), userEmail.getValue(), userPhone.getValue(), stdId.getValue(), password.getValue(), confirmPassword.getValue());
            userMutableLiveDataRegister.setValue(user);
        } else {
            Toast.makeText(activity, "Please fill the field.", Toast.LENGTH_LONG).show();
        }
    }


    public void loginViewOnclick(View view) {
        mViewListener.openLoginView();
    }

    public void registrationViewOnclick(View view) {
        mViewListener.openRegisterView();
    }

    @Override
    public void initiateData() {

    }

    @Override
    public void updateUI(String status) {
        mViewListener.hideProgress();
        if (status.equalsIgnoreCase("Login Successful.")){
            mViewListener.onLoginSuccess();
        }

    }

    @Override
    public void userRegistration(String status, UserModel userModel) {
        mViewListener.hideProgress();
        if((status.equalsIgnoreCase("Successful"))&&(userModel!= null)){

            mViewListener.onRegistrationSuccess(userModel);
        }
    }

    @Override
    public void errorMessage(ApiError error) {
        Log.i("check error", error.getMessage() + "");
    }

    @Override
    public void failMessage(Throwable throwable) {
        Log.i("check failMessage", throwable.getMessage() + "");
    }


    public interface ViewListener extends IBaseView {

        void onLoginSuccess();

        void onRegistrationSuccess(UserModel userModel);

        void onForgetPassword();

        void openLoginView();

        void openRegisterView();

        void isLogin(boolean userFlag);

    }
}
