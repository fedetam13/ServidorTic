package proyecto.RestControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.Clases.Aeropuerto;
import proyecto.Clases.Avion;
import proyecto.Clases.Vuelo;
import proyecto.Services.AeropuertoService;
import proyecto.Services.AvionService;
import proyecto.Services.VueloService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vuelo")
public class VueloRestController {

    @Autowired
    private VueloService vueloService;
    @Autowired
    private AeropuertoService aeropuertoService;
    @Autowired
    private AvionService avionService;


    @PostMapping("/post")
    ResponseEntity<Vuelo> addVuelo(@RequestBody Vuelo vuelo){
        if(vueloService.agregarVuelo(vuelo)){
            return ResponseEntity.ok(vuelo);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getPendientes")
    ResponseEntity<List<Vuelo>> getPendientesForAirline(@RequestParam(name="nombreAeropuerto")String nombreAeropuerto){
        Aeropuerto a = aeropuertoService.getAeropuertoByNombre(nombreAeropuerto);

        List<Vuelo> vuelosPendientes = vueloService.getPendientesForAirport(a.getIdAeropuerto(),a.getIdAeropuerto());

        return ResponseEntity.ok(vuelosPendientes);

    }

    @GetMapping("/getNoPendientes")
    ResponseEntity<List<Vuelo>> getNoPendientesForAirline(@RequestParam(name="nombreAeropuerto")String nombreAeropuerto){
        Aeropuerto a = aeropuertoService.getAeropuertoByNombre(nombreAeropuerto);

        List<Vuelo> vuelosNoPendientes = vueloService.getNoPendientesForAirport(a.getIdAeropuerto(),a.getIdAeropuerto());

        return ResponseEntity.ok(vuelosNoPendientes);

    }

    @GetMapping("/getById")
    ResponseEntity<Vuelo> updateVuelo(@RequestParam(name="idVuelo")int idVuelo){
        Vuelo v = vueloService.getVueloById(idVuelo);

        return ResponseEntity.ok(v);

    }

    @PutMapping("/update")
    ResponseEntity<Vuelo> updateVuelo(@RequestParam(name="idVuelo")int idVuelo,@RequestBody Vuelo vuelo){
        Vuelo v = vueloService.getVueloById(idVuelo);

        if(v==null){
            return ResponseEntity.notFound().build();
        }

        v.setAprovacionPartida(vuelo.getAprovacionPartida());
        v.setAprovacionArribo(vuelo.getAprovacionArribo());
        v.setPueretaDeEmbarque(vuelo.getPueretaDeEmbarque());
        v.setPuertaDeArribo(vuelo.getPuertaDeArribo());

        if(vueloService.agregarVuelo(v)) {
            return ResponseEntity.ok(v);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/getPuertasOcupadasArribo")
    ResponseEntity<List<Integer>> puertasOcupadasArribo(@RequestParam(name="idVuelo")int idVuelo){
        List<Integer> puertasOcupadas = vueloService.getPuertasOcupadasArribo(idVuelo);

        return ResponseEntity.ok(puertasOcupadas);
    }

    @GetMapping("/getPuertasOcupadasPartida")
    ResponseEntity<List<Integer>> puertasOcupadaspartida(@RequestParam(name="idVuelo")int idVuelo){
        List<Integer> puertasOcupadas = vueloService.getPuertasOcupadasPartida(idVuelo);

        return ResponseEntity.ok(puertasOcupadas);
    }

    @GetMapping("/getVuelosAceptadosFromTo")
    ResponseEntity<List<Vuelo>> getVuelosFromTo(@RequestParam(name = "aOrigen")int idOrigen,@RequestParam(name = "aDestino")int idDestino){
        List<Vuelo> vuelosFromTo = vueloService.getVuelosFromTo(idOrigen,idDestino);

        return ResponseEntity.ok(vuelosFromTo);
    }

    @PutMapping("/addCounter")
    ResponseEntity<Vuelo> addCounter(@RequestParam(name = "idVuelo")int idVuelo){
        Vuelo v = vueloService.getVueloById(idVuelo);
        Avion a = avionService.getAvionByMatricula(v.getMatriculaAvion());

        if(v.getOcupados()<a.getCapacidad()){
            v.setOcupados(v.getOcupados()+1);
            vueloService.agregarVuelo(v);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();

    }
}
