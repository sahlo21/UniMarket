package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.*;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {
    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombre( productoDTO.getNombre() );
        producto.setUnidades( productoDTO.getUnidades() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setImagenList( productoDTO.getImagenes() );
        producto.setUsuario( usuarioServicio.obtener( productoDTO.getCodigoVendedor() ));
        producto.setCategoriaList( productoDTO.getCategorias() );
        producto.setFechaCreacion( LocalDateTime.now() );
        producto.setFechaLimite( LocalDateTime.now().plusDays(60) );
        producto.setEstado(Estado.POR_REVISAR);

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
    public ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception{
        return convertir( obtener(codigoProducto) );
    }

    public Producto obtener(int codigoProducto) throws Exception{
        Optional<Producto> producto = productoRepo.findById(codigoProducto);

        if(producto.isEmpty() ){
            throw new Exception("El código "+codigoProducto+" no está asociado a ningún usuario");
        }

        return producto.get();
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
                producto.getEstado(),
                producto.getFechaLimite(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getUnidades(),
                producto.getPrecio(),
                producto.getUsuario().getCodigo(),
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

        List<Producto> lista = productoRepo.listarProductosNombre(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
           respuesta.add( convertir(p) );
        }

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
