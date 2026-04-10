package co.edu.ufps.ingsistemas.analisis_impacto.dto.response;

import java.time.LocalDate;

public record TrabajoGradoResponse(
        Long id,
        String titulo,
        String resumen,
        CohorteResponse cohorteRequest,
        LineaInvestigacionResponse lineaInvestigacionRequest,
        ModalidadResponse modalidadRequest,
        AreaTematicaResponse areaTematicaRequest,
        TipoProductoResponse tipoProductoRequest,
        SectorResponse sector,
        String estado,
        LocalDate fechaRegistro,
        Boolean implementando,
        Boolean publicado,
        Boolean socializado,
        Boolean transferido,
        String enlaceRepositorio
) {
}
