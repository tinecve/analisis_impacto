package co.edu.ufps.ingsistemas.analisis_impacto.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "areas_tematicas")
@Data
public class AreaTematica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nombre;
    private String descripcion;

}
