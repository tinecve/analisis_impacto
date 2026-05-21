package co.edu.ufps.ingsistemas.analisis_impacto.controller;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.CohorteRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.ApiResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.CohorteResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.services.CohorteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cohortes")
@RequiredArgsConstructor
public class CohorteController {

    private final CohorteService cohorteService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CohorteResponse>>> listar(){
        return ResponseEntity.ok(ApiResponse.success(this.cohorteService.listarCohortes(), "Lista de cohortes"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CohorteResponse>> obtener(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.success(this.cohorteService.obtenerCohorte(id), "Cohorte encontrado"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CohorteResponse>> crear(@Valid @RequestBody CohorteRequest cohorteRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(this.cohorteService.crearCohorte(cohorteRequest), "Cohorte creado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CohorteResponse>> actualizar(@PathVariable Long id, @Valid @RequestBody CohorteRequest cohorteRequest){
        return ResponseEntity.ok(ApiResponse.success(this.cohorteService.actualizarCohorte(id, cohorteRequest), "Cohorte actualizado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id){
        this.cohorteService.eliminarCohorte(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Cohorte eliminado"));
    }
}
