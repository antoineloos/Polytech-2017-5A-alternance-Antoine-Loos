package com.polytech.epulapp.tpandroidpolytech.services;

import com.polytech.epulapp.tpandroidpolytech.models.Beer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Epulapp on 29/12/2017.
 */

public interface IBeerService {
    @GET("beers/")
    Call<List<Beer>> getBeers();
}
