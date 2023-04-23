package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CalificacionServicioImpl implements CalificacionServicio {


    @Override
    public int crearCalificacion(CalificacionDTO calificacionDTO) {
        return 0;
    }

    @Override
    public List<CalificacionDTO> listarCalificacion() {
        return null;
    }

    @Override
    public float promediarCalificaciones(List<CalificacionDTO> calificacionDTOList) {
        return 0;
    }
}

