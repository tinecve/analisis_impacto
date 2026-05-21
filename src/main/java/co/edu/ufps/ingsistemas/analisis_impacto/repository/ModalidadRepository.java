package co.edu.ufps.ingsistemas.analisis_impacto.repository;

import co.edu.ufps.ingsistemas.analisis_impacto.model.Modalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModalidadRepository extends JpaRepository<Modalidad, Long> {

    Optional<Modalidad> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

}
