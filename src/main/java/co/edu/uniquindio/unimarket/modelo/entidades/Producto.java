package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private int codigo;
    private Categoria categoria;
    private int unidades;
    private LocalDate fechaLimite;
    private LocalDate fechaCreado;
    private boolean estado;
    private String descripcion;
    private double precio;

}
