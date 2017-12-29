package com.polytech.epulapp.tpandroidpolytech.services;

import android.support.annotation.NonNull;

import com.polytech.epulapp.tpandroidpolytech.models.Beer;

import java.util.List;

/**
 * Created by Epulapp on 29/12/2017.
 */

public interface APICallback {
    void onSuccess(@NonNull List<Beer> value);

    void onError(@NonNull Throwable throwable);
}
