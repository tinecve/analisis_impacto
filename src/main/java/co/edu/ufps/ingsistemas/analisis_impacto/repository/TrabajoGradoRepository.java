package co.edu.ufps.ingsistemas.analisis_impacto.repository;

import co.edu.ufps.ingsistemas.analisis_impacto.model.TrabajoGrado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrabajoGradoRepository extends JpaRepository<TrabajoGrado, Long> {

    Optional<TrabajoGrado> findByTitulo(String titulo);

    boolean existsByTitulo(String titulo);

}
