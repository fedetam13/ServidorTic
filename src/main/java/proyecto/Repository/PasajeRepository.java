package proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import proyecto.Clases.Pasaje;

import java.util.List;

@Repository
public interface PasajeRepository extends JpaRepository<Pasaje,Integer>{

    boolean existsByIdUsuarioAndIdVuelo(int idU, int idV);

    @Query("SELECT MAX(p.idPasaje) FROM Pasaje p")
    Integer maxId();

    List<Pasaje> getPasajesByIdUsuario(int id);
}
