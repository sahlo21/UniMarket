package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;

public interface ComentarioServicio {
    int crearComentario(ComentarioDTO comentarioDTO);
    List<ComentarioGetDTO> listarComentarios(int codigoProducto);
}
