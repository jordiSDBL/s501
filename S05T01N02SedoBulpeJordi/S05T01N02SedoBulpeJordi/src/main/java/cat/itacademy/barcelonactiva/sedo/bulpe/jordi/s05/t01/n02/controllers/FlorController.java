package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.services.FlorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controladora de Flor
 * S'hi defineixen tots els mètodes HTTP requerits
 * Cada mètode conté anotacions Swagger descriptives del mètode i dels codis de resposta de les peticions.
 */
@RestController
@Api(value = "REST API relacionada amb l'entitat Flor")
@CrossOrigin(origins = "http://localhost:9001")
@RequestMapping("/flor")
public class FlorController {

    @Autowired
    private FlorService florService;

    @ApiOperation(value = "Mostra una flor",
            notes = "Mostra una flor de la base de dades en la versió DTO que inclou un atribut addicional respecte de l'Entitat: TipusFlor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "amb èxit|OK"),
            @ApiResponse(code = 404, message = "no s'ha trobat!!!") })
    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Integer pk_FlorID){

        if(!florService.existeixFlor(pk_FlorID)) {
            return new ResponseEntity<>("No hi ha cap fruita amb aquest id.", HttpStatus.NOT_FOUND);
        }

        FlorDTO florDTO = florService.trobarPerId(pk_FlorID);
        return new ResponseEntity<>(florDTO, HttpStatus.OK);
    }

    @ApiOperation(value = "Afegir una flor",
            notes = "Se li passa un body JSON amb els atributs de l'Entitat excepte el id, que es autoincrementat.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "amb èxit|OK"),
            @ApiResponse(code = 400, message = "O bé falta el nom, el país, o ja existeix la flor!!!") })
    @PostMapping("/afegirFlor")
    public ResponseEntity<?> afegirFlor(@RequestBody @NotNull Flor flor){

        if(flor.getNomFlor().isBlank())
            return new ResponseEntity<>("És necessari introduir un nom.", HttpStatus.BAD_REQUEST);

        if(florService.existeixNom(flor.getNomFlor()))
            return new ResponseEntity<>("Ja existeix una flor amb aquest nom.", HttpStatus.BAD_REQUEST);

        if(flor.getPaisFlor().isBlank())
            return new ResponseEntity<>("És necessari introduir un país.", HttpStatus.BAD_REQUEST);

        Flor fl = flor;
        florService.desar(fl);
        return new ResponseEntity<>(fl.getNomFlor() + " s'ha afegit correctament.", HttpStatus.OK);
    }

    @ApiOperation(value = "Esborra una Flor", notes = "Elimina un registre de flor de la BBDD")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "amb èxit|OK"),
            @ApiResponse(code = 400, message = "S'ha passat un id que no existeix!!!") })
    @DeleteMapping("/esborrarFlor/{id}")
    public ResponseEntity<?> esborrarFlor(@PathVariable("id")Integer pk_FlorID){

        if(!florService.existeixFlor(pk_FlorID))
            return new ResponseEntity<>("No hi ha cap flor amb aquest id.", HttpStatus.BAD_REQUEST);

        florService.eliminarPerId(pk_FlorID);
        return new ResponseEntity<>("La flor s'ha esborrat correctament", HttpStatus.OK);
    }

    @ApiOperation(value = "Mostra Flors", notes = "Mostra una llista amb totes les flors de la base de dades. DTO.")
    @ApiResponse(code = 200, message = "amb èxit|OK")
    @GetMapping("/mostrarTotes")
    public ResponseEntity<?> mostrarFlors(){
        if(florService.llistarFlors().isEmpty())
            return new ResponseEntity<>("La llista és buida.", HttpStatus.OK);

        return new ResponseEntity<List<FlorDTO>>(florService.llistarFlors(), HttpStatus.OK);
    }

    @ApiOperation(value = "Actualitza una Flor", notes = "Canvia els atributs d'una flor, segons el seu id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "amb èxit|OK"),
            @ApiResponse(code = 400, message = "No es pot actualitzar una flor que no existeix!!!") })
    @PutMapping("/actualitzarFlor")
    public ResponseEntity<?> actualitzarFlor(@RequestBody @NotNull Flor flor){
        if(!florService.existeixFlor(flor.getPk_FlorID()))
            return new ResponseEntity<>("Aquesta flor no existeix", HttpStatus.BAD_REQUEST);
        florService.desar(flor);
        return new ResponseEntity<>("La flor s'ha desat correctament", HttpStatus.OK);
    }
}
