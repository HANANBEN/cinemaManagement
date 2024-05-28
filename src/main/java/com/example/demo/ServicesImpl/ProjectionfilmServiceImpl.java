package com.example.demo.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.*;
import com.example.demo.repository.ProjectionfilmRepository;
import com.example.demo.services.ProjectionfilmService;

import java.util.Date;
import java.util.List;

@Service
public class ProjectionfilmServiceImpl implements ProjectionfilmService {
    private ProjectionfilmRepository projectionfilmrep;
    
    
    @Autowired
    public ProjectionfilmServiceImpl(ProjectionfilmRepository projectionfilmrep) {
		super();
		this.projectionfilmrep = projectionfilmrep;
	}

	@Override
    public List<Projectionfilm> getAllProjections() {
        return  projectionfilmrep.findAll();
    }

    @Override
    public Projectionfilm saveProjectionfilm(Projectionfilm projectionfilm) {
        return projectionfilmrep.save( projectionfilm);
    }
    
    @Override
    public List<Projectionfilm> findByFilmTitre(String titre) {
        return projectionfilmrep.findByFilmTitre(titre);
    }

    @Override
    public List<Projectionfilm> findByDateprojection(Date dateprojection) {
        return projectionfilmrep.findByDateprojection(dateprojection);
    }

    @Override
    public List<Projectionfilm> findByFilmTitreAndDateprojection(String titre, Date dateprojection) {
        return projectionfilmrep.findByFilmTitreAndDateprojection(titre, dateprojection);
    }
    
    

    @Override
    public Projectionfilm getProjectionfilmById(Integer id) {
        return projectionfilmrep.findById(id).get();
    }

    @Override
    public Projectionfilm editProjectionfilm(Projectionfilm projectionfilm) {
        return projectionfilmrep.save(projectionfilm);
    }

    @Override
    public Long countProjectionfilm() {
        return projectionfilmrep.count();
    }

    @Override
    public void deleteProjectionfilmById(Integer id) {
        projectionfilmrep.deleteById(id);

    }
}
