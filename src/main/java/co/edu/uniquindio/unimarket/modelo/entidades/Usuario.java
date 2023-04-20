package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Usuario extends Persona implements Serializable  {
    @Column(nullable = true, length = 10)
    private String telefono;
    @Column(nullable = false, length = 100)
    private String direccion;
    @OneToMany(mappedBy = "usuario")
    private List<FavotirosProductos> favotirosProductosList;
    @OneToMany(mappedBy="usuario")
    private List<Compra> compraList;
    @OneToMany(mappedBy = "usuario")
    private List<Calificacion> calificaciones;
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;
    @OneToMany(mappedBy = "usuario")
    private List<UsuarioCupones> usuarioCuponesList;
    @OneToMany(mappedBy = "usuario")
    private List<ProductoUsuario> productoUsuarioList;
}
