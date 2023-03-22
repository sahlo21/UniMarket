package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.MedioPago;
import org.w3c.dom.stylesheets.LinkStyle;

public class CompraDTO {
    private int codigoUsuario;
    private MedioPago medioPago;
    private List<DetalleCompraDto> detalleCompraDtoList;
}
