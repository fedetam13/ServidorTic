package proyecto.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.Clases.Aeropuerto;
import proyecto.Services.AeropuertoService;

import java.util.List;

@RestController
@RequestMapping("/aeropuerto")
public class AeropuertoRestController {

    @Autowired
    private AeropuertoService aeropuertoService;

    @PostMapping("/post")
    ResponseEntity<Aeropuerto> agregarAeropuerto(@RequestBody Aeropuerto aeropuerto){
        aeropuertoService.addAeropuerto(aeropuerto);
        return ResponseEntity.ok(aeropuerto);
    }

    @GetMapping("/getByUbicacion")
    ResponseEntity<List<Aeropuerto>> getAeropuertosPorUbicacion(@RequestParam(name = "ubicacion")String ubicacion){
        List<Aeropuerto> matchingAirports = aeropuertoService.getAeropuertosByUbicacion(ubicacion);

        if(matchingAirports.size()>0){
            return ResponseEntity.ok(matchingAirports);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getByNombre")
    ResponseEntity<Aeropuerto> getAeropuertosPorNombre(@RequestParam(name = "nombre")String nombre){
        Aeropuerto a = aeropuertoService.getAeropuertoByNombre(nombre);

        if(a!=null){
            return ResponseEntity.ok(a);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    ResponseEntity<List<Aeropuerto>> getAllAeropuertos(){
        List<Aeropuerto> aeropuertos = aeropuertoService.getAllAeropuertos();

        if(aeropuertos.size()>0){
            return ResponseEntity.ok(aeropuertos);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getById")
    ResponseEntity<Aeropuerto> getById(@RequestParam(name = "id")int idAeropuerto){
        Aeropuerto a = aeropuertoService.getAeropuertoById(idAeropuerto);
        if(a==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(a);
    }
}
