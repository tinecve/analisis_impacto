package co.edu.ufps.ingsistemas.analisis_impacto.config;

import co.edu.ufps.ingsistemas.analisis_impacto.model.Usuario;
import co.edu.ufps.ingsistemas.analisis_impacto.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) {
        // Solo crea si NO hay usuarios (evita duplicados en reinicios)
        if (usuarioRepository.count() == 0) {
            log.info("⚙️ Inicializando usuarios por defecto...");

            Usuario admin = Usuario.builder()
                    .nombre("Administrador")
                    .apellido("Sistema")
                    .email("admin@ufps.edu.co")
                    .password(passwordEncoder.encode("Admin123!"))
                    .rol(Usuario.Rol.ADMIN)
                    .build();

            Usuario user = Usuario.builder()
                    .nombre("Usuario")
                    .apellido("Prueba")
                    .email("user@ufps.edu.co")
                    .password(passwordEncoder.encode("User123!"))
                    .rol(Usuario.Rol.USER)
                    .build();

            usuarioRepository.save(admin);
            usuarioRepository.save(user);

            log.info("✅ Usuarios creados: admin@ufps.edu.co / user@ufps.edu.co");
        } else {
            log.info("ℹ️ La base de datos ya contiene usuarios. Se omite la carga inicial.");
        }
    }
}
