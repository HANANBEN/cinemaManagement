package com.example.demo.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.*;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.SeanceRepository;
import com.example.demo.services.SeanceService;

import java.util.Date;
import java.util.List;
@Service

public class SeanceServiceImpl implements SeanceService {
    private SeanceRepository seancerep;
    @Autowired
    public SeanceServiceImpl(SeanceRepository seancerep) {
		super();
		this.seancerep = seancerep;
	}

	@Override
    public List<Seance> getAllSeances() {
        return  seancerep.findAll();
    }

    @Override
    public Seance saveSeance(Seance seance) {
        return seancerep.save(seance);
    }

    @Override
    public Seance getSeanceById(Integer id) {
        return seancerep.findById(id).get();
    }

    @Override
    public Seance editSeance(Seance seance) {
        return seancerep.save(seance);
    }

    @Override
    public Long countSeance() {
        return seancerep.count();
    }

    @Override
    public void deleteSeanceById(Integer id) {
        seancerep.deleteById(id);
    }

	@Override
	public List<Seance> findByProjectionfilmDateprojection(Date date) {
		// TODO Auto-generated method stub
		return seancerep.findByProjectionfilmDateprojection(date);
	}

	@Override
	public List<Seance> findByProjectionfilm(Projectionfilm projfilm) {
		
		return seancerep.findByProjectionfilm(projfilm);
	}
}
