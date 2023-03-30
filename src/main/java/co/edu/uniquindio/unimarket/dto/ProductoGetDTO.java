package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;
import co.edu.uniquindio.unimarket.modelo.entidades.Imagen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductoGetDTO {

    private int codigoProducto;
    private int codigoVendedor;
    private int unidades;
    private String nombre;
    private String descripcion;
    private float precio;
    private List<Imagen> imagenes;
    public List<Categoria> categorias;
}
