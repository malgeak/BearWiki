package com.malgeak.bearwiki.data.repository.beer.datasource;

import com.malgeak.bearwiki.data.model.BeerModel;

import java.util.List;
import retrofit2.Response;

public interface BeerRemoteDataSource {

    Response<List<BeerModel>> getBeerList(int page);
}
