package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.*;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {
    private final ProductoRepo productoRepo;
    @Autowired
    private final UsuarioServicio usuarioServicio;
    UsuarioRepo usuarioRepo;


    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombre( productoDTO.getNombre() );
        producto.setUnidades( productoDTO.getUnidades() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setImagenList( productoDTO.getImagenes() );
        producto.setUsuario( usuarioServicio.obtener( productoDTO.getCodigoVendedor() ));
        producto.setCategoriasList( productoDTO.getCategorias() );
        producto.setFechaCreacion( LocalDateTime.now() );
        producto.setFechaLimite( LocalDateTime.now().plusDays(60) );
        producto.setEstado(Estado.AUTORIZADOS);

        return productoRepo.save( producto ).getCodigo();
    }
    private Producto convertir(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombre( productoDTO.getNombre() );
        producto.setUnidades( productoDTO.getUnidades() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setImagenList( productoDTO.getImagenes() );
        producto.setUsuario( usuarioServicio.obtener( productoDTO.getCodigoVendedor() ));
        producto.setCategoriasList( productoDTO.getCategorias() );
        producto.setFechaCreacion( LocalDateTime.now() );
        producto.setFechaLimite( LocalDateTime.now().plusDays(60) );
        producto.setEstado(Estado.SIN_REVISAR);

        return producto;

    }
    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception {

        /**
         * TODO Validar que el correo no se repita
         */

        validarExiste(codigoProducto);

        Producto producto = convertir(productoDTO);
        producto.setCodigo(codigoProducto);

        return (productoRepo.save(producto)).getCodigo();
    }
    private void validarExiste(int codigoProducto) throws Exception{
        boolean existe = productoRepo.existsById(codigoProducto);

        if( !existe ){
            throw new Exception("El código "+codigoProducto+" no está asociado a ningún producto");
        }

    }

    @Override
    public int eliminarProducto(int codigoProducto) throws Exception {
        validarExiste(codigoProducto);
        productoRepo.deleteById(codigoProducto);
        return codigoProducto;
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
    public List<ProductoGetDTO> listarProductosUsuario(String codigoUsuario) {

       List<Producto> lista = productoRepo.listarProductosUsuario(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

       for(Producto p : lista){
          respuesta.add( convertir(p) );
       }
        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public void guardarFavorito(int codigoProducto, int codigoUsuario) throws Exception {
        Usuario usuarioEncontrado=usuarioServicio.obtener(codigoUsuario);
        Producto productoEncontrado= productoRepo.obtenerProducto(codigoProducto);

        if(usuarioEncontrado != null && productoEncontrado != null) {
            usuarioEncontrado.getProductoFavList().add(productoEncontrado);

            usuarioRepo.save(usuarioEncontrado);
        }else{
            throw new Exception("El usuario y/o producto no existen");
        }
    }

    @Override
    public void eliminarFavorito(int codigoProducto, int codigoUsuario) throws Exception {
        Usuario usuarioEncontrado=usuarioServicio.obtener(codigoUsuario);
        Producto productoEncontrado= productoRepo.obtenerProducto(codigoProducto);

        if(usuarioEncontrado != null && productoEncontrado != null) {
            usuarioEncontrado.getProductoFavList().remove(productoEncontrado);
            usuarioRepo.save(usuarioEncontrado);
        }else{
            throw new Exception("El usuario y/o producto no existen");
        }
    }

    @Override
    public List<Categoria> listarCategorias() {
        return null;
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
                producto.getCategoriasList()


        );

        return productoGetDTO;

    }
  //  @Override
  //  public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {
       // List<Producto> lista = productoRepo.listarProductosCategoria(categoria);
       // List<ProductoGetDTO> respuesta = new ArrayList<>();

        //for(Producto p : lista){
        //    respuesta.add( convertir(p) );
        //}

       // return respuesta;
   // }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) {
//        List<Producto> lista = productoRepo.listarProductosFavoritos(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        //for(Producto p : lista){
       //     respuesta.add( convertir(p) );
        //}

        return respuesta;
    }
    //@Override
    //public List<Categoria> listarCategorias() {
      //  return  productoRepo.listarCategorias();
   // }
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
        List<Producto> lista = productoRepo.listarProductosPrecio(precioMinimo,precioMaximo);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosEstado(Estado estado) {
        List<Producto> lista = productoRepo.listarProductosEstado(estado);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }


}
