package com.malgeak.bearwiki.di.core.modules;

import com.malgeak.bearwiki.data.api.BeerApiService;
import com.malgeak.bearwiki.data.database.dao.BeerDao;
import com.malgeak.bearwiki.data.repository.beer.datasource.BeerLocalDataSource;
import com.malgeak.bearwiki.data.repository.beer.datasource.BeerLocalDataSourceImpl;
import com.malgeak.bearwiki.data.repository.login.datasource.LoginLocalDataSource;
import com.malgeak.bearwiki.data.repository.login.datasource.LoginLocalDataSpurceImpl;
import com.malgeak.bearwiki.data.sharedpreference.LoginSharedPreference;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocalDataModule {

    @Singleton
    @Provides
    public BeerLocalDataSource provideBeerLocalDataSource(BeerDao dao) {
        return new BeerLocalDataSourceImpl(dao);
    }

    @Singleton
    @Provides
    public LoginLocalDataSource provideLoginLocalDataSource(LoginSharedPreference loginSharedPreference) {
        return new LoginLocalDataSpurceImpl(loginSharedPreference);
    }
}
