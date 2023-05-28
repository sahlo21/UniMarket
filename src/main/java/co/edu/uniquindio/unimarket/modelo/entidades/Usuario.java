package co.edu.uniquindio.unimarket.modelo.entidades;

import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Usuario extends CompraDTO.Persona implements Serializable  {
    @Column(nullable = true, length = 10)
    private String telefono;
    @Column(nullable = false, length = 100)
    private String direccion;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Producto> productoFavList;
    @OneToMany(mappedBy="usuario")
    private List<Compra> compraList;
    @OneToMany(mappedBy = "usuario")
    private List<Calificacion> calificaciones;
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;
    @OneToMany(mappedBy = "usuario")
    private List<Cupon> cuponList;
    @OneToMany(mappedBy = "usuario")
    private List<Producto> productoList;
}
