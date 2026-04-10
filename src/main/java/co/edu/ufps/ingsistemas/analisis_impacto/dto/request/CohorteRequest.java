package co.edu.ufps.ingsistemas.analisis_impacto.dto.request;

import java.time.LocalDate;

public record CohorteRequest(
        Integer inio,
        String semestre,
        LocalDate fechaInicio,
        LocalDate fechaFin
) {
}
