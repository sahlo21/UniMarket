package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;

import java.util.List;

public interface DetallePrestamoServicio {

    DetalleCompra crearDetallePrestamo(DetalleCompraDTO detalleCompraDTO, Compra comrpa) throws Exception;
    List<DetalleCompraGetDTO> listarDetallePorCompra(int idTransaction);
    DetalleCompraGetDTO obtenerDetalleCompraDTO(int idTransactionDetail) throws Exception;
    DetalleCompra obtenerDetalleCompra(int codigoDetalle) throws Exception;

}
