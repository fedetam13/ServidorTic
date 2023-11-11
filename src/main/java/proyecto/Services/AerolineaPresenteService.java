package proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.Repository.AerolineaPresenteRepository;

@Service
public class AerolineaPresenteService {
    @Autowired
    private AerolineaPresenteRepository aerolineaPresenteRepository;
}
