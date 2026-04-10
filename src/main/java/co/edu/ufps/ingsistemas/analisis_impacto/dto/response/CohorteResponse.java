package co.edu.ufps.ingsistemas.analisis_impacto.dto.response;

import java.time.LocalDate;

public record CohorteResponse(
        Long id,
        Integer inio,
        String semestre,
        LocalDate fechaInicio,
        LocalDate fechaFin
) {
}
