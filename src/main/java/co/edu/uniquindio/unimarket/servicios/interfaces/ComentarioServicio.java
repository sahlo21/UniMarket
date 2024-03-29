package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Comentario;

import java.util.List;

public interface ComentarioServicio {
    int crearComentario(ComentarioDTO comentarioDTO) throws Exception;
    List<Comentario> listarComentarios(int codigoProducto);
}
