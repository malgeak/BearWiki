package com.malgeak.bearwiki.di.core.modules;

import com.malgeak.bearwiki.data.api.BeerApiService;
import com.malgeak.bearwiki.data.repository.beer.datasource.BeerRemoteDataSource;
import com.malgeak.bearwiki.data.repository.beer.datasource.BeerRemoteDataSourceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RemoteDataModule {

    @Singleton
    @Provides
    public static BeerRemoteDataSource provideRemoteDataSource(BeerApiService service) {
        return new BeerRemoteDataSourceImpl(service);
    }
}
