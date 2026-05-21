package co.edu.ufps.ingsistemas.analisis_impacto.services;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.ModalidadRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.ModalidadResponse;

import java.util.List;

public interface ModalidadService {

    ModalidadResponse crearModalidad(ModalidadRequest modalidadRequest);
    List<ModalidadResponse> listarModalidades();
    ModalidadResponse obtenerModalidad(Long id);
    ModalidadResponse actualizar(Long id, ModalidadRequest modalidadRequest);
    void eliminarModalidad(Long id);

}
