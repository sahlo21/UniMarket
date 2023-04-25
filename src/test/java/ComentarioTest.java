import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.modelo.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.EmailDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Comentario;
import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.modelo.entidades.MedioPago;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
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
public class ComentarioTest {
@Autowired
ComentarioRepo comentarioRepo;
    @Autowired
    private ComentarioServicio comentarioServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crerComentarioTest() throws Exception {

        ComentarioDTO comentarioDTO = new ComentarioDTO(
                "ay que lindo",
                1,
                11
        );

        int codeComen = comentarioServicio.crearComentario(comentarioDTO);


        for(Comentario comentario :comentarioServicio.listarComentarios(6)) {
            System.err.println("Comentario: "+comentario.getCodigo()+comentario.getObservacion());
        }

        Assertions.assertNotEquals(0, codeComen);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentarios() {
        List<Comentario> listarComentarios = comentarioServicio.listarComentarios(6);
        for(Comentario comentario :listarComentarios) {
            System.err.println("Comentario: "+comentario.getObservacion()+"   "+comentario.getUsuario().getNombre()+comentario.getUsuario().getCodigo());

        }

    }



}
