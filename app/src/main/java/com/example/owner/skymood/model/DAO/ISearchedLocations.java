package com.example.owner.skymood.model.DAO;

import com.example.owner.skymood.model.SearchedLocation;

import java.util.ArrayList;

public interface ISearchedLocations {

    ArrayList<SearchedLocation> getAllSearchedLocations();
    long insertSearchedLocation(SearchedLocation location);
    SearchedLocation selectFirstSearchedCity();
    long getCount();
    long checkCity(String city);
    long insertLocation(SearchedLocation location);
    long updateLocation(long id, SearchedLocation location);
}
