package co.edu.ufps.ingsistemas.analisis_impacto.services;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.TrabajoGradoRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.TrabajoGradoResponse;

import java.util.List;

public interface TrabajoGradoService {

    TrabajoGradoResponse crearTrabajoGrado(TrabajoGradoRequest trabajoGradoRequest);
    List<TrabajoGradoResponse> listarTrabajosGrado();
    TrabajoGradoResponse obtenerTrabajoGrado(Long id);
    TrabajoGradoResponse actualizarTrabajoGrado(Long id, TrabajoGradoRequest trabajoGradoRequest);
    void eliminarTrabajoGrado(Long id);

}
