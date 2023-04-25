import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.modelo.dto.*;
import co.edu.uniquindio.unimarket.modelo.entidades.*;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
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
    public class CompraTest {

    @Autowired
    private CompraServicio compraServicio;

    @Test
    public void crearCompraTest() throws Exception {

        //Se crea el usuario con el servicio de crearUsuario
        CompraDTO compraDTO = new CompraDTO(
                1,
                MedioPago.PAGO_CONTRAENTREGA,
                12121,
                null
        );

        int codigo = compraServicio.crearCompra(compraDTO);

        //Se espera que si se registra correctamente entonces el servicio no debe retornar 0
        Assertions.assertNotEquals(0, codigo);
        System.err.println("compra: " + compraDTO.getValorTotal() + compraDTO.getMedioPago());

    }
    @Test
    public void obtenerCompra()throws Exception {

        CompraDTO compraDTO = new CompraDTO(
                1,
                MedioPago.PAGO_CONTRAENTREGA,
                12121,
                null
        );


        //El servicio del usuario nos retorna el código con el que quedó en la base de datos
        int codigo = compraServicio.crearCompra(compraDTO);

        Compra compra = compraServicio.obtenerCompra(codigo);

        //Se espera que si se registra correctamente entonces el servicio no debe retornar 0
        Assertions.assertNotEquals(0, codigo);
        System.err.println("compra: " + compraDTO.getValorTotal() + compraDTO.getMedioPago());

    }







}


