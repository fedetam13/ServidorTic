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
@Table(name = "Pasajero")
@Component
public class Pasajeros{
    @Id
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
