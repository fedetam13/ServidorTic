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
    private int idPasaje;
    private int idVuelo;
    private int idUsuario;
}
