package com.polytech.epulapp.tpandroidpolytech.services;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.polytech.epulapp.tpandroidpolytech.models.Beer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Epulapp on 29/12/2017.
 */

public class BeerAccessService {
    private static final BeerAccessService ourInstance = new BeerAccessService();
    private static Retrofit retrofit = null;
    public static BeerAccessService getInstance() {
        return ourInstance;
    }

    private BeerAccessService() {
    }

    public void GetApiData(final Context context, final View view,final @Nullable APICallback callback ){

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.punkapi.com/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        IBeerService beerService = retrofit.create(IBeerService.class);

        Call<List<Beer>> call = beerService.getBeers();
        call.enqueue(new Callback<List<Beer>>() {
            @Override
            public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {



                final List<Beer> beers = response.body();

                if(beers.size()>0){if (callback != null) callback.onSuccess(beers);}
            }

            @Override
            public void onFailure(Call<List<Beer>> call, Throwable t) {
                Log.d( "OnFailure","Error " );
                if (callback != null)
                    callback.onError(t);
            }
        });



    }
}
