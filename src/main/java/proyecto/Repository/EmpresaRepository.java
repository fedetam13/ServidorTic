package proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.Clases.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
}
