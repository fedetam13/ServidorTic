package proyecto.Clases;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Pasaje")
@Component
public class Pasaje {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idPasaje;
    private String asiento;
    private String clase;

    @ManyToOne
    @JoinColumn(name = "id_vuelo")
    private Vuelo vuelo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
