package web.Services;

import java.util.List;

import web.Entities.Salle;
import web.Entities.SuperAdmin;

public interface SalleService {
    public List<Salle> getAllSalles();
    public  Salle saveSalle(Salle salle);
    public Salle getSalleById(Integer id);
    public Salle editSalle(Salle salle);
    public Long countSalle();
    public void deleteSalleById(Integer id);
}
