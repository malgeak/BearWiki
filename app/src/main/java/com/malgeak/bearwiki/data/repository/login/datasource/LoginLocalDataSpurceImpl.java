package com.malgeak.bearwiki.data.repository.login.datasource;

import com.malgeak.bearwiki.data.sharedpreference.LoginSharedPreference;

public class LoginLocalDataSpurceImpl implements LoginLocalDataSource{

    private final LoginSharedPreference loginSharedPreference;

    public LoginLocalDataSpurceImpl(LoginSharedPreference loginSharedPreference) {
        this.loginSharedPreference = loginSharedPreference;
    }

    @Override
    public void saveName(String name) {
        loginSharedPreference.setUserName(name);
    }

    @Override
    public void savePassword(String password) {
        loginSharedPreference.setUserPassword(password);
    }

    @Override
    public String getName() {
        return loginSharedPreference.getUserName();
    }

    @Override
    public String getPassword() {
        return loginSharedPreference.getUserPassword();
    }
}
