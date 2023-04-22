package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraGetDTO;

import java.util.List;

public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO);

    List<CompraGetDTO> listarCompras(int codigoUsuario);

    CompraGetDTO obtenerCompra(int codigoCompra);
}
