package proyecto.RestControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.Clases.Pasaje;
import proyecto.Services.PasajeService;

import java.util.List;

@RestController
@RequestMapping("/pasaje")
public class PasajeRestController {

    @Autowired
    PasajeService pasajeService;

    @PostMapping("/post")
    ResponseEntity<Pasaje> agregarPasaje(@RequestBody Pasaje pasaje){
        if(pasajeService.agregarPasaje(pasaje)){
            return ResponseEntity.ok(pasaje);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getByUserId")
    ResponseEntity<List<Pasaje>> getPasajesByUserId(@RequestParam(name = "id")int idUsuario){
        List<Pasaje> pasajesUsuario =  pasajeService.getPasajesByUserId(idUsuario);
        return ResponseEntity.ok(pasajesUsuario);
    }

}
