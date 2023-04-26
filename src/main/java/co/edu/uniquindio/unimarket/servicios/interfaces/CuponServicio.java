package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CuponDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CuponGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Cupon;

import java.util.List;

public interface CuponServicio {

    int crearCupon(CuponDTO cuponDTO);

    List<Cupon> listarCupones(int codigoUsuario);

    Cupon obtenerCupon(int codigoCupon);

    Cupon redimirCupon(int codigoCupon, int codigoCompra);

    void  asignarCupon(int codigoCupon, int codigoUsuario);
}
