package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.dto.EmailDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Calificacion;
import co.edu.uniquindio.unimarket.modelo.entidades.Comentario;
import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.repositorios.CalificacionRepo;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    ComentarioRepo comentarioRepo;
    @Autowired
    private final EmailServicio emailServicio;
    private final UsuarioServicio usuarioServicio;

    ProductoRepo productoRepo;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {


    Comentario comentario = new Comentario();
        comentario.setUsuario(usuarioServicio.obtener(comentarioDTO.getCodigoUsuario()));
        comentario.setObservacion(comentarioDTO.getObservacion());
        comentario.setFechaCreacion(LocalDateTime.now());
        comentario.setProducto(productoRepo.obtenerProducto(comentarioDTO.getCodigoProducto()));

        String cuerpoCorreo= "<p>" + comentario.getUsuario().getNombre() + " ha comentado en tu producto "+comentario.getProducto().getNombre()+"lo siguiente: " + comentario.getObservacion()+"</p>";
        cuerpoCorreo+="<h3>Comentario producto:</h3>";


        emailServicio.enviarEmail(new EmailDTO("Alguien ha comentado tu producto",cuerpoCorreo, comentario.getUsuario().getEmail()));

        return comentarioRepo.save( comentario ).getCodigo();
    }


    @Override
    public List<Comentario> listarComentarios(int codigoProducto) {
        List<Comentario> lista = comentarioRepo.listarComentarios(codigoProducto);

        return lista;
    }
}

