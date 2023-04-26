import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.modelo.dto.SesionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.TokenDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.servicios.interfaces.ServicioSesion;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(classes = UniMarketApplication.class)
@Transactional
public class AutenticacionTest {
    @Autowired
    private ServicioSesion servicioSesion;
    @Autowired
    private  UsuarioServicio usuarioServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void autenticarse() throws Exception {

        Usuario usuario = usuarioServicio.obtener(1);

        TokenDTO tokenDTO = servicioSesion.login(new SesionDTO(
                usuario.getEmail(),
                usuario.getContrasena()
        ));

        Assertions.assertNotNull(tokenDTO);

    }
}
