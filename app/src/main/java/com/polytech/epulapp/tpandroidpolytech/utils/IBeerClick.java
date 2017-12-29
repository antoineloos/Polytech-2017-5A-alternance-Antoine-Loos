package com.polytech.epulapp.tpandroidpolytech.utils;

import android.view.View;

import com.polytech.epulapp.tpandroidpolytech.models.Beer;

import java.util.List;

/**
 * Created by Epulapp on 29/12/2017.
 */

public interface IBeerClick {
    public void onItemClick(View view, int index, List<Beer> lstBeers);
}
