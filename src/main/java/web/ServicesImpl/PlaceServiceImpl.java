package web.ServicesImpl;

import web.Entities.Place;
import web.Repositories.PlaceRepository;
import web.Services.PlaceService;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlaceServiceImpl implements PlaceService {
    PlaceRepository placerep;
  @Override
   public List<Place> getAllPlaces() {
        return placerep.findAll();
    }

    @Override
    public Place savePlace(Place place) {
        return placerep.save(place);
    }

    @Override
    public Place editPlace(Place place) {
        return placerep.save(place);
    }

    @Override
    public Place getPlaceById(Integer ID) {
        return placerep.findById(ID).get();
    }

    @Override
    public void deletePlace(Place place) {
        placerep.delete(place);
    }

    @Override
    public Long countPlace() {
        return placerep.count();
    }
}
