package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CuponDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CuponGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.CuponServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CuponServicioImpl implements CuponServicio {


    @Override
    public int crearCupon(CuponDTO cuponDTO) {
        return 0;
    }

    @Override
    public List<CuponGetDTO> listarCupones(int codigoUsuario) {
        return null;
    }

    @Override
    public CuponGetDTO obtenerCompra(int codigoCupon) {
        return null;
    }
}

