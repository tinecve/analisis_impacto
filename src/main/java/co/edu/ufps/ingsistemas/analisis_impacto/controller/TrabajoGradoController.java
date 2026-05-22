package co.edu.ufps.ingsistemas.analisis_impacto.controller;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.TrabajoGradoRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.ApiResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.TrabajoGradoResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.services.TrabajoGradoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trabajos-grado")
@RequiredArgsConstructor
public class TrabajoGradoController {

    private final TrabajoGradoService trabajoGradoService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<TrabajoGradoResponse>>> listar(){
        return ResponseEntity.ok(ApiResponse.success(this.trabajoGradoService.listarTrabajosGrado(), "Lista de trabajos de grado"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TrabajoGradoResponse>> obtener(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.success(this.trabajoGradoService.obtenerTrabajoGrado(id), "Trabajo de grado encontrado"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TrabajoGradoResponse>> crear(@Valid @RequestBody TrabajoGradoRequest trabajoGradoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(this.trabajoGradoService.crearTrabajoGrado(trabajoGradoRequest), "Trabajo de grado registrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TrabajoGradoResponse>> actualizar(@PathVariable Long id, @Valid @RequestBody TrabajoGradoRequest trabajoGradoRequest){
        return ResponseEntity.ok(ApiResponse.success(this.trabajoGradoService.actualizarTrabajoGrado(id, trabajoGradoRequest), "Trabajo de grado actualizado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id){
        this.trabajoGradoService.eliminarTrabajoGrado(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Trabajo de grado eliminado"));
    }

}
