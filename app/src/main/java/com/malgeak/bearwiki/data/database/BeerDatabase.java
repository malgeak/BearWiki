package com.malgeak.bearwiki.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.malgeak.bearwiki.data.database.converters.Converters;
import com.malgeak.bearwiki.data.database.dao.BeerDao;
import com.malgeak.bearwiki.data.model.BeerModel;

@Database(entities = {BeerModel.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
abstract public class BeerDatabase extends RoomDatabase {

    abstract public BeerDao beerDao();
}
