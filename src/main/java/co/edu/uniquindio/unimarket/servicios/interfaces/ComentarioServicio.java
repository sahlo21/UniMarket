package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {
    int crearComentario(ComentarioDTO comentarioDTO);
    List<ComentarioGetDTO> listarComentarios(int codigoProducto);
}
