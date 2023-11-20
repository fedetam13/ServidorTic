package proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.Clases.Aerolinea;
import proyecto.Repository.AerolineaRepository;

@Service
public class AerolineaService {
    @Autowired
    private AerolineaRepository aerolineaRepository;

    public boolean verificarAerolinea(String nombre){
        boolean verificar = aerolineaRepository.existsByNombre(nombre);
        return verificar;
    }

    public void agregarAerolinea(Aerolinea a){
        if(aerolineaRepository.existsByNombre(a.getNombre())){
            throw new RuntimeException("Entidad ya Existe");
        }
        aerolineaRepository.save(a);
    }
    public void borrarAerolinea(String string){
        boolean existe = aerolineaRepository.existsByNombre(string);
        if(!existe){
            throw new IllegalStateException("No existe Aeropuerto con ID " + string);
        }
        aerolineaRepository.deleteByNombre(string);
    }

    public boolean addAerolinea(Aerolinea aerolinea) {
        if(checkvalid(aerolinea)){
            if(aerolineaRepository.count()!=0){
                aerolinea.setIdAerolinea(aerolineaRepository.maxId()+1);}
            else{aerolinea.setIdAerolinea(1);}
            aerolineaRepository.save(aerolinea);
            return true;
        }
        return false;
    }

    private boolean checkvalid(Aerolinea aerolinea) {
        return true;
    }

    public Aerolinea getAerolineaById(int idAerolinea) {

        return aerolineaRepository.getAerolineaByIdAerolinea(idAerolinea);
    }

    public Aerolinea getAerolineaByNombre(String nombre) {
        return aerolineaRepository.getAerolineaByNombre(nombre);
    }
}
