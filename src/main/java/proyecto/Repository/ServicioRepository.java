package proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.Clases.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Integer> {
    boolean existsByIdServicio(int idServicio);
}
