package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;
import co.edu.uniquindio.unimarket.modelo.entidades.Imagen;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {
    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;

    @Override
    public int crearProducto(ProductoDTO productoDTO)  {

        Producto producto = new Producto();
        producto.setNombre( productoDTO.getNombre() );
        producto.setUnidades( productoDTO.getUnidades() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setImagenList( productoDTO.getImagenes() );
        producto.setCategoriaList( productoDTO.getCategorias() );

        return productoRepo.save( producto ).getCodigo();
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO)  {
        return 0;
    }

    public int actualizarUnidades(int codigoProducto, int unidades) throws Exception{
        return 0;
    }


    public int actualizarEstado(int codigoProducto, boolean estado) {
        return 0;
    }

    @Override
    public int eliminarProducto(int codigoProducto) {
        return 0;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) {

        List<Producto> lista = productoRepo.listarProductosUsuario(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

       for(Producto p : lista){
           respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    private ProductoGetDTO convertir(Producto producto){

        ProductoGetDTO productoGetDTO = new ProductoGetDTO(

                producto.getCodigo(),
                producto.getUsuario().getCodigo(),
                producto.getUnidades(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getImagenList(),
                producto.getCategoriaList()
        );

        return productoGetDTO;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {
        return null;
    }




    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) {

        //List<Producto> lista = productoRepo.listarProductosNombre(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        //for(Producto p : lista){
         //  respuesta.add( convertir(p) );
        //}

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosEstado(boolean estado) {
        return null;
    }


}
