package co.edu.uniquindio.unimarket.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DetalleCompraGetDTO {
    private int codigoProducto;
    private int codigo;
    private float precio;
    private int unidades;
    private int codigoCompra;
}
