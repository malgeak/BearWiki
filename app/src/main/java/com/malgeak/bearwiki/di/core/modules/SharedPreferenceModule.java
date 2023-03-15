package com.malgeak.bearwiki.di.core.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.malgeak.bearwiki.data.sharedpreference.LoginSharedPreference;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferenceModule {

    @Singleton
    @Provides
    public LoginSharedPreference provideLoginSharedPreference(Context context) {
        return new LoginSharedPreference(context.getSharedPreferences("login", Context.MODE_PRIVATE));
    }
}
