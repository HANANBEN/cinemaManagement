package Services;


import Entities.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getAllPlaces();
    Place savePlace(Place place);
    Place editPlace(Place place);

    Place getPlaceById(Integer ID);

    void deletePlace(Place place);
    Long countPlace();
}
