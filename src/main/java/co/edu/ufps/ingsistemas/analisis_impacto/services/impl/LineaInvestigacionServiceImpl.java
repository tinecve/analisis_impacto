package co.edu.ufps.ingsistemas.analisis_impacto.services.impl;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.LineaInvestigacionRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.LineaInvestigacionResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.ResourceNotFoundException;
import co.edu.ufps.ingsistemas.analisis_impacto.mapper.LineaInvestigacionMapper;
import co.edu.ufps.ingsistemas.analisis_impacto.model.LineaInvestigacion;
import co.edu.ufps.ingsistemas.analisis_impacto.repository.LineaInvestigacionRepository;
import co.edu.ufps.ingsistemas.analisis_impacto.services.LineaInvestigacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LineaInvestigacionServiceImpl implements LineaInvestigacionService {

    private final LineaInvestigacionRepository lineaInvestigacionRepository;
    private final LineaInvestigacionMapper lineaInvestigacionMapper;

    @Override
    public LineaInvestigacionResponse crearLineaInvestigacion(LineaInvestigacionRequest lineaInvestigacionRequest) {
        if(this.lineaInvestigacionRepository.existsByNombre(lineaInvestigacionRequest.nombre())){
            throw new RuntimeException("La linea de investigación ya esta registrada");
        }
        LineaInvestigacion lineaInvestigacion = this.lineaInvestigacionMapper.toEntity(lineaInvestigacionRequest);
        return this.lineaInvestigacionMapper.toLineaInvestigacionResponse(this.lineaInvestigacionRepository.save(lineaInvestigacion));
    }

    @Override
    public List<LineaInvestigacionResponse> listarLineas() {
        List<LineaInvestigacion> lineaInvestigacions = this.lineaInvestigacionRepository.findAll();
        if(lineaInvestigacions.isEmpty()){
            return null;
        }
        List<LineaInvestigacionResponse> lineaInvestigacionResponses = new ArrayList<>();
        for(LineaInvestigacion lineaInvestigacion: lineaInvestigacions){
            lineaInvestigacionResponses.add(this.lineaInvestigacionMapper.toLineaInvestigacionResponse(lineaInvestigacion));
        }
        return lineaInvestigacionResponses;
    }

    @Override
    public LineaInvestigacionResponse obtenerLinea(Long id) {
        Optional<LineaInvestigacion> lineaInvestigacionOptional = this.lineaInvestigacionRepository.findById(id);
        if(lineaInvestigacionOptional.isEmpty()){
            throw new ResourceNotFoundException("No existe la linea de investigación con el id: " + id);
        }
        return this.lineaInvestigacionMapper.toLineaInvestigacionResponse(lineaInvestigacionOptional.get());
    }

    @Override
    public LineaInvestigacionResponse actualizar(Long id, LineaInvestigacionRequest lineaInvestigacionRequest) {
        Optional<LineaInvestigacion> lineaInvestigacionOptional = this.lineaInvestigacionRepository.findById(id);
        if(lineaInvestigacionOptional.isEmpty()){
            throw new ResourceNotFoundException("No existe la linea de investigación con el id: " + id);
        }
        LineaInvestigacion lineaInvestigacion = lineaInvestigacionOptional.get();
        lineaInvestigacion.setDescripcion(lineaInvestigacionRequest.descripcion());
        lineaInvestigacion.setActiva(lineaInvestigacionRequest.activa());
        return this.lineaInvestigacionMapper.toLineaInvestigacionResponse(this.lineaInvestigacionRepository.save(lineaInvestigacion));
    }

    @Override
    public void eliminarLinea(Long id) {
        if(!this.lineaInvestigacionRepository.existsById(id)){
            throw new ResourceNotFoundException("No existe la linea de investigación con el id: " + id);
        }
        this.lineaInvestigacionRepository.deleteById(id);
    }
}
