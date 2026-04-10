package co.edu.ufps.ingsistemas.analisis_impacto.mapper;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.LineaInvestigacionRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.LineaInvestigacionResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.model.LineaInvestigacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LineaInvestigacionMapper {

    LineaInvestigacionResponse toLineaInvestigacionResponse(LineaInvestigacion lineaInvestigacion);

    @Mapping(target = "id", ignore = true)
    LineaInvestigacion toEntity(LineaInvestigacionRequest lineaInvestigacionRequest);

}
