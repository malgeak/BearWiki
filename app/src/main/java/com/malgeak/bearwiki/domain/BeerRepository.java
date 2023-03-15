package com.malgeak.bearwiki.domain;

import com.malgeak.bearwiki.data.model.BeerModel;

import java.util.List;

public interface BeerRepository {

    List<BeerModel> getBeers();

    List<BeerModel> updateBeerList();
}
