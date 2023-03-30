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
public class Compra implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false)
    private LocalDate fechaCreacion;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MedioPago medioPago;
    @Column(nullable = false)
    private float valorTotal;
    @OneToMany(mappedBy="compra")
    private List<DetalleCompra> detalleCompraList;
    @ManyToOne
    private Usuario usuario;


}
