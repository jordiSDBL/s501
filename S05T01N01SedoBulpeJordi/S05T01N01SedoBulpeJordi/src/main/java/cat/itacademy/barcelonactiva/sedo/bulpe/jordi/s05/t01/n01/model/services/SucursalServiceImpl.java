package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.repository.SucursalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mètodes de capa servei implementats.
 * Es convertirà a DTO a entitat segons calgui.
 */
@Service
public class SucursalServiceImpl implements SucursalService{

    @Autowired
    private SucursalRepo sucursalRepo;

    /**
     * Rep una DTO, la convertim a Entitat i la desem amb CRUD.
     * @param sucursalDTO
     */
    @Override
    public void desar(SucursalDTO sucursalDTO) {
        sucursalRepo.save(convertirDTOaEntitat(sucursalDTO));
    }

    /**
     * Rep un id i amb CRUD l'elimina de la BBDD.
     * @param id
     */
    @Override
    public void eliminarPerId(Integer id) {
        sucursalRepo.deleteById(id);
    }

    /**
     * Rep un id, amb CRUD troba l'entitat.
     * Amb orElse(null) gestionem el possible error si no troba
     * cap entitat amb l'id que hem passat.
     * @param id
     * @return
     */
    @Override
    public Sucursal trobarPerId(Integer id) {
        return sucursalRepo.findById(id).orElse(null);
    }

    /**
     * Amb CRUD retorna tots els registres i els converteix a DTO
     * per després passar-los a la capa vista.
     * @return
     */
    @Override
    public List<SucursalDTO> llistarSucursals() {
        return sucursalRepo.findAll()
                .stream()
                .map(this::convertirEntitatADTO)
                .collect(Collectors.toList());
    }

    /**
     * En fem ús per passar d'entitat a DTO
     * @param sucursal
     * @return
     */
    @Override
    public SucursalDTO convertirEntitatADTO(Sucursal sucursal){
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
        sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
        sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
        if(sucursalDTO.getPaisos().contains(sucursalDTO.getPaisSucursal())) {
            sucursalDTO.setTipusSucursal("UE");
        } else {
            sucursalDTO.setTipusSucursal("Fora UE");
        }
        return sucursalDTO;
    }

    /**
     * En fem ús per passar de DTO a entitat
     * @param sucursalDTO
     * @return
     */
    private Sucursal convertirDTOaEntitat(SucursalDTO sucursalDTO){
        Sucursal sucursal = new Sucursal();
        sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
        sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
        sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());

        return sucursal;
    }
}
