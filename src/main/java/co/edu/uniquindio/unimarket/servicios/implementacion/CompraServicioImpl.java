package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.*;
import co.edu.uniquindio.unimarket.modelo.entidades.*;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {
    private final CompraRepo compraRepo;
    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;
    private final EmailServicio emailServicio;

    private final DetallePrestamoServicio detallePrestamoServicio;
    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {

        Compra compra = new Compra();

        compra.setMedioPago(compraDTO.getMedioPago());
        Usuario usuario = usuarioServicio.obtener(compraDTO.getCodigoUsuario());
        compra.setUsuario(usuario);
        compra.setFechaCreacion(LocalDateTime.now());

        List<DetalleCompra> detalleCompraList = new ArrayList<>();

        float subtotal=0;

        for (DetalleCompraDTO detalleCompraDTO: compraDTO.getDetalleCompraList()) {
            DetalleCompra detalleCompra = detallePrestamoServicio.crearDetallePrestamo(detalleCompraDTO, compra);
            detalleCompraList.add(detalleCompra);
            subtotal+=detalleCompra.getPrecio();
        }

        compra.setDetalleCompraList(detalleCompraList);
        compra.setValorTotal(subtotal);
        compraRepo.save(compra);

        String infoDetails= "<p>" + usuario.getNombre() + " ha realizado su transaccion con un valor de $" + subtotal + " con exito.</p>";
        infoDetails+="<h3>Detalles de la transacción:</h3>";

        for (DetalleCompra detalleCompra :detalleCompraList) {
            infoDetails+="<p><b>Producto:</b> " + detalleCompra.getProducto().getNombre() ;
        }
        System.out.println(infoDetails);

        emailServicio.enviarEmail(new EmailDTO("Transaccion realizada",infoDetails, usuario.getEmail()));

        return compra.getCodigo();
    }




    @Override
    public List<Compra> listarComprasUsuario(int codigoUsuario) {

        List<Compra> lista = compraRepo.listarComprasUsuario(codigoUsuario);



        return lista;
    }
    @Override
    public Compra obtenerCompra(int codigoCompra) {
        Optional<Compra> compra = compraRepo.findById(codigoCompra);

        return compra.get();
    }
}

