package co.edu.ufps.ingsistemas.analisis_impacto.services.impl;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.TipoProductoRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.TipoProductoResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.ResourceNotFoundException;
import co.edu.ufps.ingsistemas.analisis_impacto.mapper.TipoProductoMapper;
import co.edu.ufps.ingsistemas.analisis_impacto.model.TipoProducto;
import co.edu.ufps.ingsistemas.analisis_impacto.repository.TipoProductoRepository;
import co.edu.ufps.ingsistemas.analisis_impacto.services.TipoProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoProductoServiceImpl implements TipoProductoService {

    private final TipoProductoRepository tipoProductoRepository;
    private final TipoProductoMapper tipoProductoMapper;

    @Override
    public TipoProductoResponse crearTipoProducto(TipoProductoRequest tipoProductoRequest) {
        if(this.tipoProductoRepository.existsByNombre(tipoProductoRequest.nombre())){
            throw new RuntimeException("El tipo de producto ya existe");
        }
        TipoProducto tipoProducto = this.tipoProductoMapper.toEntity(tipoProductoRequest);
        return this.tipoProductoMapper.toTipoProductorResponse(this.tipoProductoRepository.save(tipoProducto));
    }

    @Override
    public List<TipoProductoResponse> listarTiposProductos() {
        List<TipoProducto> tipoProductos = this.tipoProductoRepository.findAll();
        if(tipoProductos.isEmpty()){

        }
        List<TipoProductoResponse> tipoProductoResponses = new ArrayList<>();
        for(TipoProducto tipoProducto: tipoProductos){
            tipoProductoResponses.add(this.tipoProductoMapper.toTipoProductorResponse(tipoProducto));
        }
        return tipoProductoResponses;
    }

    @Override
    public TipoProductoResponse obtenerTipoProducto(Long id) {
        Optional<TipoProducto> tipoProductoOptional = this.tipoProductoRepository.findById(id);
        if(tipoProductoOptional.isEmpty()){
            throw new ResourceNotFoundException("No existe el tipo de producto con el id: " +id);
        }

        return this.tipoProductoMapper.toTipoProductorResponse(tipoProductoOptional.get());
    }

    @Override
    public TipoProductoResponse actualizarTipoProducto(Long id, TipoProductoRequest tipoProductoRequest) {
        Optional<TipoProducto> tipoProductoOptional = this.tipoProductoRepository.findById(id);
        if(tipoProductoOptional.isEmpty()){
            throw new ResourceNotFoundException("No existe el tipo de producto con el id: " + id);
        }
        TipoProducto tipoProducto = tipoProductoOptional.get();
        tipoProducto.setDescripcion(tipoProductoRequest.descripcion());
        return this.tipoProductoMapper.toTipoProductorResponse(this.tipoProductoRepository.save(tipoProducto));
    }

    @Override
    public void eliminarTipoProducto(Long id) {
        if(!this.tipoProductoRepository.existsById(id)){
            throw new ResourceNotFoundException("No existe el tipo de producto con el id: " +id);
        }
        this.tipoProductoRepository.deleteById(id);
    }
}
