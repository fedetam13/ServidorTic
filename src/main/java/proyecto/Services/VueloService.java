package proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import proyecto.Clases.Vuelo;
import proyecto.Repository.VueloRepository;

import java.util.List;

@Controller
public class VueloService {
    @Autowired
    private VueloRepository vueloRepository;

    public boolean agregarVuelo(Vuelo v) {
        if(vueloRepository.count()!=0) {
            v.setIdVuelo(vueloRepository.maxId() + 1);
        }else{
            v.setIdVuelo(1);
        }
        vueloRepository.save(v);
        return true;
    }

    public List<Vuelo> getPendientesForAirport(int idArribo,int idPartida) {
        return vueloRepository.getVuelosByIdAeropuertoArriboOrIdAeropuertoPartida(idArribo,idPartida);
    }
}
