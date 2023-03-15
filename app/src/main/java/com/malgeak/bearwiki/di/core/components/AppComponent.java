package com.malgeak.bearwiki.di.core.components;

import android.app.Application;

import com.malgeak.bearwiki.di.beermenu.BeerMenuSubComponent;
import com.malgeak.bearwiki.di.core.modules.AppModule;
import com.malgeak.bearwiki.di.core.modules.DataBaseModule;
import com.malgeak.bearwiki.di.core.modules.LocalDataModule;
import com.malgeak.bearwiki.di.core.modules.NetworkModule;
import com.malgeak.bearwiki.di.core.modules.RemoteDataModule;
import com.malgeak.bearwiki.di.core.modules.RepositoryModule;
import com.malgeak.bearwiki.di.core.modules.SharedPreferenceModule;
import com.malgeak.bearwiki.di.login.LoginSubComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        DataBaseModule.class,
        LocalDataModule.class,
        NetworkModule.class,
        RemoteDataModule.class,
        RepositoryModule.class,
        SharedPreferenceModule.class
})
public interface AppComponent {

    LoginSubComponent.Factory loginSubComponent();

    BeerMenuSubComponent.Factory beerSubComponent();
}
