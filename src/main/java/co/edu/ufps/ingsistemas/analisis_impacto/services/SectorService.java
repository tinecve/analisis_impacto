package co.edu.ufps.ingsistemas.analisis_impacto.services;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.SectorRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.SectorResponse;

import java.util.List;

public interface SectorService {

    SectorResponse crearSector(SectorRequest sectorRequest);
    List<SectorResponse> listarSectores();
    SectorResponse obtenerSector(Long id);
    SectorResponse actualizarSector(Long id, SectorRequest sectorRequest);
    void eliminarSector(Long id);

}
