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
    @OneToMany(mappedBy="usuario")
    private List<Producto> productoList;
    @ManyToMany(mappedBy = "usuario")
    private List<Producto> Usuario;
    @OneToMany(mappedBy="usuario")
    private List<Compra> compraList;
    @OneToMany(mappedBy = "usuario")
    private List<Calificacion> calificaciones;
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;
    @ManyToMany(mappedBy = "usuario")
    private List<Cupon> cuponList;
    @ManyToMany(mappedBy = "usuario")
    private List<Producto> producto;
}
