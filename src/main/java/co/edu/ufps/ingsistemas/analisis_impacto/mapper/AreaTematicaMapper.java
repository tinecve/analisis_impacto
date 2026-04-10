package co.edu.ufps.ingsistemas.analisis_impacto.mapper;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.AreaTematicaRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.AreaTematicaResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.model.AreaTematica;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AreaTematicaMapper {

    AreaTematicaResponse toAreaTematicaResponse(AreaTematica areaTematica);

    @Mapping(target = "id", ignore = true)
    AreaTematica toEntity(AreaTematicaRequest areaTematicaRequest);

}
