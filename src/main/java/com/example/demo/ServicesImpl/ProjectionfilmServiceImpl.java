package com.example.demo.ServicesImpl;

import com.example.demo.Entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.ProjectionfilmRepository;
import com.example.demo.Services.ProjectionfilmService;

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
