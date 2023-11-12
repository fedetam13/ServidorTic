package proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.Clases.Usuario;
import proyecto.Repository.UsuarioRepository;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean addUser(Usuario u){
        if(checkValid(u)){
            if(usuarioRepository.count()!=0){
                u.setIdUsuario(usuarioRepository.maxId()+1);}
            else{u.setIdUsuario(1);}
            usuarioRepository.save(u);
            return true;
        }
        return false;
    }

    public boolean hayAdmin() {
        List<Usuario> adminExists = usuarioRepository.existsByTipoUsuario("Admin");

        if (adminExists.size()>0) {
            return true;
        }
        return false;
    }

    private boolean checkValid(Usuario u) {
        if(usuarioRepository.existsByEmail(u.getEmail())){
            return false;
        }
        if(u.getEmail()==null||u.getNombre()==null||u.getPassword()==null){
            return false;
        }
        return true;
    }

    public boolean attemptLogin(Usuario u) {
        if(usuarioRepository.existsByEmail(u.getEmail())){
            System.out.println("Existe");
            if(Objects.equals(usuarioRepository.findByEmail(u.getEmail()).getPassword(), u.getPassword())){
                System.out.println("Password match");
                return true;
            }
        }
        return false;
    }

    public List<Usuario> getUsersByName(String nombre) {
        return usuarioRepository.getUsuariosByNombre(nombre);
    }

    public Usuario getUserById(int id){
        return usuarioRepository.getUsuarioByIdUsuario(id);
    }

    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

    public Usuario getUserByEmail(String email) {
        return usuarioRepository.findUsuarioByEmail(email);

    }

    public boolean changePassword(Usuario usuario) {
        usuarioRepository.save(usuario);
        return true;
    }
}
