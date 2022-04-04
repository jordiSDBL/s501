package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controladora per a totes les accions que tenen a veure amb la gestió de la BBDD.
 */
@Controller
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("/sucursals")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    /**
     * Retorna la vista amb la llista de tots els registres de la BBDD.
     * Retorna les classes DTO, per tant, també els camps addicionals que no consten a la BBDD.
     * @param model
     * @return
     */
    @GetMapping("/llista")
    public String llistarSucursals(Model model){
        List<SucursalDTO> llistatSucursals = sucursalService.llistarSucursals();

        model.addAttribute("titol", "Llista de sucursals");
        model.addAttribute("sucursals", llistatSucursals);

        return "llistar";
    }

    /**
     * Retorna la vista amb el formulari per afegir els valors als atributs de l'entitat.
     * @param model
     * @return
     */
    @GetMapping("/afegir")
    public String afegir(Model model){

        SucursalDTO sucursalDTO = new SucursalDTO();

        model.addAttribute("titol", "Formulari: afegir sucursal");
        model.addAttribute("sucursal", sucursalDTO);

        return "afegir";
    }

    /**
     * Retorna la vista amb el formulari per afegir els valors als atributs de l'entitat.
     * A més hi volca les dades de l'entitat trobada, per tant serveix per modificar ja que el
     * id també es passa en ocult i en comptes de crear un nou registre, el modifica.
     * @param pk_SucursalID
     * @param model
     * @return
     */
    @GetMapping("/editar/{pk_SucursalID}")
    public String editar(@PathVariable("pk_SucursalID") Integer pk_SucursalID, Model model){
        Sucursal sucursal = sucursalService.trobarPerId(pk_SucursalID);

        model.addAttribute("titol", "Formulari: editar sucursal");
        model.addAttribute("sucursal", sucursal);
        return "afegir";
    }

    /**
     * Retorna una vista per visualitzar una sola sucursal
     * @param pk_SucursalID
     * @param model
     * @return
     */
    @GetMapping("/mostrar/{pk_SucursalID}")
    public String mostrar(@PathVariable("pk_SucursalID") Integer pk_SucursalID, Model model){
        SucursalDTO sucursalDTO = sucursalService.convertirEntitatADTO(sucursalService.trobarPerId(pk_SucursalID));
        model.addAttribute("titol", "Detalls sucursal");
        model.addAttribute("sucursal", sucursalDTO);
        return "mostrar";
    }

    /**
     * A través de l'id per paràmtre, esborra un registre i redirigeix a la llista de sucursals.
     * @param pk_SucursalID
     * @return
     */
    @GetMapping("/eliminar/{pk_SucursalID}")
    public String eliminar(@PathVariable("pk_SucursalID") Integer pk_SucursalID){
        sucursalService.eliminarPerId(pk_SucursalID);
            return "redirect:/sucursals/llista";
    }

    /**
     * Emmagatzema el que s'introdueix al formulari afegir, per tant, serveix tant per un nou registre com
     * per modificar registre.
     * @param sucursalDTO
     * @param errors
     * @return
     */
    @PostMapping("/desar")
    public String desar(@ModelAttribute SucursalDTO sucursalDTO, Errors errors){
        if(errors.hasErrors()) {
            return "afegir";
        }
        sucursalService.desar(sucursalDTO);
        return "redirect:/sucursals/llista";
    }
}
