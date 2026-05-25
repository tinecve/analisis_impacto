package co.edu.ufps.ingsistemas.analisis_impacto.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LineaInvestigacionRequest(
        @NotNull(message = "El nombre no puede ser nulo")
        @NotBlank(message = "El nombre no puede estar vacio")
        String nombre,
        String descripcion,
        Boolean activa
) {
}
