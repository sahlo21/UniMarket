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
    private int codigoUsuario;
    private MedioPago medioPago;
;
    private List<DetalleCompraDTO> detalleCompraList;

}
