package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Estén de JpaRepostory per poder fer
 * totes les accions CRUD necessàries.
 */
@Repository
public interface SucursalRepo  extends JpaRepository<Sucursal, Integer> {
}
