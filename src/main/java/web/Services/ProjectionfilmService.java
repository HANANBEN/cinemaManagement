package web.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import web.Entities.Boulvard;
import web.Entities.Projectionfilm;

@Service
public interface ProjectionfilmService {
    public List<Projectionfilm> getAllProjections();
    public  Projectionfilm saveProjectionfilm(Projectionfilm projectionfilm);
    public Projectionfilm getProjectionfilmById(Integer id);
    public Projectionfilm editProjectionfilm(Projectionfilm projectionfilm);
    public Long countProjectionfilm();
    public void deleteProjectionfilmById(Integer id);
}
