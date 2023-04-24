package co.edu.uniquindio.unimarket.modelo.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.modelo.entidades.MedioPago;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {
    private int codigo;
    private MedioPago medioPago;
    private float valorTotal;
    private List<DetalleCompra> detalleCompraList;
}
