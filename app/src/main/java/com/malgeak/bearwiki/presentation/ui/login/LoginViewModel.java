package com.malgeak.bearwiki.presentation.ui.login;

import android.view.View;

import androidx.databinding.Bindable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.malgeak.bearwiki.domain.LoginRepository;
import com.malgeak.bearwiki.presentation.ui.base.BaseViewModel;
import com.malgeak.bearwiki.utils.ValidationsUtils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.internal.Util;


public class LoginViewModel  extends BaseViewModel {

    private final LoginRepository loginRepository;

    private MutableLiveData<String> userName;
    public MutableLiveData<Boolean> userNameError;
    public MutableLiveData<Boolean> passwordError;
    public MutableLiveData<Boolean> login;

    public LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
        userName = new MutableLiveData<>();
        login = new MutableLiveData<>();
        userNameError = new MutableLiveData<>();
        passwordError = new MutableLiveData<>();
        setUserName(loginRepository.getUserName());
    }

    public void setUserName(String text) {
        userName.setValue(text);
    }

    public LiveData<String> getUserName() {
        return userName;
    }

    public LiveData<Boolean> getUserNameError() {
        return userNameError;
    }
    public LiveData<Boolean> getPasswordError() {
        return passwordError;
    }

    public LiveData<Boolean> getLogin() {
        return login;
    }

    public void signup(String name, String password) {
        setLoader(true);
        getCompositeDisposable().add(Single.fromCallable(() -> loginRepository.saveUser(name, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    setLoader(false);
                    login.setValue(response);
                }, throwable -> {
                    setLoader(false);
                    setAlertMessage(throwable.getMessage());
                }));
    }

    public void login(String password) {
        setLoader(true);
        getCompositeDisposable().add(Single.fromCallable(() -> loginRepository.validUserCredentials(password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    setLoader(false);
                    if (response) {
                        passwordError.setValue(true);
                        login.setValue(response);
                    } else {
                        passwordError.setValue(false);
                    }
                }, throwable -> {
                    setLoader(false);
                    setAlertMessage(throwable.getMessage());
                }));
    }


    public int hideUserNameField() {
        return userName.getValue() == null ? View.VISIBLE : View.GONE;
    }

    public void onClickButton(String name, String password) {
        if (userName.getValue() == null) {
            if (validSignUp(name, password)) {
                signup(name, password);
            }
        } else {
            login(password);
        }
    }

    private Boolean validSignUp(String name, String password) {
        userNameError.setValue(ValidationsUtils.validName(name));
        passwordError.setValue(ValidationsUtils.validPassword(password));
        if (userNameError.getValue() && passwordError.getValue()) {
            return true;
        }

        return false;
    }
}
