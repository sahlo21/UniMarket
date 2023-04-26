import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.modelo.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Calificacion;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;


@SpringBootTest(classes = UniMarketApplication.class)
@Transactional
public class ModeradorTest {
@Autowired
ComentarioRepo comentarioRepo;
    @Autowired
    ProductoServicio productoServicio;
    @Autowired
    private ModeradorServicio moderadorServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void revisarProducto() throws Exception {

        moderadorServicio.revisarProducto(6);
        Producto producto=productoServicio.obtener(6);
        System.err.println(producto.getCodigo()+" name: "+producto.getNombre()+"code: "+producto.getPrecio()+"   ");


    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarEstadoProducto() throws Exception {
        Producto producto=productoServicio.obtener(6);
        System.err.println("Producto After:"+producto.getEstado()+" name: "+producto.getNombre()+"code: "+producto.getPrecio());

        moderadorServicio.cambiarEstado(Estado.AUTORIZADOS, 6);
        Producto producto2=productoServicio.obtener(6);
        System.err.println("Producto Before:"+producto2.getEstado()+" name: "+producto2.getNombre()+"code: "+producto2.getPrecio());

    }
    @Sql("classpath:dataset.sql" )
    @Test
    public void listarProductosEstado()throws Exception{
        for(ProductoGetDTO producto :productoServicio.listarProductosEstado(Estado.SIN_REVISAR)) {
            System.err.println(producto.getCodigo()+" name: "+producto.getNombre()+"code: "+producto.getCodigoVendedor()+"   ");

        }
    }



}
