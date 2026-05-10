package co.edu.ufps.ingsistemas.analisis_impacto.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String email;
    private String nombre;
    private String apellido;
    private String rol;
    private LocalDateTime fechaRegistro;
}
