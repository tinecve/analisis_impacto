package co.edu.ufps.ingsistemas.analisis_impacto.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record TrabajoGradoRequest(
        String titulo,
        String resumen,
        Long cohorteRequestId,
        Long lineaInvestigacionRequestId,
        Long modalidadRequestId,
        Long areaTematicaRequestId,
        Long tipoProductoRequestId,
        Long sectorRequestId,
        String estado,
        @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
        LocalDate fechaRegistro,
        Boolean implementado,
        Boolean publicado,
        Boolean socializado,
        Boolean transferido,
        String enlaceRepositorio
) {
}
