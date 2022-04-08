package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.repository;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.domain.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Estén de JpaRepostory per poder fer
 * totes les accions CRUD necessàries.
 */
@Repository
public interface FlorRepo extends JpaRepository<Flor, Integer> {
    boolean existsByNomFlor(String nomFlor);
}
