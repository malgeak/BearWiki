package com.malgeak.bearwiki.data.sharedpreference;

import android.content.SharedPreferences;

public class LoginSharedPreference {

    private final SharedPreferences loginSharedPreference;
    private final SharedPreferences.Editor editor;

    private final String NAME = "NAME";
    private final String PASSWORD = "PASSWORD";

    public LoginSharedPreference(SharedPreferences loginSharedPreference) {
        this.loginSharedPreference = loginSharedPreference;
        this.editor = loginSharedPreference.edit();
    }

    public void setUserName(String name) {
        editor.putString(NAME, name);
        editor.apply();
    }

    public void setUserPassword(String password) {
        editor.putString(PASSWORD, password);
        editor.apply();
    }

    public String getUserName() {
        return loginSharedPreference.getString(NAME, null);
    }

    public String getUserPassword() {
        return loginSharedPreference.getString(PASSWORD, null);
    }
}
