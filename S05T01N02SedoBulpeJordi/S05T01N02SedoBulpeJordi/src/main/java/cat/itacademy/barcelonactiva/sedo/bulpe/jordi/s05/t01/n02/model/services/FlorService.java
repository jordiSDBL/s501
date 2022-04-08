package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.dto.FlorDTO;

import java.util.List;

/**
 * Interfícies amb tots els mètodes de capa servei
 * que s'implementaran.
 */
public interface FlorService {

        public void desar(Flor flor);
        public void eliminarPerId(Integer id);
        public FlorDTO trobarPerId(Integer id);
        public List<FlorDTO> llistarFlors();
        public FlorDTO convertirEntitatADTO(Flor flor);
        public boolean existeixFlor(Integer id);
        public boolean existeixNom(String nomFlor);

}
