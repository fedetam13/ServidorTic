package proyecto.RestControllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.Clases.Usuario;
import proyecto.Services.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/post")
    ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario){
        if(usuarioService.addUser(usuario)) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/changePassword")
    ResponseEntity<Usuario> changePassword(@RequestBody Usuario usuario){
        if(usuarioService.changePassword(usuario)){
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/getByNombre")
    ResponseEntity<List<Usuario>> getUsuariosPorNombre(@RequestParam(name = "nombre")String nombre){
        List<Usuario> matchingUsers = usuarioService.getUsersByName(nombre);

        return ResponseEntity.ok(matchingUsers);
    }

    @GetMapping("/getByEmail")
    ResponseEntity<Usuario> getUsuarioPorEmail(@RequestParam(name = "email") String email){
        Usuario u = usuarioService.getUserByEmail(email);

        return ResponseEntity.ok(u);
    }

    @GetMapping("/getById")
    ResponseEntity<Usuario> getUsuarioPorId(@RequestParam(name = "idUsuario") int idUsuario){
        Usuario u = usuarioService.getUserById(idUsuario);

        return ResponseEntity.ok(u);
    }


    @GetMapping("/getAll")
    ResponseEntity<List<Usuario>> getAllUsuarios(){
        return ResponseEntity.ok(usuarioService.getAllUsers());
    }

}
