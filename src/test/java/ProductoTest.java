import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.*;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
                Estado.POR_REVISAR,
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

        System.err.println("aakjdskasj"+usuarioServicio.obtenerUsuario(codigoVendedor));

    }
    @Test
    public void obtenerProducto()throws Exception{

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
                Estado.POR_REVISAR,
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
        ProductoGetDTO productoGetDTO = productoServicio.obtenerProducto(codigoProducto);

        System.err.println("Producto"+productoGetDTO.getCodigo()+productoGetDTO.getNombre()+"vendedor: "+productoGetDTO.getCodigoVendedor()+"  "+
                productoGetDTO.getPrecio()+productoGetDTO.getCategorias()+productoGetDTO.getImagenes()+productoGetDTO.getDescripcion()+productoGetDTO.getUnidades());


    }
    @Test
    public void listarNombre()throws Exception{

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "12345",
                "Calle 123");


        //El servicio del usuario nos retorna el código con el que quedó en la base de datos
        int codigoUsuario = usuarioServicio.crearUsuario(usuarioDTO);

        //Se crea la colección de imágenes para el producto.
        List<Imagen> imagenes = new ArrayList<>();
        Imagen imagen = new Imagen();
        imagen.setRuta("http://www.google.com/images/imagenasus.png");
        imagenes.add(imagen);


        //Se crea el producto y se usa el código dado por el servicio de registro de usuario para asignar el vendedor
        ProductoDTO productoDTO = new ProductoDTO(
                codigoUsuario,
                Estado.POR_REVISAR,
                1,
                "Computador Asus 1",
                "Es el mejor computador portatil que el dinero pueda comprar",
                7000000,
                imagenes,
                List.of(Categoria.TECNOLOGIA));

        //Se llama el servicio para crear el producto
         productoServicio.crearProducto( productoDTO );

        //Se crea el producto y se usa el código dado por el servicio de registro de usuario para asignar el vendedor
         productoDTO = new ProductoDTO(
                codigoUsuario,
                Estado.POR_REVISAR,
                1,
                "Computador Asus 2 ",
                "Es el mejor computador portatil que el dinero pueda comprar",
                7000000,
                imagenes,
                List.of(Categoria.TECNOLOGIA));

        //Se llama el servicio para crear el producto
        productoServicio.crearProducto( productoDTO );

        for(ProductoGetDTO producto :productoServicio.listarProductosUsuario(codigoUsuario)) {
            System.err.println(producto.getCodigo()+" name: "+producto.getNombre()+"code: "+producto.getCodigoVendedor()+"   ");

        }




    }
}
