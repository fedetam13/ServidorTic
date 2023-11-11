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
@Component("ApAl")
@Table(name = "AerolineasPresentes")
public class AerolineasPresentes {
    @Id
    private int id;
    private String nombreAerolinea;
    private int idAeroopuerto;
}

