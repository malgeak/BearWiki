package com.malgeak.bearwiki.di.core.modules;

import android.content.Context;

import androidx.room.Room;

import com.malgeak.bearwiki.data.database.BeerDatabase;
import com.malgeak.bearwiki.data.database.dao.BeerDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {

    @Singleton
    @Provides
    public BeerDatabase provideBeerDataBase(Context context) {
        return Room.databaseBuilder(context, BeerDatabase.class, "beerdbclient")
                .build();
    }

    @Singleton
    @Provides
    public BeerDao provideBeerDao(BeerDatabase db) {
        return db.beerDao();
    }
}
