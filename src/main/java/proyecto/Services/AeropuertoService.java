package proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.Clases.Aeropuerto;
import proyecto.Repository.AeropuertoRepository;

import java.util.List;

@Service
public class AeropuertoService {
    private final AeropuertoRepository aeropuertoRepository;

    @Autowired
    public AeropuertoService(AeropuertoRepository aeropuertoRepository) {
        this.aeropuertoRepository = aeropuertoRepository;
    }

    public void addAeropuerto(Aeropuerto aeropuerto) {
        if(isValid(aeropuerto)){
            if(aeropuertoRepository.count()!=0){
                aeropuerto.setIdAeropuerto(aeropuertoRepository.maxId()+1);}
            else{aeropuerto.setIdAeropuerto(1);}
            aeropuertoRepository.save(aeropuerto);
        }

    }

    private boolean isValid(Aeropuerto a){
        return true;
    }

    public List<Aeropuerto> getAllAeropuertos(){
        return aeropuertoRepository.findAll();
    }

    public void agregarAeropuerto(Aeropuerto a){
        if(aeropuertoRepository.existsByIata(a.getIata())){
            throw new RuntimeException("Entidad ya Existe");
        }
        aeropuertoRepository.save(a);
    }

    public void borrarAeropuerto(int id){
        boolean existe = aeropuertoRepository.existsById(id);
        if(!existe){
            throw new IllegalStateException("No existe Aeropuerto con ID " + id);
        }
        aeropuertoRepository.deleteById(id);
    }

    public List<Aeropuerto> getAeropuertosByUbicacion(String ubicacion) {
        return aeropuertoRepository.getAeropuertosByUbicacion(ubicacion);
    }

    public Aeropuerto getAeropuertoByNombre(String nombreAeropuerto){
        return aeropuertoRepository.getAeropuertoByNombre(nombreAeropuerto);
    }

    public Aeropuerto getAeropuertoById(int idAeropuerto) {
        return aeropuertoRepository.getAeropuertoByIdAeropuerto(idAeropuerto);
    }
}
