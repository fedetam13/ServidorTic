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
@Table(name = "Usuario")
@Component

public class Usuario {
    @Id
    private int idUsuario;
    @Column(unique = true)
    private String email;
    private String password;
    private String nombre;
    private String tipoUsuario;


}
