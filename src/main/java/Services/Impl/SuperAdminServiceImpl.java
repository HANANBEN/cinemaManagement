package Services.Impl;

import Entities.SuperAdmin;
import Repositories.SuperAdminRepository;
import Services.SuperAdminService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuperAdminServiceImpl implements SuperAdminService {
    public SuperAdminServiceImpl(SuperAdminRepository superAdminRepository) {
        this.superadminrep= superAdminRepository;
    }

    private SuperAdminRepository superadminrep;
    @Override
    public List<SuperAdmin> getAllSuperAdmins() {
        return  superadminrep.findAll();
    }

    @Override
    public SuperAdmin saveSuperadmin(SuperAdmin superadmin) {
        return superadminrep.save(superadmin);
    }

    @Override
    public SuperAdmin getSuperadminById(Integer id) {
        return  superadminrep.findById(id).get();
    }

    @Override
    public SuperAdmin editSuperadmin(SuperAdmin superadmin) {
        return superadminrep.save(superadmin);
    }

    @Override
    public Long countSuperadmin() {
        return superadminrep.count();
    }

    @Override
    public void deleteSuperadminById(Integer id) {
        superadminrep.deleteById(id);
    }
}
