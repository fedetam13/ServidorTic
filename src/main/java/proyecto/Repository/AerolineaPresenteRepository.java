package proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.Clases.AerolineasPresentes;

@Repository
public interface AerolineaPresenteRepository extends JpaRepository<AerolineasPresentes,Integer> {
}
