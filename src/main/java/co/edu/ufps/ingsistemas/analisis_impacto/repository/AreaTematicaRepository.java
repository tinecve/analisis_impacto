package co.edu.ufps.ingsistemas.analisis_impacto.repository;

import co.edu.ufps.ingsistemas.analisis_impacto.model.AreaTematica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AreaTematicaRepository extends JpaRepository<AreaTematica, Long> {

    Optional<AreaTematica> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
