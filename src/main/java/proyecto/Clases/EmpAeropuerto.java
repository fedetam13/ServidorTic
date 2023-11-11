package proyecto.Clases;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import proyecto.Clases.Aeropuerto;
import proyecto.Clases.Usuario;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EmpAeropuerto")
@Component
public class EmpAeropuerto{
    @Id
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_de_trabajo")
    private Aeropuerto aeropuertoDeTrabajo;
}
