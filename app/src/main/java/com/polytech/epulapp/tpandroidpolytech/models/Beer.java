package com.polytech.epulapp.tpandroidpolytech.models;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Epulapp on 29/12/2017.
 */

public class Beer {
    @SerializedName("id")
    public final String id;
    @SerializedName("name")
    public final String name;
    @SerializedName("abv")
    public final String abv;

    @SerializedName("image_url")
    public final String image_url;

    private Bitmap thumbnail;


    public Beer(String id, String name, String abv,String url) {
        this.id = id;
        this.name = name;
        this.abv=abv;
        this.image_url=url;
    }

    public void setImgBiere(Bitmap img){
        this.thumbnail = img;
    }

    public Bitmap getImgBiere(){
        return this.thumbnail;
    }
}
