package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Calificacion;

import java.util.List;

public interface CalificacionServicio {

    int crearCalificacion(CalificacionDTO calificacionDTO) throws Exception;

    List<Calificacion> listarCalificacion(int codigoProducto);

    float promediarCalificaciones(List<Calificacion> calificacionDTOList);
}
