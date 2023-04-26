import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.*;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;

import java.util.List;


@SpringBootTest(classes = UniMarketApplication.class)
@Transactional
public class ProductoTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void registrarProducto()throws Exception{

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "12345",
                "Calle 123");


        //El servicio del usuario nos retorna el código con el que quedó en la base de datos
        int codigoVendedor = usuarioServicio.crearUsuario(usuarioDTO);

        //Se crea la colección de imágenes para el producto.
        List<Imagen> imagenes = new ArrayList<>();
        Imagen imagen = new Imagen();
        imagen.setRuta("http://www.google.com/images/imagenasus.png");
        imagenes.add(imagen);



        //Se crea el producto y se usa el código dado por el servicio de registro de usuario para asignar el vendedor
        ProductoDTO productoDTO = new ProductoDTO(
                codigoVendedor,
                Estado.SIN_REVISAR,
                1,
                "Computador Asus 1",
                "Es el mejor computador portatil que el dinero pueda comprar",
                7000000,
                imagenes,
                List.of(Categoria.TECNOLOGIA));

        //Se llama el servicio para crear el producto
        int codigoProducto = productoServicio.crearProducto( productoDTO );

        //Se espera que el servicio retorne el código del nuevo producto
        Assertions.assertNotEquals(0, codigoProducto);

        System.err.println("Producto"+usuarioServicio.obtenerUsuario(codigoVendedor));

    }
    @Sql("classpath:dataset.sql" )
    @Test
    public void obtenerProducto()throws Exception{


        ProductoGetDTO productoGetDTO = productoServicio.obtenerProducto(6);

        System.err.println("Producto"+productoGetDTO.getCodigo()+productoGetDTO.getNombre()+"vendedor: "+productoGetDTO.getCodigoVendedor()+"  "+
                productoGetDTO.getPrecio()+productoGetDTO.getCategorias()+productoGetDTO.getImagenes()+productoGetDTO.getDescripcion()+productoGetDTO.getUnidades());


    }
    @Sql("classpath:dataset.sql" )
    @Test
    public void listarProductodUsuario()throws Exception{

        for(ProductoGetDTO producto :productoServicio.listarProductosUsuario(1)) {
            System.err.println(producto.getCodigo()+" name: "+producto.getNombre()+"code: "+producto.getCodigoVendedor()+"   ");

        }
    }
    @Sql("classpath:dataset.sql" )
    @Test
    public void actualizarProducto()throws Exception{
        ProductoGetDTO guardado = productoServicio.obtenerProducto(7);

        ProductoDTO modificado = new ProductoDTO(
                guardado.getCodigoVendedor(),
                guardado.getEstado(),
                10,
                guardado.getNombre(),
                guardado.getDescripcion(),
                80000,
                guardado.getImagenes(),
                guardado.getCategorias());
//

        //El servicio de actualizar nos retorna el usuario


        //El servicio de actualizar nos retorna el usuario
        int codeUpdate= productoServicio.actualizarProducto(guardado.getCodigo(), modificado);
        ProductoGetDTO productoGetDTO=productoServicio.obtenerProducto(codeUpdate);

        System.err.println("Producto"+productoGetDTO.getNombre()+
                productoGetDTO.getPrecio()+productoGetDTO.getUnidades());

        //Se comprueba que ahora el teléfono del usuario no es el que se usó cuando se creó inicialmente
        Assertions.assertNotEquals("2782", productoGetDTO.getPrecio());
    }
    @Sql("classpath:dataset.sql" )
    @Test
    public void eliminarProducto()throws Exception{
        //Una vez creado, lo borramos
        int codigoBorrado = productoServicio.eliminarProducto(7);

        //Si intentamos buscar un usuario con el codigo del usuario borrado debemos obtener una excepción indicando que ya no existe
        Assertions.assertThrows(Exception.class, () -> productoServicio.obtener(codigoBorrado));
    }

    @Sql("classpath:dataset.sql" )
    @Test
    public void listarProductosCategoria()throws Exception{
        for(ProductoGetDTO producto :productoServicio.listarProductosCategoria(Categoria.ACCESORIOS)) {
            System.err.println(producto.getCodigo()+" name: "+producto.getNombre()+"code: "+producto.getCodigoVendedor()+"   ");

        }
    }

    @Sql("classpath:dataset.sql" )
    @Test
    public void listarProductosEstado()throws Exception{
        for(ProductoGetDTO producto :productoServicio.listarProductosEstado(Estado.SIN_REVISAR)) {
            System.err.println(producto.getCodigo()+" name: "+producto.getNombre()+"code: "+producto.getCodigoVendedor()+"   ");

        }
    }

    @Sql("classpath:dataset.sql" )
    @Test
    public void listarProductosFavoritos()throws Exception{
        for(Producto producto :usuarioServicio.obtener(1).getProductoFavList()) {
            System.err.println(producto.getCodigo()+" name: "+producto.getNombre()+"code: "+"   ");

        }
    }

    @Sql("classpath:dataset.sql" )
    @Test
    public void listarProductosPrecio()throws Exception{
        for(ProductoGetDTO producto :productoServicio.listarProductosPrecio(1000, 15001)) {
            System.err.println(producto.getCodigo()+" name: "+producto.getNombre()+"code: "+producto.getCodigoVendedor()+"   ");

        }
    }

    @Sql("classpath:dataset.sql" )
    @Test
    public void listarProductosNombre()throws Exception{
        for(ProductoGetDTO producto :productoServicio.listarProductosNombre("Lapiz")) {
            System.err.println(producto.getCodigo()+" name: "+producto.getNombre()+"code: "+producto.getCodigoVendedor()+"   ");

        }
    }

    @Sql("classpath:dataset.sql" )
    @Test
    public void guardarFavorito()throws Exception{


        productoServicio.guardarFavorito(7,1);
        productoServicio.guardarFavorito(8,1);

        for(Producto producto :usuarioServicio.obtener(1).getProductoFavList()) {
            System.err.println(producto.getCodigo()+" name: "+producto.getNombre()+"code: "+"   ");

        }
    }

    @Sql("classpath:dataset.sql" )
    @Test
    public void eliminarFavorito()throws Exception {
        for(Producto producto :usuarioServicio.obtener(1).getProductoFavList()) {
            System.err.println(producto.getCodigo()+" name: "+producto.getNombre()+"code: "+"   ");

        }

        productoServicio.eliminarFavorito(6, 1);


        for(Producto producto :usuarioServicio.obtener(1).getProductoFavList()) {
            System.err.println(producto.getCodigo()+" name: "+producto.getNombre()+"code: "+"   ");

        }
    }

}
