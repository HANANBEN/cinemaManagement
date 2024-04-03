package Services.Impl;

import Entities.SuperAdmin;
import Repositories.SuperAdminRepository;
import Services.SuperAdminService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuperAdminServiceImpl implements SuperAdminService {
    public SuperAdminServiceImpl(SuperAdminRepository superAdminRepository) {
        this.superAdminRepository = superAdminRepository;
    }

    private SuperAdminRepository superAdminRepository;
    @Override
    public List<SuperAdmin> getAllSuperAdmin() {
        return  superAdminRepository.findAll();
    }
}
