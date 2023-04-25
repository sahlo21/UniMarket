package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Calificacion;
import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.repositorios.CalificacionRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CalificacionServicioImpl implements CalificacionServicio {
    @Autowired
    private final EmailServicio emailServicio;
    CalificacionRepo calificacionRepo;
    ProductoRepo productoRepo;

    private final UsuarioServicio usuarioServicio;



    @Override
    public int crearCalificacion(CalificacionDTO calificacionDTO) throws Exception {
        Calificacion calificacion = new Calificacion();
    calificacion.setUsuario(usuarioServicio.obtener(calificacionDTO.getCodigoUsuario()));
    calificacion.setEstrellas(calificacionDTO.getEstrellas());
    calificacion.setProducto(productoRepo.obtenerProducto(calificacionDTO.getCodigoProducto()));
        return calificacionRepo.save( calificacion ).getCodigo();
    }
    @Override
    public List<Calificacion> listarCalificacion(int codigoProducto) {

        List<Calificacion> lista = calificacionRepo.listarCalificacion(codigoProducto);

        return lista;
    }
    @Override
    public float promediarCalificaciones(List<Calificacion> calificacionList) {
        float promedio=0;

        for(Calificacion calificacion :calificacionList) {
          promedio+=calificacion.getEstrellas();
        }

        return promedio;
    }
}

