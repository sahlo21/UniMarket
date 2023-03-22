package co.edu.uniquindio.unimarket.dto;

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

    private int codigoUsuario;

    private MedioPago medioPago;

    private List<DetalleCompraDTO> detalleCompraDTO;
}
