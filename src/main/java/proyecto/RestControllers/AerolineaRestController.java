package proyecto.RestControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.Clases.Aerolinea;
import proyecto.Services.AerolineaService;

@RestController
@RequestMapping("/aerolinea")
public class AerolineaRestController {

    @Autowired
    private AerolineaService aerolineaService;

    @PostMapping("/post")
    ResponseEntity<Aerolinea> agregarAerolinea(@RequestBody Aerolinea aerolinea){
        if(aerolineaService.addAerolinea(aerolinea)){
            return ResponseEntity.ok(aerolinea);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getAerolineaById")
    ResponseEntity<Aerolinea> getAerolineaById(@RequestParam(name="idAerolinea")int idAerolinea){
        Aerolinea a = aerolineaService.getAerolineaById(idAerolinea);

        return ResponseEntity.ok(a);

    }

    @GetMapping("/getByNombre")
    ResponseEntity<Aerolinea> getAerolineaByNombre(@RequestParam(name = "nombre")String nombre){
        Aerolinea a = aerolineaService.getAerolineaByNombre(nombre);

        return ResponseEntity.ok(a);
    }
}
