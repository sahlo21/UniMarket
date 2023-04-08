package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductoModerado implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false, length = 250)
    private String motivo;
    private LocalDate fechaRevision;
    @ElementCollection
    private List<Estado> estados;
    @ManyToOne
    private Producto producto;
    @ManyToOne Moderador moderador;
}
