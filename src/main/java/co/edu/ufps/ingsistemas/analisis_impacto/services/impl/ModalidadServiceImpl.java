package co.edu.ufps.ingsistemas.analisis_impacto.services.impl;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.ModalidadRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.AreaTematicaResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.ModalidadResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.ResourceAlreadyExistsException;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.ResourceNotFoundException;
import co.edu.ufps.ingsistemas.analisis_impacto.mapper.ModalidadMapper;
import co.edu.ufps.ingsistemas.analisis_impacto.model.Modalidad;
import co.edu.ufps.ingsistemas.analisis_impacto.repository.ModalidadRepository;
import co.edu.ufps.ingsistemas.analisis_impacto.services.ModalidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModalidadServiceImpl implements ModalidadService {

    private final ModalidadRepository modalidadRepository;
    private final ModalidadMapper modalidadMapper;

    @Override
    public ModalidadResponse crearModalidad(ModalidadRequest modalidadRequest) {
        if(this.modalidadRepository.existsByNombre(modalidadRequest.nombre())){
            throw new ResourceAlreadyExistsException("La modalidad ya esta creada");
        }

        Modalidad modalidad = this.modalidadMapper.toEntity(modalidadRequest);
        return this.modalidadMapper.toModalidadResponse(this.modalidadRepository.save(modalidad));
    }

    @Override
    public List<ModalidadResponse> listarModalidades() {
        List<Modalidad> modalidades = this.modalidadRepository.findAll();
        List<ModalidadResponse> modalidads = new ArrayList<>();

        if(modalidades.isEmpty()){
            return modalidads;
        }
        for(Modalidad modalidad: modalidades){
            modalidads.add(this.modalidadMapper.toModalidadResponse(modalidad));
        }
        return modalidads;
    }

    @Override
    public ModalidadResponse obtenerModalidad(Long id) {
        Optional<Modalidad> modalidadOptional = this.modalidadRepository.findById(id);
        if(modalidadOptional.isEmpty()){
            throw new ResourceNotFoundException("No existe la modalidad con el id: " + id);
        }
        return this.modalidadMapper.toModalidadResponse(modalidadOptional.get());
    }

    @Override
    public ModalidadResponse actualizar(Long id, ModalidadRequest modalidadRequest) {
        Optional<Modalidad> modalidadOptional = this.modalidadRepository.findById(id);
        if(modalidadOptional.isEmpty()){
            throw new ResourceNotFoundException("No existe la modalidad con el id: " + id);
        }
        Modalidad modalidad = modalidadOptional.get();
        modalidad.setModalidad(modalidadRequest.nombre());
        modalidad.setDescripcion(modalidadRequest.descripcion());
        return this.modalidadMapper.toModalidadResponse(this.modalidadRepository.save(modalidad));
    }

    @Override
    public void eliminarModalidad(Long id) {
        if(!this.modalidadRepository.existsById(id)){
            throw new ResourceNotFoundException("No existe la modalidad con el id: " + id);
        }
        this.modalidadRepository.deleteById(id);
    }
}
