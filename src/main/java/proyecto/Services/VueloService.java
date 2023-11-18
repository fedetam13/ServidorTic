package proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import proyecto.Clases.Vuelo;
import proyecto.Repository.VueloRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class VueloService {
    @Autowired
    private VueloRepository vueloRepository;

    public boolean agregarVuelo(Vuelo v) {
        if(v.getIdVuelo()!=0){
            vueloRepository.save(v);
            return true;
        }
        if(vueloRepository.count()!=0) {
            v.setIdVuelo(vueloRepository.maxId() + 1);
        }else{
            v.setIdVuelo(1);
        }
        vueloRepository.save(v);
        return true;
    }

    public List<Vuelo> getPendientesForAirport(int idArribo,int idPartida) {
        List<Vuelo> pendientes = new ArrayList<>();
        List<Vuelo> pendientesArribos = vueloRepository.getVuelosByAprovacionArriboAndIdAeropuertoArribo("-",idArribo);
        List<Vuelo> pendientesPartidas = vueloRepository.getVuelosByAprovacionPartidaAndIdAeropuertoPartida("-",idPartida);

        pendientes.addAll(pendientesArribos);
        pendientes.addAll(pendientesPartidas);

        return pendientes;
    }

    public List<Vuelo> getNoPendientesForAirport(int idArribo,int idPartida) {
        List<Vuelo> noPendientes = new ArrayList<>();

        List<Vuelo> rechazadosArribos = vueloRepository.getVuelosByAprovacionArriboAndIdAeropuertoArribo("R",idArribo);
        List<Vuelo> aprovadosArribos = vueloRepository.getVuelosByAprovacionArriboAndIdAeropuertoArribo("A",idArribo);
        List<Vuelo> rechazadosPartidas = vueloRepository.getVuelosByAprovacionPartidaAndIdAeropuertoPartida("R",idPartida);
        List<Vuelo> aprovadosPartidas = vueloRepository.getVuelosByAprovacionPartidaAndIdAeropuertoPartida("A",idPartida);

        noPendientes.addAll(rechazadosArribos);
        noPendientes.addAll(aprovadosArribos);
        noPendientes.addAll(rechazadosPartidas);
        noPendientes.addAll(aprovadosPartidas);

        return noPendientes;
    }

    public Vuelo getVueloById(int idVuelo) {
        return vueloRepository.getVueloByIdVuelo(idVuelo);
    }

    public List<Integer> getPuertasOcupadasArribo(int idVuelo) {
        List<Integer> puertasOcupadas = new ArrayList<>();

        Vuelo vuelo = vueloRepository.getVueloByIdVuelo(idVuelo);
        List<Vuelo> allVuelos = vueloRepository.getVuelosByAprovacionArriboAndIdAeropuertoArribo("A",vuelo.getIdAeropuertoArribo());

        for(Vuelo v : allVuelos){
            for(Vuelo u : allVuelos){
                if(v.getPuertaDeArribo()==u.getPuertaDeArribo()&&v.getIdVuelo()!=u.getIdVuelo()){
                    if(!v.getHoraDeArribo().isAfter(u.getHoraDeArribo())){

                        LocalDateTime finishV = v.getHoraDeArribo().plusMinutes(30);
                        LocalDateTime finishVuelo = vuelo.getHoraDeArribo().plusMinutes(30);

                        if(finishV.isAfter(vuelo.getHoraDeArribo()) || finishVuelo.isAfter(u.getHoraDeArribo())){
                            puertasOcupadas.add(v.getPuertaDeArribo());
                        }
                    }
                }
            }
            if(!v.getHoraDeArribo().isAfter(vuelo.getHoraDeArribo())){
                LocalDateTime finishV = v.getHoraDeArribo().plusMinutes(30);

                if(!vuelo.getHoraDeArribo().isAfter(finishV)){
                    puertasOcupadas.add(v.getPuertaDeArribo());
                }
            }

            LocalDateTime finishVuelo = vuelo.getHoraDeArribo().plusMinutes(30);

            if(finishVuelo.isAfter(v.getHoraDeArribo())){
                if(finishVuelo.isBefore(v.getHoraDeArribo())){
                    puertasOcupadas.add(v.getPuertaDeArribo());
                }
            }

        }

        return puertasOcupadas;

    }

    public List<Integer> getPuertasOcupadasPartida(int idVuelo) {
        List<Integer> puertasOcupadas = new ArrayList<>();

        Vuelo vuelo = vueloRepository.getVueloByIdVuelo(idVuelo);
        List<Vuelo> allVuelos = vueloRepository.getVuelosByAprovacionPartidaAndIdAeropuertoPartida("A",vuelo.getIdAeropuertoPartida());

        for(Vuelo u : allVuelos){
            for(Vuelo v : allVuelos){
                if(v.getPueretaDeEmbarque()==u.getPueretaDeEmbarque()&&v.getIdVuelo()!=u.getIdVuelo()){
                    if(!v.getHoraDePartida().isAfter(u.getHoraDePartida())){

                        LocalDateTime finishV = v.getHoraDePartida().plusMinutes(60);
                        LocalDateTime finishVuelo = vuelo.getHoraDePartida().plusMinutes(60);

                        if(finishV.isAfter(vuelo.getHoraDePartida()) || finishVuelo.isBefore(u.getHoraDePartida())){
                            puertasOcupadas.add(v.getPueretaDeEmbarque());

                        }
                    }
                }
            }


            if(!u.getHoraDePartida().isAfter(vuelo.getHoraDePartida())){
                LocalDateTime finishU = u.getHoraDePartida().plusMinutes(60);

                if(!vuelo.getHoraDePartida().isAfter(finishU)){
                    puertasOcupadas.add(u.getPueretaDeEmbarque());
                    continue;
                }
            }

            LocalDateTime finishVuelo = vuelo.getHoraDePartida().plusMinutes(60);

            if(finishVuelo.isAfter(u.getHoraDePartida())){
                if(finishVuelo.isBefore(u.getHoraDePartida())){
                    puertasOcupadas.add(u.getPueretaDeEmbarque());
                }
            }


        }

        return puertasOcupadas;
    }

    public List<Vuelo> getVuelosFromTo(int idOrigen, int idDestino) {
        List<Vuelo> vuelosPosibles = vueloRepository.getVuelosByIdAeropuertoPartidaAndIdAeropuertoArribo(idOrigen, idDestino);
        List<Vuelo> vuelosAceptados = new ArrayList<>();

        for(Vuelo v : vuelosPosibles){
            if(Objects.equals(v.getAprovacionPartida(),"A") && Objects.equals(v.getAprovacionArribo(),"A")){
                vuelosAceptados.add(v);
            }
        }

        return vuelosAceptados;
    }

}
