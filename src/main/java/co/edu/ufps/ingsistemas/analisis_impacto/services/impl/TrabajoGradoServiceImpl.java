package co.edu.ufps.ingsistemas.analisis_impacto.services.impl;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.TrabajoGradoRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.TrabajoGradoResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.EntityNotFoundException;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.ResourceAlreadyExistsException;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.ResourceNotFoundException;
import co.edu.ufps.ingsistemas.analisis_impacto.mapper.*;
import co.edu.ufps.ingsistemas.analisis_impacto.model.TrabajoGrado;
import co.edu.ufps.ingsistemas.analisis_impacto.repository.*;
import co.edu.ufps.ingsistemas.analisis_impacto.services.TrabajoGradoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    private final CohorteRepository cohorteRepository;
    private final LineaInvestigacionRepository lineaInvestigacionRepository;
    private final ModalidadRepository modalidadRepository;
    private final AreaTematicaRepository areaTematicaRepository;
    private final TipoProductoRepository tipoProductoRepository;
    private final SectorRepository sectorRepository;

    @Override
    public TrabajoGradoResponse crearTrabajoGrado(TrabajoGradoRequest trabajoGradoRequest) {
        if (this.trabajoGradoRepository.existsByTitulo(trabajoGradoRequest.titulo())){
            throw new ResourceAlreadyExistsException("El trabajo de grado ya esta registrado");
        }

        TrabajoGrado trabajoGrado = this.trabajoGradoMapper.toEntity(trabajoGradoRequest);

        if(trabajoGradoRequest.cohorteRequestId() != null){
            trabajoGrado.setCohorte(cohorteRepository.findById(trabajoGradoRequest.cohorteRequestId()).orElseThrow(() -> new EntityNotFoundException("Cohorte no encontrado")));
        }

        if(trabajoGradoRequest.lineaInvestigacionRequestId() != null){
            trabajoGrado.setLinea(lineaInvestigacionRepository.findById(trabajoGradoRequest.lineaInvestigacionRequestId()).orElseThrow(() -> new EntityNotFoundException("Linea de investigacion no encontrada")));
        }

        if(trabajoGradoRequest.modalidadRequestId() != null){
            trabajoGrado.setModalidad(modalidadRepository.findById(trabajoGradoRequest.modalidadRequestId()).orElseThrow(() -> new EntityNotFoundException("Modalidad no encotrada")));
        }

        if(trabajoGradoRequest.areaTematicaRequestId() != null){
            trabajoGrado.setAreaTematica(areaTematicaRepository.findById(trabajoGradoRequest.areaTematicaRequestId()).orElseThrow(() -> new EntityNotFoundException("Area tematica no existe")));
        }

        if(trabajoGradoRequest.tipoProductoRequestId() != null){
            trabajoGrado.setTipoProducto(tipoProductoRepository.findById(trabajoGradoRequest.tipoProductoRequestId()).orElseThrow(() -> new EntityNotFoundException("Tipo de producto no existe")));
        }

        if(trabajoGradoRequest.sectorRequestId() != null){
            trabajoGrado.setSector(sectorRepository.findById(trabajoGradoRequest.sectorRequestId()).orElseThrow(() -> new EntityNotFoundException("Sector no encontrado")));
        }

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
        trabajoGrado.setEstado(trabajoGradoRequest.estado());
        trabajoGrado.setImplementado(trabajoGradoRequest.implementado());
        trabajoGrado.setResumen(trabajoGradoRequest.resumen());
        trabajoGrado.setPublicado(trabajoGradoRequest.publicado());
        trabajoGrado.setEnlaceRepositorio(trabajoGradoRequest.enlaceRepositorio());
        trabajoGrado.setFechaRegistro(trabajoGradoRequest.fechaRegistro());
        trabajoGrado.setSocializado(trabajoGradoRequest.socializado());
        trabajoGrado.setTransferido(trabajoGradoRequest.transferido());

        if(trabajoGradoRequest.cohorteRequestId() != null  && !Objects.equals(trabajoGrado.getCohorte().getId(), trabajoGradoRequest.cohorteRequestId())){
            trabajoGrado.setCohorte(cohorteRepository.findById(trabajoGradoRequest.cohorteRequestId()).orElseThrow(() -> new EntityNotFoundException("Cohorte no encontrado")));
        }

        if(trabajoGradoRequest.lineaInvestigacionRequestId() != null && !Objects.equals(trabajoGrado.getLinea().getId(), trabajoGradoRequest.lineaInvestigacionRequestId())){
            trabajoGrado.setLinea(lineaInvestigacionRepository.findById(trabajoGradoRequest.lineaInvestigacionRequestId()).orElseThrow(() -> new EntityNotFoundException("Linea de investigacion no encontrada")));
        }

        if(trabajoGradoRequest.modalidadRequestId() != null && !Objects.equals(trabajoGrado.getModalidad().getId(), trabajoGradoRequest.modalidadRequestId())){
            trabajoGrado.setModalidad(modalidadRepository.findById(trabajoGradoRequest.modalidadRequestId()).orElseThrow(() -> new EntityNotFoundException("Modalidad no encotrada")));
        }

        if(trabajoGradoRequest.areaTematicaRequestId() != null && !Objects.equals(trabajoGrado.getAreaTematica().getId(), trabajoGradoRequest.areaTematicaRequestId())){
            trabajoGrado.setAreaTematica(areaTematicaRepository.findById(trabajoGradoRequest.areaTematicaRequestId()).orElseThrow(() -> new EntityNotFoundException("Area tematica no existe")));
        }

        if(trabajoGradoRequest.tipoProductoRequestId() != null && !Objects.equals(trabajoGrado.getTipoProducto().getId(), trabajoGradoRequest.tipoProductoRequestId())){
            trabajoGrado.setTipoProducto(tipoProductoRepository.findById(trabajoGradoRequest.tipoProductoRequestId()).orElseThrow(() -> new EntityNotFoundException("Tipo de producto no existe")));
        }

        if(trabajoGradoRequest.sectorRequestId() != null && !Objects.equals(trabajoGrado.getSector().getId(), trabajoGradoRequest.sectorRequestId())) {
            trabajoGrado.setSector(sectorRepository.findById(trabajoGradoRequest.sectorRequestId()).orElseThrow(() -> new EntityNotFoundException("Sector no encontrado")));
        }

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
