package co.edu.ufps.ingsistemas.analisis_impacto.controller;

import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.LoginRequestDTO;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.request.UsuarioRequestDTO;
import co.edu.ufps.ingsistemas.analisis_impacto.dto.response.ApiResponse;
import co.edu.ufps.ingsistemas.analisis_impacto.model.Usuario;
import co.edu.ufps.ingsistemas.analisis_impacto.repository.UsuarioRepository;
import co.edu.ufps.ingsistemas.analisis_impacto.security.JwtUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody LoginRequestDTO request){
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtUtil.generarToken(usuario.getEmail(), usuario.getRol().name());

        AuthResponse response = new AuthResponse(token, usuario.getEmail(), usuario.getRol().name());
        return ResponseEntity.ok(ApiResponse.success(response, "Login exitoso"));
    }

    public ResponseEntity<ApiResponse<String>> register(
            @Valid @RequestBody UsuarioRequestDTO request
            ){
        return ResponseEntity.ok(ApiResponse.success("Usuario registrado", "Registro exitoso"));
    }

    @Data
    @AllArgsConstructor
    public static class AuthResponse {
        private String token;
        private String email;
        private String rol;
    }

}
