package proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import proyecto.Clases.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String> {

    boolean existsByEmail(String email);

    Usuario findByEmail(String email);

    List<Usuario> getUsuariosByNombre(String nombre);

    @Query("SELECT MAX(u.idUsuario) FROM Usuario u")
    Integer maxId();

    Usuario findUsuarioByEmail(String email);

    Usuario findUsuarioByIdUsuario(int id);

    Usuario getUsuarioByIdUsuario(int id);

    List<Usuario> existsByTipoUsuario(String tipo);

}
