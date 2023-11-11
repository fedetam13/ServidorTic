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
@Table(name = "Sucursal")
@Component
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idSucursal;
    private int cantidadDeEmpleados;
}
