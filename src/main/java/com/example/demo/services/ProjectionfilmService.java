package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.entities.*;

public interface ProjectionfilmService {
    public List<Projectionfilm> getAllProjections();
    public  Projectionfilm saveProjectionfilm(Projectionfilm projectionfilm);
    public Projectionfilm getProjectionfilmById(Integer id);
    public Projectionfilm editProjectionfilm(Projectionfilm projectionfilm);
    public Long countProjectionfilm();
    public void deleteProjectionfilmById(Integer id);
	List<Projectionfilm> findByFilmTitre(String titre);
	List<Projectionfilm> findByDateprojection(Date dateprojection);
	List<Projectionfilm> findByFilmTitreAndDateprojection(String titre, Date dateprojection);
}
