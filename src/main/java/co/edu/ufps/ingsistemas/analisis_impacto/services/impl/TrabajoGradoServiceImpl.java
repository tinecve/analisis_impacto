package co.edu.ufps.ingsistemas.analisis_impacto.services.impl;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.TrabajoGradoRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.TrabajoGradoResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.ResourceAlreadyExistsException;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.ResourceNotFoundException;
import co.edu.ufps.ingsistemas.analisis_impacto.mapper.*;
import co.edu.ufps.ingsistemas.analisis_impacto.model.TrabajoGrado;
import co.edu.ufps.ingsistemas.analisis_impacto.repository.TrabajoGradoRepository;
import co.edu.ufps.ingsistemas.analisis_impacto.services.TrabajoGradoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrabajoGradoServiceImpl implements TrabajoGradoService {

    private final TrabajoGradoRepository trabajoGradoRepository;
    private final TrabajoGradoMapper trabajoGradoMapper;
    private final CohorteMapper cohorteMapper;
    private final LineaInvestigacionMapper lineaInvestigacionMapper;
    private final AreaTematicaMapper areaTematicaMapper;
    private final ModalidadMapper modalidadMapper;
    private final SectorMapper sectorMapper;
    private final TipoProductoMapper tipoProductoMapper;

    @Override
    public TrabajoGradoResponse crearTrabajoGrado(TrabajoGradoRequest trabajoGradoRequest) {
        if (this.trabajoGradoRepository.existsByTitulo(trabajoGradoRequest.titulo())){
            throw new ResourceAlreadyExistsException("El trabajo de grado ya esta registrado");
        }
        TrabajoGrado trabajoGrado = this.trabajoGradoMapper.toEntity(trabajoGradoRequest);
        return this.trabajoGradoMapper.toTrabajoGradoResponse(this.trabajoGradoRepository.save(trabajoGrado));
    }

    @Override
    public List<TrabajoGradoResponse> listarTrabajosGrado() {
        List<TrabajoGrado> trabajosGrado = this.trabajoGradoRepository.findAll();
        List<TrabajoGradoResponse> trabajoGradoResponses = new ArrayList<>();

        if(trabajosGrado.isEmpty()){
            return trabajoGradoResponses;
        }
        for(TrabajoGrado trabajoGrado: trabajosGrado){
            trabajoGradoResponses.add(this.trabajoGradoMapper.toTrabajoGradoResponse(trabajoGrado));
        }
        return trabajoGradoResponses;
    }

    @Override
    public TrabajoGradoResponse obtenerTrabajoGrado(Long id) {
        Optional<TrabajoGrado> trabajoGradoOptional = this.trabajoGradoRepository.findById(id);
        if(trabajoGradoOptional.isEmpty()){
            throw new ResourceNotFoundException("No existe el trabajo de grado con el id: " + id);
        }
        return this.trabajoGradoMapper.toTrabajoGradoResponse(trabajoGradoOptional.get());
    }

    @Override
    public TrabajoGradoResponse actualizarTrabajoGrado(Long id, TrabajoGradoRequest trabajoGradoRequest) {
        Optional<TrabajoGrado> trabajoGradoOptional = this.trabajoGradoRepository.findById(id);
        if(trabajoGradoOptional.isEmpty()){
            throw new ResourceNotFoundException("No existe el trabajo de grado con el id: " + id);
        }
        TrabajoGrado trabajoGrado = trabajoGradoOptional.get();
        trabajoGrado.setCohorte(this.cohorteMapper.toEntity(trabajoGradoRequest.cohorteRequest()));
        trabajoGrado.setEstado(trabajoGradoRequest.estado());
        trabajoGrado.setLinea(lineaInvestigacionMapper.toEntity(trabajoGradoRequest.lineaInvestigacionRequest()));
        trabajoGrado.setImplementado(trabajoGradoRequest.implementando());
        trabajoGrado.setResumen(trabajoGradoRequest.resumen());
        trabajoGrado.setAreaTematica(this.areaTematicaMapper.toEntity(trabajoGradoRequest.areaTematicaRequest()));
        trabajoGrado.setModalidad(this.modalidadMapper.toEntity(trabajoGradoRequest.modalidadRequest()));
        trabajoGrado.setSector(sectorMapper.toSector(trabajoGradoRequest.sector()));
        trabajoGrado.setPublicado(trabajoGradoRequest.publicado());
        trabajoGrado.setEnlaceRepositorio(trabajoGradoRequest.enlaceRepositorio());
        trabajoGrado.setFechaRegistro(trabajoGradoRequest.fechaRegistro());
        trabajoGrado.setSocializado(trabajoGradoRequest.socializado());
        trabajoGrado.setTipoProducto(this.tipoProductoMapper.toEntity(trabajoGradoRequest.tipoProductoRequest()));
        trabajoGrado.setTransferido(trabajoGradoRequest.transferido());
        return this.trabajoGradoMapper.toTrabajoGradoResponse(this.trabajoGradoRepository.save(trabajoGrado));
    }

    @Override
    public void eliminarTrabajoGrado(Long id) {
        if(!this.trabajoGradoRepository.existsById(id)){
            throw new ResourceNotFoundException("No existe el trabajo de grado con el id: " + id);
        }
        this.trabajoGradoRepository.deleteById(id);
    }
}
