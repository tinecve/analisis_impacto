package co.edu.ufps.ingsistemas.analisis_impacto.services.impl;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.SectorRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.SectorResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.ResourceAlreadyExistsException;
import co.edu.ufps.ingsistemas.analisis_impacto.exception.ResourceNotFoundException;
import co.edu.ufps.ingsistemas.analisis_impacto.mapper.SectorMapper;
import co.edu.ufps.ingsistemas.analisis_impacto.model.Sector;
import co.edu.ufps.ingsistemas.analisis_impacto.repository.SectorRepository;
import co.edu.ufps.ingsistemas.analisis_impacto.services.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SectorServiceImpl implements SectorService {

    private final SectorRepository sectorRepository;
    private final SectorMapper sectorMapper;

    @Override
    public SectorResponse crearSector(SectorRequest sectorRequest) {
        if(this.sectorRepository.existsByNombre(sectorRequest.nombre())){
            throw new ResourceAlreadyExistsException("El sector ya esta registrado");
        }
        Sector sector = this.sectorMapper.toSector(sectorRequest);
        return this.sectorMapper.toSectorResponse(this.sectorRepository.save(sector));
    }

    @Override
    public List<SectorResponse> listarSectores() {
        List<Sector> sectores = this.sectorRepository.findAll();
        List<SectorResponse> sectorResponses = new ArrayList<>();

        if(sectores.isEmpty()){
            return sectorResponses;
        }
        for (Sector sector: sectores){
            sectorResponses.add(this.sectorMapper.toSectorResponse(sector));
        }
        return sectorResponses;
    }

    @Override
    public SectorResponse obtenerSector(Long id) {
        Optional<Sector> sectorOptional = this.sectorRepository.findById(id);
        if(sectorOptional.isEmpty()){
            throw new ResourceNotFoundException("No existe el sector con el id: " + id);
        }
        return this.sectorMapper.toSectorResponse(sectorOptional.get());
    }

    @Override
    public SectorResponse actualizarSector(Long id, SectorRequest sectorRequest) {
        Optional<Sector> sectorOptional = this.sectorRepository.findById(id);
        if(sectorOptional.isEmpty()){
            throw new ResourceNotFoundException("No existe el sector con el id: " + id);
        }
        Sector sector = sectorOptional.get();
        sector.setDescripcion(sectorRequest.descripcion());
        return this.sectorMapper.toSectorResponse(this.sectorRepository.save(sector));
    }

    @Override
    public void eliminarSector(Long id) {
        if(this.sectorRepository.existsById(id)){
            throw new ResourceNotFoundException("No existe el sector con el id: " + id);
        }
        this.sectorRepository.deleteById(id);
    }
}
