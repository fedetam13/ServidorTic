package proyecto.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.Clases.Avion;
import proyecto.Clases.Usuario;
import proyecto.Services.AvionService;

import java.util.List;

@RestController
@RequestMapping("/avion")
public class AvionRestController {

    @Autowired
    private AvionService avionService;

    @PostMapping("/post")
    ResponseEntity<Avion> agregarAvion(@RequestBody Avion avion){
        avionService.agregarAvion(avion);
        return ResponseEntity.ok(avion);
    }

    @GetMapping("/getByAirlineName")
    ResponseEntity<List<Avion>> getAvionesByNombreAerolinea(@RequestParam(name = "nombreAerolinea")String nombreAerolinea){
        List<Avion> matchingAviones = avionService.getAvionesByNombreAerolinea(nombreAerolinea);

        return ResponseEntity.ok(matchingAviones);
    }

    @GetMapping("/getByMatricula")
    ResponseEntity<Avion> getAvionByMatricula(@RequestParam(name = "matricula")String matricula){
        Avion a = avionService.getAvionByMatricula(matricula);

        return ResponseEntity.ok(a);
    }
}
