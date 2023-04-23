package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.DetalleCompraDTO;

import java.util.List;

public interface DetallePrestamoServicio {

    int crearDetallePrestamo(DetalleCompraDTO detalleCompraDTO);

    List<DetalleCompraDTO> listarDetalleCompra(int c);


}
