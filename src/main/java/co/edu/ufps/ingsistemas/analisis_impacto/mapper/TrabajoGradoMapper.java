package co.edu.ufps.ingsistemas.analisis_impacto.mapper;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.TrabajoGradoRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.TrabajoGradoResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.model.TrabajoGrado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrabajoGradoMapper {

    TrabajoGradoResponse toTrabajoGradoResponse(TrabajoGrado trabajoGrado);

    @Mapping(target = "id", ignore = true)
    TrabajoGrado toEntity(TrabajoGradoRequest trabajoGradoRequest);

}
