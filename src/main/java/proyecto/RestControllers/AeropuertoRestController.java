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

        return ResponseEntity.ok(matchingAirports);

    }

    @GetMapping("/getByNombre")
    ResponseEntity<Aeropuerto> getAeropuertosPorNombre(@RequestParam(name = "nombre")String nombre){
        Aeropuerto a = aeropuertoService.getAeropuertoByNombre(nombre);

        return ResponseEntity.ok(a);
    }

    @GetMapping("/getAll")
    ResponseEntity<List<Aeropuerto>> getAllAeropuertos(){
        List<Aeropuerto> aeropuertos = aeropuertoService.getAllAeropuertos();

        return ResponseEntity.ok(aeropuertos);
    }

    @GetMapping("/getById")
    ResponseEntity<Aeropuerto> getById(@RequestParam(name = "id")int idAeropuerto){
        Aeropuerto a = aeropuertoService.getAeropuertoById(idAeropuerto);

        return ResponseEntity.ok(a);
    }

    @GetMapping("/getByIata")
    ResponseEntity<Aeropuerto> getByIata(@RequestParam(name = "iata")String iata){
        Aeropuerto a = aeropuertoService.getByIata(iata);

        return ResponseEntity.ok(a);
    }
}
