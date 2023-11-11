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
@Component
@Table(name = "Servicio",uniqueConstraints = @UniqueConstraint(columnNames ={"nombre"}))
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idServicio;
    private String nombre;
    private int costo;
    private int capacidad;


}
