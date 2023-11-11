package proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import proyecto.Clases.Vuelo;

import java.util.List;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Integer>{
    boolean existsById(int id);

    @Query("SELECT MAX(v.idVuelo) FROM Vuelo v")
    Integer maxId();

    List<Vuelo> getVuelosByIdAeropuertoArriboOrIdAeropuertoPartida(int a,int p);
}
