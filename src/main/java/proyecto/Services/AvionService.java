package proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.Clases.Avion;
import proyecto.Repository.AvionRepository;

import java.util.List;

@Service
public class AvionService {
    @Autowired
    private AvionRepository avionRepository;

    public void agregarAvion(Avion a){
        if(avionRepository.existsByMatricula(a.getMatricula())){
            throw new RuntimeException("Entidad ya Existe");
        }
        avionRepository.save(a);
    }

    public boolean VerificacionDeAvion (String matricula){
        boolean verificar = avionRepository.existsByMatricula(matricula);
        return verificar;
    }

    public List<Avion> getAvionesByNombreAerolinea(String nombreAerolinea) {
        return avionRepository.getAvionsByNombreAerolinea(nombreAerolinea);
    }
}
