package co.edu.ufps.ingsistemas.analisis_impacto.services;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.AreaTematicaRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.AreaTematicaResponse;

import java.util.List;

public interface AreaTematicaService {

    AreaTematicaResponse crearAreaTematica(AreaTematicaRequest areaTematicaRequest);
    List<AreaTematicaResponse> listarAreasTematicas();
    AreaTematicaResponse obtenerAreaTematica(Long id);
    AreaTematicaResponse actualizar(Long id, AreaTematicaRequest areaTematicaRequest);
    void eliminarAreaTematica(Long id);

}
