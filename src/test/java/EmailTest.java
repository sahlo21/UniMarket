import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.modelo.dto.EmailDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = UniMarketApplication.class)
@Transactional
public class EmailTest {

    @Autowired
    private EmailServicio emailServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void enviarEmail()throws Exception{



        EmailDTO email= new EmailDTO("hola","esta es una prueba" ,"kssm21p@gmail.com" );


        emailServicio.enviarEmail(email);



    }

}
