import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.modelo.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Calificacion;
import co.edu.uniquindio.unimarket.modelo.entidades.Comentario;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;


@SpringBootTest(classes = UniMarketApplication.class)
@Transactional
public class CalificacionTest {
@Autowired
ComentarioRepo comentarioRepo;
    @Autowired
    private CalificacionServicio calificacionServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crerCalificacionTest() throws Exception {

        CalificacionDTO calificacionDTO = new CalificacionDTO(
                6,
                1,
                4
        );

        int codeCal = calificacionServicio.crearCalificacion(calificacionDTO);


        for(Calificacion calificacion :calificacionServicio.listarCalificacion(6)) {
            System.err.println("Calificacion: "+calificacion.getCodigo()+"stars:"+calificacion.getEstrellas());
        }

        Assertions.assertNotEquals(0, codeCal);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentarios() {

        for(Calificacion calificacion :calificacionServicio.listarCalificacion(6)) {
            System.err.println("Calificacion: "+calificacion.getCodigo()+"stars:"+calificacion.getEstrellas());

        }

    }



}
