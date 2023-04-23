package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CuponDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CuponGetDTO;

import java.util.List;

public interface CuponServicio {

    int crearCupon(CuponDTO cuponDTO);

    List<CuponGetDTO> listarCupones(int codigoUsuario);

    CuponGetDTO obtenerCompra(int codigoCupon);
}
