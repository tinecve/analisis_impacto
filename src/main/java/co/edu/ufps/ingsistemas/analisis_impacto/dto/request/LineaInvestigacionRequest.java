package co.edu.ufps.ingsistemas.analisis_impacto.dto.request;

public record LineaInvestigacionRequest(
        String nombre,
        String descripcion,
        Boolean activa
) {
}
