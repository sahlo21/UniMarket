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
    private LocalDate fechaLimite;
    @Column(nullable = false)
    private LocalDate fechaCreacion;
    @Column(nullable = false)
    private boolean estado;
    @Column(nullable = false, length = 150)
    private String descripcion;
    @Column(nullable = false)
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
    private List<FavotirosProductos> favotirosProductosList;
    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detalleCompraList;
    @OneToMany(mappedBy = "producto")
    private List<ProductoModerado> productoModeradoList;
    @OneToMany(mappedBy = "producto")
    private List<ProductoUsuario> productoUsuarioList;
}
