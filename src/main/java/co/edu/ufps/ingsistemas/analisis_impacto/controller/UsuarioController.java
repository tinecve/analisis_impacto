package co.edu.ufps.ingsistemas.analisis_impacto.controller;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.UsuarioRequestDTO;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.ApiResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.UsuarioResponseDTO;
import co.edu.ufps.ingsistemas.analisis_impacto.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<UsuarioResponseDTO>>> listar(){
        return ResponseEntity.ok(
                ApiResponse.success(usuarioService.listarUsuarios(), "Lista de usuarios")
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> obtener(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.success(usuarioService.obtenerUsuario(id), "Usuario encontrado"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> crear(@Valid @RequestBody UsuarioRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(usuarioService.crearUsuario(dto), "Usuario Creado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponseDTO>> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequestDTO dto){
        return ResponseEntity.ok(ApiResponse.success(usuarioService.actualizarUsuario(id, dto), "Usuario actualizado"));
    }

    public ResponseEntity<ApiResponse<Void>> eliminar(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Usuario eliminado"));
    }

}
