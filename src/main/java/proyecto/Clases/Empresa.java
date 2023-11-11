package proyecto.Clases;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Empresa")
@Component
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idEmpresa;
    private String nombre;

    @OneToMany
    @JoinColumn(name="id_empresa")
    private List<Sucursal> sucursales = new ArrayList<>();
}
