package co.edu.ufps.ingsistemas.analisis_impacto.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "trabajos_grado")
public class TrabajoGrado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String resumen;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cohorte cohorte;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "linea_investigacion")
    private LineaInvestigacion linea;

    @ManyToOne(fetch = FetchType.EAGER)
    private Modalidad modalidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_tematica")
    private AreaTematica areaTematica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_producto")
    private TipoProducto tipoProducto;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sector sector;
    private String estado;
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;
    private Boolean implementado;
    private Boolean publicado;
    private Boolean socializado;
    private Boolean transferido;
    @Column(name = "enlace_repositorio")
    private String enlaceRepositorio;
}
