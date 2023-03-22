package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DetalleCompraDTO {
    private int codigoProducto;
    private int unidades;
    private float precioProducto;
}
