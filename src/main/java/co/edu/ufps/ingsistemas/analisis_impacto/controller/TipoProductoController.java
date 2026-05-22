package co.edu.ufps.ingsistemas.analisis_impacto.controller;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.TipoProductoRequest;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.ApiResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.TipoProductoResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.services.TipoProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-productos")
@RequiredArgsConstructor
public class TipoProductoController {

    private final TipoProductoService tipoProductoService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<TipoProductoResponse>>> listar(){
        return ResponseEntity.ok(ApiResponse.success(this.tipoProductoService.listarTiposProductos(), "Lista de tipos de producto"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TipoProductoResponse>> obtener(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.success(this.tipoProductoService.obtenerTipoProducto(id), "Tipo de producto encontrado"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TipoProductoResponse>> crear(@Valid @RequestBody TipoProductoRequest tipoProductoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(this.tipoProductoService.crearTipoProducto(tipoProductoRequest), "Tipo de producto registrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TipoProductoResponse>> actualizar(@PathVariable Long id, @Valid @RequestBody TipoProductoRequest tipoProductoRequest){
        return ResponseEntity.ok(ApiResponse.success(this.tipoProductoService.actualizarTipoProducto(id, tipoProductoRequest), "Tipo de producto actualizado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id){
        this.tipoProductoService.eliminarTipoProducto(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Tipo de producto eliminado"));
    }
}
