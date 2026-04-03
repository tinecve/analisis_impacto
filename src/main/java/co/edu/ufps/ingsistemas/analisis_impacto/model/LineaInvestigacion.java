package co.edu.ufps.ingsistemas.analisis_impacto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lineas_investigacion")
public class LineaInvestigacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nombre;
    private String descripcion;
    private Boolean activa;

}
