package web.Services;


import java.util.List;

import web.Entities.Place;

public interface PlaceService {
    List<Place> getAllPlaces();
    Place savePlace(Place place);
    Place editPlace(Place place);

    Place getPlaceById(Integer ID);

    void deletePlace(Place place);
    Long countPlace();
}
