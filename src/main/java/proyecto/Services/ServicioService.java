package proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.Clases.Servicio;
import proyecto.Repository.ServicioRepository;

import java.util.List;

@Service
public class ServicioService {
    private final ServicioRepository servicioRepository;

    @Autowired
    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public List<Servicio> getServicios(){
        return servicioRepository.findAll();
    }

    public void agregarServicio(Servicio s){
        servicioRepository.save(s);
    }

    public void borrarServicio(int id){
        servicioRepository.deleteById(id);
    }
}
