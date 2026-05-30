package co.edu.ufps.ingsistemas.analisis_impacto.mapper;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.TrabajoGradoRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.TrabajoGradoResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.model.TrabajoGrado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrabajoGradoMapper {

    @Mapping(source = "cohorte", target = "cohorteResponse")
    @Mapping(source = "linea", target = "lineaInvestigacionResponse")
    @Mapping(source = "modalidad", target = "modalidadResponse")
    @Mapping(source = "areaTematica", target = "areaTematicaResponse")
    @Mapping(source = "tipoProducto", target = "tipoProductoResponse")
    @Mapping(source = "sector", target = "sectorResponse")
    TrabajoGradoResponse toTrabajoGradoResponse(TrabajoGrado trabajoGrado);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cohorte", ignore = true)
    @Mapping(target = "linea", ignore = true)
    @Mapping(target = "modalidad", ignore = true)
    @Mapping(target = "areaTematica", ignore = true)
    @Mapping(target = "tipoProducto", ignore = true)
    @Mapping(target = "sector", ignore = true)
    TrabajoGrado toEntity(TrabajoGradoRequest trabajoGradoRequest);

}
