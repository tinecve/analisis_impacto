package co.edu.ufps.ingsistemas.analisis_impacto.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record TrabajoGradoRequest(
        String titulo,
        String resumen,
        CohorteRequest cohorteRequest,
        LineaInvestigacionRequest lineaInvestigacionRequest,
        ModalidadRequest modalidadRequest,
        AreaTematicaRequest areaTematicaRequest,
        TipoProductoRequest tipoProductoRequest,
        SectorRequest sector,
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
