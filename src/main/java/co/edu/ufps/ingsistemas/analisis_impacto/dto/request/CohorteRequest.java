package co.edu.ufps.ingsistemas.analisis_impacto.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CohorteRequest(
        @NotNull(message = "El año no puede ser nulo")
        Integer anio,
        @NotNull(message = "El semestre no puede ser nulo")
        @NotBlank(message = "El semestre no puede estar vacio")
        String semestre,
        @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
        LocalDate fechaInicio,
        @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
        LocalDate fechaFin
) {
}
