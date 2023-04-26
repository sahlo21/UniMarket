import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.modelo.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CuponDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CuponGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Comentario;
import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.Cupon;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.unimarket.repositorios.CuponRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.CuponServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;


@SpringBootTest(classes = UniMarketApplication.class)
@Transactional
public class CuponTest {
@Autowired
      CuponRepo cuponRepo;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private CuponServicio cuponServicio;
    @Autowired
    private CompraServicio compraServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crerCuponTest() throws Exception {

        CuponDTO cuponDTO = new CuponDTO(
                1000,
                1
        );



        int codeCupon = cuponServicio.crearCupon(cuponDTO);


        for(Cupon cupon :cuponServicio.listarCupones(1)) {
            System.err.println("Cupon: "+cupon.getValor()+"code: "+cupon.getCodigo());
        }

        Assertions.assertNotEquals(0, codeCupon);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCuponesUsuarios() {
        for(Cupon cupon :cuponServicio.listarCupones(1)) {
            System.err.println("Cupon: "+cupon.getValor()+" code: "+cupon.getCodigo());
        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCupon() {
        Cupon cupon=cuponRepo.obtenerCupon(33);
        System.err.println("Cupon: "+cupon.getValor()+" code: "+cupon.getCodigo());

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void redimirCupon() {
        Compra compra = compraServicio.obtenerCompra(11);
        System.err.println("COMPRA BEFORE: "+compra.getValorTotal()+compra.getMedioPago());
        cuponServicio.redimirCupon(31, 11);
        Compra compra2 = compraServicio.obtenerCompra(11);
        System.err.println("COMPRA AFTER: "+compra2.getValorTotal()+compra2.getMedioPago());

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void asignarCupon() {
        cuponServicio.asignarCupon(34,1);
        for(Cupon cupon :cuponServicio.listarCupones(1)) {
            System.err.println("Cupon: "+cupon.getValor()+" code: "+cupon.getCodigo());
        }

    }


}
