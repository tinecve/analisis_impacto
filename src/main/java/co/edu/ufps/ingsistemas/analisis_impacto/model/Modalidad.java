package co.edu.ufps.ingsistemas.analisis_impacto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "modalidades")
public class Modalidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String modalidad;
    private String descripcion;

}
