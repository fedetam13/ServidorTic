package proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import proyecto.Clases.Aeropuerto;

import java.util.List;

@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto,Integer> {

    boolean existsByIata(String iata);

    List<Aeropuerto> getAeropuertosByUbicacion(String ubicacion);

    @Query("SELECT MAX(a.idAeropuerto) FROM Aeropuerto a")
    Integer maxId();

    Aeropuerto getAeropuertoByNombre(String nombreAeropuerto);

    Aeropuerto getAeropuertoByIdAeropuerto(int id);
}