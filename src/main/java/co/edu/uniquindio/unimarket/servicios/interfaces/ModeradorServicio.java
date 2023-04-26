package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;

import java.util.List;

public interface ModeradorServicio {


    List<ProductoGetDTO> listarProductos(Estado estado);

    void revisarProducto (int codigoProducto) throws Exception;

    void cambiarEstado(Estado estado, int codigoProducto) throws Exception;

}
