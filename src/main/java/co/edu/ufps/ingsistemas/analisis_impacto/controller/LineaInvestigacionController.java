package co.edu.ufps.ingsistemas.analisis_impacto.controller;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.LineaInvestigacionRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.ApiResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.LineaInvestigacionResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.services.LineaInvestigacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lineas-investigacion")
@RequiredArgsConstructor
public class LineaInvestigacionController {

    private final LineaInvestigacionService lineaInvestigacionService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<LineaInvestigacionResponse>>> listar(){
        return ResponseEntity.ok(ApiResponse.success(this.lineaInvestigacionService.listarLineas(), "Lista de lineas de investigación"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LineaInvestigacionResponse>> obtener(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.success(this.lineaInvestigacionService.obtenerLinea(id), "Linea de investigación encontrada"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<LineaInvestigacionResponse>> crear(@Valid @RequestBody LineaInvestigacionRequest lineaInvestigacionRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(this.lineaInvestigacionService.crearLineaInvestigacion(lineaInvestigacionRequest), "Linea de investigación creada"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<LineaInvestigacionResponse>> actualizar(@PathVariable Long id, @Valid @RequestBody LineaInvestigacionRequest lineaInvestigacionRequest){
        return ResponseEntity.ok(ApiResponse.success(this.lineaInvestigacionService.actualizar(id, lineaInvestigacionRequest), "Linea de investigación actualizada"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id){
        this.lineaInvestigacionService.eliminarLinea(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Linea de investigación eliminada"));
    }
}