package com.malgeak.bearwiki.presentation.ui;


import android.app.Application;

import com.malgeak.bearwiki.di.Injector;
import com.malgeak.bearwiki.di.beermenu.BeerMenuSubComponent;
import com.malgeak.bearwiki.di.core.components.AppComponent;
import com.malgeak.bearwiki.di.core.components.DaggerAppComponent;
import com.malgeak.bearwiki.di.core.modules.AppModule;
import com.malgeak.bearwiki.di.core.modules.LocalDataModule;
import com.malgeak.bearwiki.di.core.modules.NetworkModule;
import com.malgeak.bearwiki.di.core.modules.RemoteDataModule;
import com.malgeak.bearwiki.di.core.modules.RepositoryModule;
import com.malgeak.bearwiki.di.core.modules.SharedPreferenceModule;
import com.malgeak.bearwiki.di.login.LoginSubComponent;
import com.malgeak.bearwiki.utils.ConstantsUtils;

public class MainApplication extends Application implements Injector {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .networkModule(new NetworkModule(ConstantsUtils.URL_WEB))
                .remoteDataModule(new RemoteDataModule())
                .localDataModule(new LocalDataModule())
                .repositoryModule(new RepositoryModule())
                .sharedPreferenceModule(new SharedPreferenceModule())
                .build();
    }

    @Override
    public LoginSubComponent createLoginSubcomponent() {
        return appComponent.loginSubComponent().create();
    }

    @Override
    public BeerMenuSubComponent createBeerSubcomponent() {
        return appComponent.beerSubComponent().create();
    }


}
