package co.edu.ufps.ingsistemas.analisis_impacto.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @NotBlank private String email;

    @NotBlank private String password;

}
