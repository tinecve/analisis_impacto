package co.edu.ufps.ingsistemas.analisis_impacto.repository;

import co.edu.ufps.ingsistemas.analisis_impacto.model.Cohorte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CohorteRepository extends JpaRepository<Cohorte, Long> {

    boolean existsById(Long id);
    Optional<Cohorte> findByAnioAndSemestre(Integer anio, String semestre);
    boolean existsByAnioAndSemestre(Integer anio, String semestre);
}
