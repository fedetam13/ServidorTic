package proyecto.Clases;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Aeropuerto")
@Component("Aeropuerto")
public class Aeropuerto {
    @Id
    private int idAeropuerto;
    private String nombre;
    private String ubicacion;
    private String iata;
    private int cantidadDePuertas;
    private int cantidadDePistas;
    private int cantidadDeCheckin;

}
