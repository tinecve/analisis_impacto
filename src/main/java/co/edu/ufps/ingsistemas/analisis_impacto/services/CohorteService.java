package co.edu.ufps.ingsistemas.analisis_impacto.services;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.CohorteRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.CohorteResponse;

import java.util.List;

public interface CohorteService {

    CohorteResponse crearCohorte(CohorteRequest cohorteRequest);
    List<CohorteResponse> listarCohortes();
    CohorteResponse obtenerCohorte(Long id);
    CohorteResponse actualizarCohorte(Long id, CohorteRequest cohorteRequest);
    void eliminarCohorte(Long id);

}
