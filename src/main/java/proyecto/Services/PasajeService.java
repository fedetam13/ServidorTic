package proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.Repository.PasajeRepository;

@Service
public class PasajeService {
    @Autowired
    private PasajeRepository pasajeRepository;
}
