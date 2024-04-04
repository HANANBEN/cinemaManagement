package Services;

import Entities.SuperAdmin;

import java.util.List;

public interface SuperAdminService {
    public List<SuperAdmin> getAllSuperAdmins();
    public  SuperAdmin saveSuperadmin(SuperAdmin superadmin);
    public SuperAdmin getSuperadminById(Integer id);
    public SuperAdmin editSuperadmin(SuperAdmin superadmin);
    public Long countSuperadmin();
    public void deleteSuperadminById(Integer id);


}
