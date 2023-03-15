package com.malgeak.bearwiki.data.api;

import com.malgeak.bearwiki.data.model.BeerModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BeerApiService {

    @GET("beers")
    Call<List<BeerModel>> getBeerList(@Query("page") int page);
}
