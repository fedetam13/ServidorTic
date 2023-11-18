package proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.Clases.Pasaje;
import proyecto.Repository.PasajeRepository;

import java.util.List;

@Service
public class PasajeService {
    @Autowired
    private PasajeRepository pasajeRepository;

    public boolean agregarPasaje(Pasaje pasaje) {
        if(!pasajeRepository.existsByIdUsuarioAndIdVuelo(pasaje.getIdUsuario(), pasaje.getIdVuelo())){
            if(pasajeRepository.count()==0){
                pasaje.setIdPasaje(1);
            }else{
                pasaje.setIdPasaje(pasajeRepository.maxId()+1);
            }
            pasajeRepository.save(pasaje);
            return true;
        }
        return false;
    }

    public List<Pasaje> getPasajesByUserId(int idUsuario) {
        return pasajeRepository.getPasajesByIdUsuario(idUsuario);
    }
}
