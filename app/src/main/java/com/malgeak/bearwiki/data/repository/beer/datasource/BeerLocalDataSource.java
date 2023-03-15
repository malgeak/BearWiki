package com.malgeak.bearwiki.data.repository.beer.datasource;

import com.malgeak.bearwiki.data.model.BeerModel;

import java.util.List;

public interface BeerLocalDataSource {

    List<BeerModel> getBeerList();

    void saveBeerList(List<BeerModel> beerList);
}
