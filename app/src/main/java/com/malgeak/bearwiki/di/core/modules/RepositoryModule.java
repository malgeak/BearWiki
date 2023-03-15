package com.malgeak.bearwiki.di.core.modules;

import com.malgeak.bearwiki.data.repository.beer.BeerRepositoryImpl;
import com.malgeak.bearwiki.data.repository.beer.datasource.BeerLocalDataSource;
import com.malgeak.bearwiki.data.repository.beer.datasource.BeerRemoteDataSource;
import com.malgeak.bearwiki.data.repository.login.LoginRepositoryImpl;
import com.malgeak.bearwiki.data.repository.login.datasource.LoginLocalDataSource;
import com.malgeak.bearwiki.domain.BeerRepository;
import com.malgeak.bearwiki.domain.LoginRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public BeerRepository provideBeerRepository(BeerLocalDataSource local, BeerRemoteDataSource remote){
        return new BeerRepositoryImpl(remote, local);
    }

    @Singleton
    @Provides
    public LoginRepository provideLoginRepository(LoginLocalDataSource local) {
        return new LoginRepositoryImpl(local);
    }
}
