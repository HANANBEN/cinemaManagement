package Services;

import Entities.Boulvard;
import Entities.Projectionfilm;

import java.util.List;

public interface ProjectionfilmService {
    public List<Projectionfilm> getAllProjections();
    public  Projectionfilm saveProjectionfilm(Projectionfilm projectionfilm);
    public Projectionfilm getProjectionfilmById(Integer id);
    public Projectionfilm editProjectionfilm(Projectionfilm projectionfilm);
    public Long countProjectionfilm();
    public void deleteProjectionfilmById(Integer id);
}
