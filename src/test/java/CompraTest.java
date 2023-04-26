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
    @Sql("classpath:dataset.sql")
    public void crerCompraTest() throws Exception {

        List<DetalleCompraDTO> detalleCompraDTOS = new ArrayList<>();

        DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO(
                7,
                1
        );


        detalleCompraDTOS.add(detalleCompraDTO);

        CompraDTO compraDTO = new CompraDTO(
                1,
                MedioPago.PAGO_CONTRAENTREGA,
                detalleCompraDTOS
        );

        int codeCompra = compraServicio.crearCompra(compraDTO);

        Compra compra = compraServicio.obtenerCompra(codeCompra);
        System.err.println("COMPRA: "+compra.getValorTotal()+compra.getMedioPago());

        for(DetalleCompra detalleCompra :compra.getDetalleCompraList()) {
            System.err.println("DETAIL:"+detalleCompra.getCodigo()+" name: "+compra.getValorTotal()+"   "+compra.getMedioPago());

        }

        Assertions.assertNotEquals(0, codeCompra);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCompra() {
        List<Compra> listarComprasUsuario = compraServicio.listarComprasUsuario(1);
        for(Compra compra :listarComprasUsuario) {
            System.err.println("Compra: "+compra.getValorTotal()+"   "+compra.getMedioPago());
            for(DetalleCompra detalleCompra :compra.getDetalleCompraList()) {
                System.err.println("DETAIL:"+detalleCompra.getCodigo()+" name: "+compra.getValorTotal()+"   "+compra.getMedioPago());

            }
        }
        System.out.println(listarComprasUsuario);
        Assertions.assertFalse(listarComprasUsuario.isEmpty());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCompra() throws Exception {
        Compra compra = compraServicio.obtenerCompra(11);
        System.err.println("Compra: "+compra.getValorTotal()+"   "+compra.getMedioPago());

        Assertions.assertNotNull(compra);
    }



}


