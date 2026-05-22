package co.edu.ufps.ingsistemas.analisis_impacto.services;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.TipoProductoRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.TipoProductoResponse;

import java.util.List;

public interface TipoProductoService {

    TipoProductoResponse crearTipoProducto(TipoProductoRequest tipoProductoRequest);
    List<TipoProductoResponse> listarTiposProductos();
    TipoProductoResponse obtenerTipoProducto(Long id);
    TipoProductoResponse actualizarTipoProducto(Long id, TipoProductoRequest tipoProductoRequest);
    void eliminarTipoProducto(Long id);

}
