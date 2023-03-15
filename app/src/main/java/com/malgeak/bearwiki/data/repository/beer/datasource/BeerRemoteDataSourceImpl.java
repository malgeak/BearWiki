package com.malgeak.bearwiki.data.repository.beer.datasource;

import com.malgeak.bearwiki.data.api.BeerApiService;
import com.malgeak.bearwiki.data.model.BeerModel;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class BeerRemoteDataSourceImpl  implements BeerRemoteDataSource{

    private final BeerApiService beerApiService;

    public BeerRemoteDataSourceImpl(BeerApiService beerApiService) {
        this.beerApiService = beerApiService;
    }

    @Override
    public Response<List<BeerModel>> getBeerList(int page) {
        try {
            return beerApiService.getBeerList(page).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
