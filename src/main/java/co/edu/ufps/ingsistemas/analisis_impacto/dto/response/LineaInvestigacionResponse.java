package co.edu.ufps.ingsistemas.analisis_impacto.dto.response;

public record LineaInvestigacionResponse(
        Long id,
        String nombre,
        String descripcion,
        Boolean activa
) {
}
