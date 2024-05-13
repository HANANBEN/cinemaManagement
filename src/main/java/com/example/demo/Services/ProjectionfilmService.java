package com.example.demo.Services;

import com.example.demo.Entities.*;

import java.util.List;
import java.util.Optional;

public interface ProjectionfilmService {
    public List<Projectionfilm> getAllProjections();
    public  Projectionfilm saveProjectionfilm(Projectionfilm projectionfilm);
    public Projectionfilm getProjectionfilmById(Integer id);
    public Projectionfilm editProjectionfilm(Projectionfilm projectionfilm);
    public Long countProjectionfilm();
    public void deleteProjectionfilmById(Integer id);
}
