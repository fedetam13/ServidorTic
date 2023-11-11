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
@Component("Aerolinea")
@Table(name="Aerolinea")
public class Aerolinea {
    @Id
    private String nombre;
    private int idAerolinea;

}
