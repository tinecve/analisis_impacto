package co.edu.ufps.ingsistemas.analisis_impacto.mapper;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.SectorRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.SectorResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.model.Sector;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SectorMapper {

    SectorResponse toSectorResponse(Sector sector);

    @Mapping(target = "id", ignore = true)
    Sector toSector(SectorRequest sectorRequest);

}
