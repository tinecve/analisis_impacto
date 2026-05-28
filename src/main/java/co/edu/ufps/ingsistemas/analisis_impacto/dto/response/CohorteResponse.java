package co.edu.ufps.ingsistemas.analisis_impacto.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record CohorteResponse(
        Long id,
        Integer anio,
        String semestre,
        @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
        LocalDate fechaInicio,
        @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
        LocalDate fechaFin
) {
}
