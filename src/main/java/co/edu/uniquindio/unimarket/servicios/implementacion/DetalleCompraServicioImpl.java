package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.dto.EmailDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetallePrestamoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetalleCompraServicioImpl implements DetallePrestamoServicio {

    private final CompraRepo compraRepo;
    private final DetalleCompraRepo detalleCompraRepo;
    private final ProductoRepo productoRepo;
    @Autowired
    private final UsuarioServicio usuarioServicio;
    //@Autowired
    //private final ProductoServicio productoServicio;
    @Autowired
    private final EmailServicio emailServicio;

    @Override
    public DetalleCompra crearDetallePrestamo(DetalleCompraDTO detalleCompraDTO, Compra compra) throws Exception {
        DetalleCompra detalleCompra = new DetalleCompra();

       // Producto producto = productoServicio.obtener(detalleCompraDTO.getCodigoProducto());
        Producto producto = null;

        int unidades = detalleCompraDTO.getUnidades();

        if(producto.getUnidades()<unidades){
            throw new Exception("No existen las suficientes unidades del producto " + producto.getNombre());
        }
        detalleCompra.setCompra(compra);
        detalleCompra.setProducto(producto);
        detalleCompra.setUnidades(unidades);
        detalleCompra.setPrecio(calculateTotal(producto,unidades));

        detalleCompraRepo.save(detalleCompra);
        String destinario=producto.getUsuario().getEmail();
        emailServicio.enviarEmail(new EmailDTO("Transaccion realizada","Ha vendido " + unidades + " unidades de su producto " + producto.getNombre() , destinario));

        //productoServicio.actualizarUnidades(producto,unidades);

        return detalleCompra;
    }
    private float calculateTotal(Producto producto, int unidades) {

        float total = producto.getPrecio()*unidades;

        return total;
    }

    @Override
    public List<DetalleCompraGetDTO> listarDetallePorCompra(int idTransaction) {
        return null;
    }

    @Override
    public DetalleCompraGetDTO obtenerDetalleCompraDTO(int idTransactionDetail) throws Exception {
        return null;
    }

    @Override
    public DetalleCompra obtenerDetalleCompra(int codigoDetalle) throws Exception {
        return null;
    }
}




