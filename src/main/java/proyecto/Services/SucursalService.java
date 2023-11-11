package proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.Repository.SucursalRepository;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;
}
