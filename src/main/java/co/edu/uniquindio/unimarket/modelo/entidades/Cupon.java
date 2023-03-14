package co.edu.uniquindio.unimarket.modelo.entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cupon implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private int codigo;
    private double valor;
}
