package co.edu.ufps.ingsistemas.analisis_impacto.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record TrabajoGradoResponse(
        Long id,
        String titulo,
        String resumen,
        CohorteResponse cohorteResponse,
        LineaInvestigacionResponse lineaInvestigacionResponse,
        ModalidadResponse modalidadResponse,
        AreaTematicaResponse areaTematicaResponse,
        TipoProductoResponse tipoProductoResponse,
        SectorResponse sectorResponse,
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
