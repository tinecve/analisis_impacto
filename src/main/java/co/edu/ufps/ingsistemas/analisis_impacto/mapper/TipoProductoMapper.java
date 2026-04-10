package co.edu.ufps.ingsistemas.analisis_impacto.mapper;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.TipoProductoRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.TipoProductoResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.model.TipoProducto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TipoProductoMapper {

    TipoProductoResponse toTipoProductorResponse(TipoProducto tipoProducto);

    @Mapping(target = "id", ignore = true)
    TipoProducto toEntity(TipoProductoRequest tipoProductoRequest);

}
