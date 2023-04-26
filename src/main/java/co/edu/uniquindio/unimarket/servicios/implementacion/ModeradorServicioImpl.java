package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.repositorios.ModeradorRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {
    private final ModeradorRepo moderadorRepo;
    private final CompraRepo compraRepo;
    private final ProductoRepo productoRepo;
    @Autowired
    private final UsuarioServicio usuarioServicio;
    @Autowired
    private final EmailServicio emailServicio;
    @Autowired
    private final DetallePrestamoServicio detallePrestamoServicio;
    @Autowired
    private final ProductoServicio productoServicio;

    @Override
    public List<ProductoGetDTO> listarProductos(Estado estado){
        List<ProductoGetDTO> lista = productoServicio.listarProductosEstado(estado);
        return lista;
    }

    @Override
    public void revisarProducto(int codigoProducto) throws Exception {

        Producto producto = moderadorRepo.revisarProducto(codigoProducto);

        System.out.println("Producto: "+producto.getNombre()+"Precio"+producto.getPrecio());


    }

    @Override
    public void cambiarEstado(Estado estado, int codigoProducto) throws Exception {

        Producto producto = productoServicio.obtener(codigoProducto);
        producto.setEstado(estado);

         (productoRepo.save(producto)).getCodigo();

    }


}
