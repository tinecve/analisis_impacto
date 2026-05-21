package co.edu.ufps.ingsistemas.analisis_impacto.controller;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.AreaTematicaRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.ApiResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.AreaTematicaResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.services.AreaTematicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tematicas")
@RequiredArgsConstructor
public class AreaTematicaController {

    private final AreaTematicaService areaTematicaService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<AreaTematicaResponse>>> listar(){
        return ResponseEntity.ok(ApiResponse.success(this.areaTematicaService.listarAreasTematicas(), "Lista de areas tematicas"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AreaTematicaResponse>> obtener(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.success(this.areaTematicaService.obtenerAreaTematica(id), "Area Tematica encontrada"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AreaTematicaResponse>> crear(@Valid @RequestBody AreaTematicaRequest areaTematicaRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(this.areaTematicaService.crearAreaTematica(areaTematicaRequest), "Area Tematica creada"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AreaTematicaResponse>> actualizar(@PathVariable Long id, @Valid @RequestBody AreaTematicaRequest areaTematicaRequest){
        return ResponseEntity.ok(ApiResponse.success(this.areaTematicaService.actualizar(id, areaTematicaRequest), "Area tematica actualizada"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id){
        this.areaTematicaService.eliminarAreaTematica(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Area tematica eliminada"));
    }

}