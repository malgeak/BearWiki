package com.malgeak.bearwiki.di.core.modules;

import com.malgeak.bearwiki.data.api.BeerApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private final String baseURL;

    public NetworkModule(String baseURL) {
        this.baseURL = baseURL;
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseURL)
                .build();
    }

    @Singleton
    @Provides
    public BeerApiService provideBeerApiService(Retrofit retrofit) {
        return retrofit.create(BeerApiService.class);
    }


}
