package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s05.t01.n01.model.domain;

import com.sun.istack.NotNull;
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
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_SucursalID;
    @Column(name = "nom")
    @NotNull
    private String nomSucursal;
    @Column(name = "pais")
    @NotNull
    private String paisSucursal;
}