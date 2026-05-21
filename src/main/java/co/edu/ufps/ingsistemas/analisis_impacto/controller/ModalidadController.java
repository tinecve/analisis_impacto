package co.edu.ufps.ingsistemas.analisis_impacto.controller;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.ModalidadRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.ApiResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.ModalidadResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.services.ModalidadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/modalidades")
@RequiredArgsConstructor
public class ModalidadController {

    private final ModalidadService modalidadService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ModalidadResponse>>> listar(){
        return ResponseEntity.ok(ApiResponse.success(this.modalidadService.listarModalidades(), "Lista de modalidades"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ModalidadResponse>> obtener(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.success(this.modalidadService.obtenerModalidad(id), "Modalidad encontrada"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ModalidadResponse>> crear(@Valid @RequestBody ModalidadRequest modalidadRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(this.modalidadService.crearModalidad(modalidadRequest), "Modalidad creada"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ModalidadResponse>> actualizar(@PathVariable Long id, @Valid @RequestBody ModalidadRequest modalidadRequest){
        return ResponseEntity.ok(ApiResponse.success(this.modalidadService.actualizar(id, modalidadRequest),"Modalidad actualizada"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id){
        this.modalidadService.eliminarModalidad(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Modalidad Eliminada"));
    }
}
