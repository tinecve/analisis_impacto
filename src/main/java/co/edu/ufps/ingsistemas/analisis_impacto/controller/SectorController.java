package co.edu.ufps.ingsistemas.analisis_impacto.controller;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.SectorRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.ApiResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.SectorResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.services.SectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sectores")
@RequiredArgsConstructor
public class SectorController {

    private final SectorService sectorService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SectorResponse>>> listar(){
        return ResponseEntity.ok(ApiResponse.success(this.sectorService.listarSectores(), "Lista de sectores"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SectorResponse>> obtener(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.success(this.sectorService.obtenerSector(id),"Sector encontrado"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SectorResponse>> crear(@Valid @RequestBody SectorRequest sectorRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(this.sectorService.crearSector(sectorRequest), "Sector registrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SectorResponse>> actualizar(@PathVariable Long id, @Valid @RequestBody SectorRequest sectorRequest){
        return ResponseEntity.ok(ApiResponse.success(this.sectorService.actualizarSector(id, sectorRequest), "Sector actualizado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id){
        this.sectorService.eliminarSector(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Sector eliminado"));
    }
}
