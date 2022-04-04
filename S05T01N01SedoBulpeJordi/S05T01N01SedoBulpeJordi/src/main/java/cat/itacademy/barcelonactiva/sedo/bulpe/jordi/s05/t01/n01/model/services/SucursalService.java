package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.dto.SucursalDTO;

import java.util.List;

/**
 * Interfícies amb tots els mètodes de capa servei
 * que s'implementaran.
 */
public interface SucursalService {

    public void desar(SucursalDTO sucursalDTO);
    public void eliminarPerId(Integer id);
    public Sucursal trobarPerId(Integer id);
    public List<SucursalDTO> llistarSucursals();
    public SucursalDTO convertirEntitatADTO(Sucursal sucursal);
}
