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
@Table(
        name = "cohortes",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_anio_semestre", columnNames = {"anio", "semestre"})
        })
public class Cohorte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "El año no puede ser nulo")
    private Integer anio;
    @NotNull(message = "El semestre no puede ser nulo")
    @NotBlank(message = "El semestre no puede estar vacio")
    private String semestre;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

}
