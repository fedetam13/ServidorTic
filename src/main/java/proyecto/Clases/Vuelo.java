package proyecto.Clases;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Vuelo")
@Component
public class Vuelo {
    @Id
    private int idVuelo;
    private LocalDateTime horaDePartida;
    private LocalDateTime horaDePartidaEstimada;
    private LocalDateTime horaDeArribo;
    private LocalDateTime horaDeArriboEstimada;
    private boolean estaAtrasado;
    private int pueretaDeEmbarque;
    private int puertaDeArribo;
    private String aprovacionDeVuelo; //LA IDEA QUE SEA, Pendiente, Aprovado, Rechazado
    private String aprovacionPartida; // (-,A,R)
    private String aprovacionArribo; // (-,A,R)


    private int idAeropuertoPartida;

    private int idAeropuertoArribo;

    private String nombreAerolinea;

    private String matriculaAvion;

}
