package com.malgeak.bearwiki.data.repository.beer;

import android.util.Log;

import com.malgeak.bearwiki.data.model.BeerModel;
import com.malgeak.bearwiki.data.repository.beer.datasource.BeerLocalDataSource;
import com.malgeak.bearwiki.data.repository.beer.datasource.BeerRemoteDataSource;
import com.malgeak.bearwiki.domain.BeerRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class BeerRepositoryImpl implements BeerRepository {
    public final String TAG = this.getClass().getName();

    private final BeerRemoteDataSource remoteDataSource;
    private final BeerLocalDataSource localDataSource;

    public BeerRepositoryImpl(BeerRemoteDataSource remoteDataSource, BeerLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public List<BeerModel> getBeers() {
        return getBeersFromLocalSource();
    }

    @Override
    public List<BeerModel> updateBeerList() {
        return getBeersFromRemoteSource();
    }

    private List<BeerModel> getBeersFromRemoteSource() {
        List<BeerModel> listOfBeers = new ArrayList<>();

        try {
            Response<List<BeerModel>> response = remoteDataSource.getBeerList(1);

            if (response.body() != null) {
                listOfBeers = response.body();
            }
        } catch (Exception exc) {
            Log.e(TAG, exc.getMessage().toString());
        }

        if (listOfBeers.size() > 0) {
            localDataSource.saveBeerList(listOfBeers);
        }

        return listOfBeers;
    }

    private List<BeerModel> getBeersFromLocalSource() {
        List<BeerModel> listOfBeers = new ArrayList<>();

        try {
            listOfBeers = localDataSource.getBeerList();
        } catch (Exception exc) {
            Log.e(TAG, exc.getMessage().toString());
        }

        if (listOfBeers.size() <= 0) {
            listOfBeers = getBeersFromRemoteSource();
        }

        return listOfBeers;
    }
}
