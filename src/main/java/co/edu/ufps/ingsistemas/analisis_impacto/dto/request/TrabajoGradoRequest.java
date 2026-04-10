package co.edu.ufps.ingsistemas.analisis_impacto.dto.request;

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
        LocalDate fechaRegistro,
        Boolean implementando,
        Boolean publicado,
        Boolean socializado,
        Boolean transferido,
        String enlaceRepositorio
) {
}
