package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;

import java.util.List;

public interface ModeradorServicio {

    List<ProductoGetDTO> listarProductos(int codigoProducto);
    Estado revisarProducto (int codigoProducto);

}
