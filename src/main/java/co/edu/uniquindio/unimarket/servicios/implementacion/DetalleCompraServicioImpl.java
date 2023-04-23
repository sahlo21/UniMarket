package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetallePrestamoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetalleCompraServicioImpl implements DetallePrestamoServicio {


    @Override
    public int crearDetallePrestamo(DetalleCompraDTO detalleCompraDTO) {
        return 0;
    }

    @Override
    public List<DetalleCompraDTO> listarDetalleCompra(int c) {
        return null;
    }
}




