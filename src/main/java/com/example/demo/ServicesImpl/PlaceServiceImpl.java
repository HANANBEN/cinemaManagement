package com.example.demo.ServicesImpl;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Place;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.services.PlaceService;

import java.util.List;
@Service
public class PlaceServiceImpl implements PlaceService {
    PlaceRepository placerep;
    
  public PlaceServiceImpl(PlaceRepository placerep) {
		super();
		this.placerep = placerep;
	}

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
