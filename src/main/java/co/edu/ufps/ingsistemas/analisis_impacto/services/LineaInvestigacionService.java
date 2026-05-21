package co.edu.ufps.ingsistemas.analisis_impacto.services;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.LineaInvestigacionRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.LineaInvestigacionResponse;

import java.util.List;

public interface LineaInvestigacionService {

    LineaInvestigacionResponse crearLineaInvestigacion(LineaInvestigacionRequest lineaInvestigacionRequest);
    List<LineaInvestigacionResponse> listarLineas();
    LineaInvestigacionResponse obtenerLinea(Long id);
    LineaInvestigacionResponse actualizar(Long id, LineaInvestigacionRequest lineaInvestigacionRequest);
    void eliminarLinea(Long id);

}
