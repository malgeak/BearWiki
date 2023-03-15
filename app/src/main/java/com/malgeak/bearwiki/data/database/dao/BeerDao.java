package com.malgeak.bearwiki.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.malgeak.bearwiki.data.model.BeerModel;

import java.util.List;

@Dao
public interface BeerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveBeers(List<BeerModel> beersList);

    @Query("DELETE FROM Beers")
    void deleteAllBeers();

    @Query("SELECT * FROM Beers")
    List<BeerModel> getListBeers();

}
