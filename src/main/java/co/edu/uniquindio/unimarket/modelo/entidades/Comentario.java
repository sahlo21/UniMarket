package co.edu.uniquindio.unimarket.modelo.entidades;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false, length = 250)
    private String observacion;
    private LocalDateTime fechaCreacion;
    @ManyToOne
    private Producto producto;
    @ManyToOne
    private Usuario usuario;
}
