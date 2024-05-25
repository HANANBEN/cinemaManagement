package web.ServicesImpl;

import web.Entities.Salle;
import web.Repositories.SalleRepository;
import web.Services.SalleService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImpl implements SalleService {
    private SalleRepository sallerep;
    
    public SalleServiceImpl(SalleRepository sallerep) {
		super();
		this.sallerep = sallerep;
	}

	@Override
    public List<Salle> getAllSalles() {
        return sallerep.findAll();
    }

    @Override
    public Salle saveSalle(Salle salle) {
        return sallerep.save(salle);
    }

    @Override
    public Salle getSalleById(Integer id) {
        return sallerep.findById(id).get();
    }

    @Override
    public Salle editSalle(Salle salle) {
        return sallerep.save(salle);
    }

    @Override
    public Long countSalle() {
        return sallerep.count();
    }

    @Override
    public void deleteSalleById(Integer id) {
        sallerep.deleteById(id);

    }
}
