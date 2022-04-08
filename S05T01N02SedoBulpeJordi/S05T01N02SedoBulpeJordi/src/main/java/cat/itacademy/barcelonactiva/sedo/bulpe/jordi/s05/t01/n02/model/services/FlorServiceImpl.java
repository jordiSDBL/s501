package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.repository.FlorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mètodes de capa servei implementats.
 * Es convertirà a DTO a entitat segons calgui.
 */
@Service
public class FlorServiceImpl implements FlorService {

    @Autowired
    private FlorRepo florRepo;

    /**
     * Li passem un objecte Flor i el desa
     * a la BBDD
     * @param flor
     */
    @Override
    public void desar(Flor flor) {
        florRepo.save(flor);
    }

    /**
     * Passem id per paràmetre i n'esborra
     * el registre corresponent de la BBDD
     * @param id
     */
    @Override
    public void eliminarPerId(Integer id) {
        florRepo.deleteById(id);
    }

    /**
     * Passem id per paràmetre i ens troba el registre
     * corresponent. El convertim a DTO, perquè voldrem veure
     * tots els camps que conté.
     * @param id
     * @return
     */
    @Override
    public FlorDTO trobarPerId(Integer id) {
        return convertirEntitatADTO(florRepo.findById(id).orElse(null));
    }

    /**
     * Busca tots els registres Flor, els desa en una llista
     * i els converteix a DTO. Retorna la llista.
     * @return
     */
    @Override
    public List<FlorDTO> llistarFlors() {
        return florRepo.findAll()
                .stream()
                .map(this::convertirEntitatADTO)
                .collect(Collectors.toList());
    }

    /**
     * Passem una Flor per paràmetre i ens retorna
     * la FlorDTO corresponent.
     * @param flor
     * @return
     */
    @Override
    public FlorDTO convertirEntitatADTO(Flor flor) {
        FlorDTO florDTO = new FlorDTO();
        florDTO.setPk_FlorID(flor.getPk_FlorID());
        florDTO.setNomFlor(flor.getNomFlor());
        florDTO.setPaisFlor(flor.getPaisFlor());

        florDTO.determinarTipus();
        return florDTO;
    }

    /**
     * Segons el paràmetre id, ens diu si existeix o no una flor amb aquest id.
     * @param id
     * @return
     */
    @Override
    public boolean existeixFlor(Integer id) {
        return florRepo.existsById(id);
    }

    /**
     * Segons el paràmetre nomFlor, ens diu si existeix o no una flor amb aquest nom.
     * @param nomFlor
     * @return
     */
    @Override
    public boolean existeixNom(String nomFlor) {
        return florRepo.existsByNomFlor(nomFlor);
    }
}
