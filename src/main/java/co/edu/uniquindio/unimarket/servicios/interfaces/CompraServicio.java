package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Compra;

import java.util.List;

public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO);

    List<CompraGetDTO> listarComprasUsuario(int codigoUsuario);

    Compra obtenerCompra(int codigoCompra);
}
