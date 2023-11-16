package proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import proyecto.Clases.Usuario;
import proyecto.Repository.UsuarioRepository;
import proyecto.Services.UsuarioService;

@SpringBootApplication
public class Main {

    @Autowired
    private UsuarioService usuarioService;

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        Main.context = SpringApplication.run(Main.class);

        Main main = new Main();
        main.testForAdmin();;

    }

    public void testForAdmin(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Admin");
        usuario.setEmail("admin");
        usuario.setPassword("admin");
        usuario.setTipoUsuario("Admin");

        if (context != null) {
            context.getBean(Main.class);
            Main mainInstance = context.getBean(Main.class);
            mainInstance.usuarioService.addUser(usuario);
        }
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }

}