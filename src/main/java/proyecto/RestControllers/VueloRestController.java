package proyecto.RestControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.Clases.Aeropuerto;
import proyecto.Clases.Vuelo;
import proyecto.Services.AeropuertoService;
import proyecto.Services.VueloService;

import java.util.List;

@RestController
@RequestMapping("/vuelo")
public class VueloRestController {

    @Autowired
    private VueloService vueloService;
    @Autowired
    private AeropuertoService aeropuertoService;

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

        if(v==null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(v);
        }
    }

    @PutMapping("/update")
    ResponseEntity<Vuelo> updateVuelo(@RequestParam(name="idVuelo")int idVuelo,@RequestBody Vuelo vuelo){
        Vuelo v = vueloService.getVueloById(idVuelo);

        if(v==null){
            return ResponseEntity.notFound().build();
        }

        v.setAprovacionPartida(vuelo.getAprovacionPartida());
        v.setAprovacionArribo(vuelo.getAprovacionArribo());

        if(vueloService.agregarVuelo(v)) {
            return ResponseEntity.ok(v);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
