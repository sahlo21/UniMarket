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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetalleCompraServicioImpl implements DetallePrestamoServicio {

    private final CompraRepo compraRepo;
    private final DetalleCompraRepo detalleCompraRepo;
    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;
    private final EmailServicio emailServicio;

    @Override
    public DetalleCompra crearDetallePrestamo(DetalleCompraDTO detalleCompraDTO, Compra compra) throws Exception {
        DetalleCompra detalleCompra = new DetalleCompra();

        Producto product = productoServicio.obtener(detalleCompraDTO.getCodigoProducto());
        int unidades = detalleCompraDTO.getUnidades();

        if(product.getUnidades()<unidades){
            throw new Exception("No existen las suficientes unidades del producto " + product.getNombre());
        }
        detalleCompra.setCompra(compra);
        detalleCompra.setProducto(product);
        detalleCompra.setUnidades(unidades);
        detalleCompra.setPrecio(calculateTotal(product,unidades));

        detalleCompraRepo.save(detalleCompra);
        String destinario=product.getUsuario().getEmail();
        emailServicio.enviarEmail(new EmailDTO("Transaccion realizada","Ha vendido " + unidades + " unidades de su producto " + product.getNombre() , destinario));

        productoServicio.disminuirUnidades(product,unidades);

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




