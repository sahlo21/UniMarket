package co.edu.uniquindio.unimarket.modelo.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.modelo.entidades.MedioPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class CompraGetDTO {

    private int codigo;

    private LocalDateTime fecha;

    private float valorTotal;

    private MedioPago medioPago;

    private List<DetalleCompra> detalleCompra;
}
