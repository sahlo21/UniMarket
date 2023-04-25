package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false)
    private int unidades;
    @Column(nullable = false)
    @ToString.Exclude
    private LocalDateTime fechaLimite;
    @Column(nullable = false)
    @ToString.Exclude
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;
    @Column(nullable = false, length = 150)
    private String descripcion;
    @Column(nullable = false)
    @ToString.Exclude
    private float precio;
    @ElementCollection
    private List<Categoria> categoriaList;
    @OneToMany(mappedBy="producto")
    private List<Comentario> comentarioList;
    @OneToMany(mappedBy="producto")
    private List<Imagen> imagenList;
    @OneToMany(mappedBy="producto")
    private List<Calificacion> calificacionList;
    @OneToMany(mappedBy = "producto")
    private List<FavoritosProductos> favotirosProductosList;
    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detalleCompraList;
    @OneToMany(mappedBy = "producto")
    private List<ProductoModerado> productoModeradoList;
    @ManyToOne
    private Usuario usuario;
}
