package com.malgeak.bearwiki.data.repository.beer.datasource;

import com.malgeak.bearwiki.data.database.dao.BeerDao;
import com.malgeak.bearwiki.data.model.BeerModel;

import java.util.List;

public class BeerLocalDataSourceImpl implements BeerLocalDataSource{

    private final BeerDao beerDao;

    public BeerLocalDataSourceImpl(BeerDao beerDao) {
        this.beerDao = beerDao;
    }

    @Override
    public List<BeerModel> getBeerList() {
        return beerDao.getListBeers();
    }

    @Override
    public void saveBeerList(List<BeerModel> beerList) {
        beerDao.saveBeers(beerList);
    }
}
