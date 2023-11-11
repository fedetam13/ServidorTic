package proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.Clases.Avion;

import java.util.List;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Integer>{
    boolean existsByMatricula(String matricula);

    List<Avion> getAvionsByNombreAerolinea(String nombreAerolinea);
}
