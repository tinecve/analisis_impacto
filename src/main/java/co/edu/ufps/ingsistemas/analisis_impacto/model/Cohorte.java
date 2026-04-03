package co.edu.ufps.ingsistemas.analisis_impacto.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "cohortes",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_anio_semestre", columnNames = {"anio", "semestre"})
        })
public class Cohorte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer anio;
    private String semestre;
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

}
