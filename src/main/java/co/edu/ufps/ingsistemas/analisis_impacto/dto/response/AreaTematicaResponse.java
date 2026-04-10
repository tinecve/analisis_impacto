package co.edu.ufps.ingsistemas.analisis_impacto.dto.response;

import jakarta.validation.constraints.NotBlank;

public record AreaTematicaResponse(
        Long id,
        @NotBlank String nombre,
        String descripcion
) {
}
