package co.edu.ufps.ingsistemas.analisis_impacto.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AreaTematicaRequest(
        @NotBlank String nombre,
        String descripcion
) {
}
