package co.edu.ufps.ingsistemas.analisis_impacto.services.impl;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.CohorteRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.CohorteResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.ResourceNotFoundException;
import co.edu.ufps.ingsistemas.analisis_impacto.mapper.CohorteMapper;
import co.edu.ufps.ingsistemas.analisis_impacto.model.Cohorte;
import co.edu.ufps.ingsistemas.analisis_impacto.repository.CohorteRepository;
import co.edu.ufps.ingsistemas.analisis_impacto.services.CohorteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CohorteServiceImpl implements CohorteService {

    private final CohorteRepository cohorteRepository;
    private final CohorteMapper cohorteMapper;

    @Override
    public CohorteResponse crearCohorte(CohorteRequest cohorteRequest) {
        if (this.cohorteRepository.existsByAnioAndSemestre(cohorteRequest.inio(), cohorteRequest.semestre())){
            throw new RuntimeException("El cohorte ya esta registrado");
        }
        Cohorte cohorte = this.cohorteMapper.toEntity(cohorteRequest);
        return this.cohorteMapper.toCohorteResponse(this.cohorteRepository.save(cohorte));
    }

    @Override
    public List<CohorteResponse> listarCohortes() {
        List<Cohorte> cohortes = this.cohorteRepository.findAll();
        if(cohortes.isEmpty()){
            return null;
        }
        List<CohorteResponse> cohorteResponses = new ArrayList<>();
        for(Cohorte cohorte: cohortes){
            cohorteResponses.add(this.cohorteMapper.toCohorteResponse(cohorte));
        }
        return cohorteResponses;
    }

    @Override
    public CohorteResponse obtenerCohorte(Long id) {
        Optional<Cohorte> cohorteOptional = this.cohorteRepository.findById(id);
        if(cohorteOptional.isEmpty()){
            throw new ResourceNotFoundException("No existe el cohorte con el id: " + id);
        }

        return this.cohorteMapper.toCohorteResponse(cohorteOptional.get());
    }

    @Override
    public CohorteResponse actualizarCohorte(Long id, CohorteRequest cohorteRequest) {
        Optional<Cohorte> cohorteOptional = this.cohorteRepository.findById(id);
        if(cohorteOptional.isEmpty()){
            throw new ResourceNotFoundException("No existe el cohorte con el id: "+ id);
        }
        Cohorte cohorte = cohorteOptional.get();
        cohorte.setFechaFin(cohorteRequest.fechaFin());
        cohorte.setFechaInicio(cohorteRequest.fechaInicio());
        return this.cohorteMapper.toCohorteResponse(this.cohorteRepository.save(cohorte));
    }

    @Override
    public void eliminarCohorte(Long id) {
        if(!this.cohorteRepository.existsById(id)){
            throw new ResourceNotFoundException("No existe el cohorte con el id: " + id);
        }
        this.cohorteRepository.deleteById(id);
    }
}
