package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class UsuarioCupones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFavoritoProducto;

    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Cupon cupon;
}
