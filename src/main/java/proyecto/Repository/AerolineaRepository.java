package proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import proyecto.Clases.Aerolinea;
import proyecto.Services.AerolineaService;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Integer> {
    boolean existsByNombre(String nombre);

    void deleteByNombre(String nombre);

    @Query("SELECT MAX(a.idAerolinea) FROM Aerolinea a")
    Integer maxId();

    Aerolinea getAerolineaByIdAerolinea(int idAerolinea);

    Aerolinea getAerolineaByNombre(String nombre);
}
