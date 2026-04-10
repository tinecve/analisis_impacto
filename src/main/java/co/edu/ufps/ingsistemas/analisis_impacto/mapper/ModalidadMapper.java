package co.edu.ufps.ingsistemas.analisis_impacto.mapper;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.ModalidadRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.ModalidadResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.model.Modalidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModalidadMapper {

    ModalidadResponse toModalidadResponse(Modalidad modalidad);

    @Mapping(target = "id", ignore = true)
    Modalidad toEntity(ModalidadRequest modalidadRequest);
}
