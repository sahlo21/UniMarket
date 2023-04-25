package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Calificacion;
import co.edu.uniquindio.unimarket.modelo.entidades.Comentario;
import co.edu.uniquindio.unimarket.repositorios.CalificacionRepo;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    ComentarioRepo comentarioRepo;

    private final UsuarioServicio usuarioServicio;

    //private final ProductoServicio productoServicio;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {


    Comentario comentario = new Comentario();
    /*
        comentario.setUsuario(usuarioServicio.obtener(comentarioDTO.getCodigoUsuario()));
        comentario.setObservacion(comentarioDTO.getObservacion());
        comentario.setFechaCreacion(LocalDateTime.now());
        comentario.setProducto(productoServicio.obtener(comentarioDTO.getCodigoProducto()));
        return comentarioRepo.save( comentario ).getCodigo();

     */
        return 0;
    }


    @Override
    public List<Comentario> listarComentarios(int codigoProducto) {
        List<Comentario> lista = comentarioRepo.listarComentarios(codigoProducto);

        return lista;
    }
}

