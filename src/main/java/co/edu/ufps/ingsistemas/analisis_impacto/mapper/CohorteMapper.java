package co.edu.ufps.ingsistemas.analisis_impacto.mapper;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.CohorteRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.CohorteResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.model.Cohorte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CohorteMapper {

    CohorteResponse toCohorteResponse(Cohorte cohorte);

    @Mapping(target = "id", ignore = true)
    Cohorte toEntity(CohorteRequest cohorteRequest);

}
