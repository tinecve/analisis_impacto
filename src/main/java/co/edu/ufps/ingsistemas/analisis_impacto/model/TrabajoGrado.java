package co.edu.ufps.ingsistemas.analisis_impacto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "trabajos_grado")
public class TrabajoGrado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "El titulo no puede ser nulo")
    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;
    private String resumen;

    @JoinColumn(name = "cohorte")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cohorte cohorte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "linea_investigacion")
    private LineaInvestigacion linea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modalidad")
    private Modalidad modalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_tematica")
    private AreaTematica areaTematica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_producto")
    private TipoProducto tipoProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector")
    private Sector sector;
    private String estado;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;
    private Boolean implementado;
    private Boolean publicado;
    private Boolean socializado;
    private Boolean transferido;
    @Column(name = "enlace_repositorio")
    private String enlaceRepositorio;
}
