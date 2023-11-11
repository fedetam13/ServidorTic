package proyecto.RestControllers;


import org.springframework.beans.factory.annotation.Autowired;
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

        if(vuelosPendientes.size()>0){
            return ResponseEntity.ok(vuelosPendientes);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
