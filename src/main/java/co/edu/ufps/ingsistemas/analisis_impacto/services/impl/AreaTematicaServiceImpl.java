package co.edu.ufps.ingsistemas.analisis_impacto.services.impl;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.AreaTematicaRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.AreaTematicaResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.ResourceAlreadyExistsException;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.ResourceNotFoundException;
import co.edu.ufps.ingsistemas.analisis_impacto.mapper.AreaTematicaMapper;
import co.edu.ufps.ingsistemas.analisis_impacto.model.AreaTematica;
import co.edu.ufps.ingsistemas.analisis_impacto.repository.AreaTematicaRepository;
import co.edu.ufps.ingsistemas.analisis_impacto.services.AreaTematicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AreaTematicaServiceImpl implements AreaTematicaService {

    private final AreaTematicaRepository areaTematicaRepository;
    private final AreaTematicaMapper areaTematicaMapper;

    @Override
    public AreaTematicaResponse crearAreaTematica(AreaTematicaRequest areaTematicaRequest) {
        if(this.areaTematicaRepository.existsByNombre(areaTematicaRequest.nombre())){
            throw new ResourceAlreadyExistsException("La tematica ya esta registrado");
        }

        AreaTematica areaTematica = this.areaTematicaMapper.toEntity(areaTematicaRequest);

        return this.areaTematicaMapper.toAreaTematicaResponse(this.areaTematicaRepository.save(areaTematica));
    }

    @Override
    public List<AreaTematicaResponse> listarAreasTematicas() {
        List<AreaTematica> areaTematicas = this.areaTematicaRepository.findAll();

        List<AreaTematicaResponse> areaTematicaResponses = new ArrayList<>();
        if(areaTematicas.isEmpty()){
            return areaTematicaResponses;
        }
        for(AreaTematica areaTematica: areaTematicas){
            areaTematicaResponses.add(this.areaTematicaMapper.toAreaTematicaResponse(areaTematica));
        }
        return areaTematicaResponses;
    }

    @Override
    public AreaTematicaResponse obtenerAreaTematica(Long id) {
        Optional<AreaTematica> areaTematicaOptional = this.areaTematicaRepository.findById(id);
        if(areaTematicaOptional.isEmpty()){
            throw new ResourceNotFoundException("No existe el area Tematica con el id: " + id);
        }

        return this.areaTematicaMapper.toAreaTematicaResponse(areaTematicaOptional.get());
    }

    @Override
    public AreaTematicaResponse actualizar(Long id, AreaTematicaRequest areaTematicaRequest) {
        Optional<AreaTematica> areaTematicaOptional = this.areaTematicaRepository.findById(id);
        if (areaTematicaOptional.isEmpty()) {
            throw new ResourceNotFoundException("No existe el area Tematica con el id: " + id);
        }
        AreaTematica areaTematica = areaTematicaOptional.get();
        areaTematica.setNombre(areaTematicaRequest.nombre());
        areaTematica.setDescripcion(areaTematicaRequest.descripcion());

        return this.areaTematicaMapper.toAreaTematicaResponse(this.areaTematicaRepository.save(areaTematica));
    }

    @Override
    public void eliminarAreaTematica(Long id) {
        if(!this.areaTematicaRepository.existsById(id)){
            throw new ResourceNotFoundException("No existe el area Tematica con el id: " + id);
        }
        this.areaTematicaRepository.deleteById(id);
    }
}
