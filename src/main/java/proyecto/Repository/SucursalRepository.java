package proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.Clases.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer>{
}
