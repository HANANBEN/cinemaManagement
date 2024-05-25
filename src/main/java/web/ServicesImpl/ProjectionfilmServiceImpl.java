package web.ServicesImpl;

import web.Entities.Projectionfilm;
import web.Repositories.ProjectionfilmRepository;
import web.Services.ProjectionfilmService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectionfilmServiceImpl implements ProjectionfilmService {
    private ProjectionfilmRepository projectionfilmrep;
    
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
