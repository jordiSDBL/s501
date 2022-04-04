package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /**
     * Només per mostrar una pàgina d'inici
     * @return
     */
    @GetMapping("/home")
    public String inici() {
        return "home";
    }
}
