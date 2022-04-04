package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Classe DTO, inclou els mateixos camps que la d'entitat,
 * però s'hi afegeix un nou camp, que es dedueix del camp paisSucursal i la llista
 * interna d'aquesta classe.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalDTO {

    private Integer pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;

    private Stream<String> s = Stream.of(
            "Àustria",
            "Bèlgica",
            "Bulgària",
            "Croàcia",
            "República de Xipre",
            "República Txeca",
            "Dinamarca",
            "Estònia",
            "Finlàndia",
            "França",
            "Alemanya",
            "Grècia",
            "Hongria",
            "Irlanda",
            "Itàlia",
            "Letònia",
            "Lituània",
            "Luxemburg",
            "Malta",
            "Països Baixos",
            "Polònia",
            "Portugal",
            "Romania",
            "Eslovàquia",
            "Eslovènia",
            "Espanya",
            "Suècia");

    private List<String> paisos = s.collect(Collectors.toList());

}