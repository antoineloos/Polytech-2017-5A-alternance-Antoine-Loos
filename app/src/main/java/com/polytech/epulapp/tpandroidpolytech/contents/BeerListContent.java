package com.polytech.epulapp.tpandroidpolytech.contents;

import com.polytech.epulapp.tpandroidpolytech.models.Beer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BeerListContent {


    public static final List<Beer> ITEMS = new ArrayList<Beer>();


    public static final Map<String, Beer> ITEM_MAP = new HashMap<String, Beer>();



    private static void addItem(Beer item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }






}
