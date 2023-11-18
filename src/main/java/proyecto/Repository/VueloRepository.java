package proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.Clases.Vuelo;

import java.util.List;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Integer>{
    boolean existsById(int id);

    @Query("SELECT MAX(v.idVuelo) FROM Vuelo v")
    Integer maxId();

    List<Vuelo> getVuelosByAprovacionArriboAndIdAeropuertoArribo(String ap, int id);
    List<Vuelo> getVuelosByAprovacionPartidaAndIdAeropuertoPartida(String ap, int id);

    Vuelo getVueloByIdVuelo(int id);

    List<Vuelo> getVuelosByIdAeropuertoArribo(int id);

    List<Vuelo> getVuelosByIdAeropuertoPartida(int id);

    List<Vuelo> getVuelosByIdAeropuertoPartidaAndIdAeropuertoArribo(int idAP,int idAA);

}
