package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe DTO, inclou els mateixos camps que la d'entitat,
 * però s'hi afegeix un nou camp, que es dedueix del mètode intern
 * d'aquesta classe.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlorDTO {

    private Integer pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipusFlor;

    public void determinarTipus(){
        List<String> llistarPaisos = new ArrayList<>();
        llistarPaisos.addAll(Arrays.asList("Àustria", "Bèlgica", "Bulgària", "Croàcia",
                "República de Xipre", "República Txeca", "Dinamarca", "Estònia", "Finlàndia",
                "França", "Alemanya", "Grècia", "Hongria", "Irlanda", "Itàlia", "Letònia",
                "Lituània", "Luxemburg", "Malta", "Països Baixos", "Polònia", "Portugal",
                "Romania", "Eslovàquia", "Eslovènia", "Espanya", "Suècia"));

        this.tipusFlor = (llistarPaisos.contains(this.getPaisFlor()))?"UE":"Fora UE";
    }
}
