package co.edu.ufps.ingsistemas.analisis_impacto.repository;

import co.edu.ufps.ingsistemas.analisis_impacto.model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {

    Optional<TipoProducto> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    

}
