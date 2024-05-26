package com.example.demo.services;


import java.util.List;

import com.example.demo.entities.Place;

public interface PlaceService {
    List<Place> getAllPlaces();
    Place savePlace(Place place);
    Place editPlace(Place place);

    Place getPlaceById(Integer ID);

    void deletePlace(Place place);
    Long countPlace();
}
