package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n02.model.domain;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Classe d'entitat, es correspon al que hi ha a la BBDD.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flor")
public class Flor {

    @ApiModelProperty(notes = "Id de la flor - autoincrementat", name = "pk_FlorID", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_FlorID;
    @ApiModelProperty(notes = "Nom de la flor", name = "nomFlor", required = true)
    @Column(name = "nom")
    @NotNull
    private String nomFlor;
    @ApiModelProperty(notes = "País de procedència de la flor", name = "paisFlor", required = true)
    @Column(name = "pais")
    @NotNull
    private String paisFlor;
}