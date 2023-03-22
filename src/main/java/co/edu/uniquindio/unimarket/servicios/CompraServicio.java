package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;

import java.util.List;

public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO);

    List<CompraGetDTO> listarCompras(int codigoUsuario);

    CompraGetDTO obtenerCompra(int codigoCompra);
}
