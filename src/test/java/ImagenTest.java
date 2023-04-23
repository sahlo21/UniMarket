import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.modelo.dto.EmailDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ImagenDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Imagen;
import co.edu.uniquindio.unimarket.servicios.interfaces.CloudinaryServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;


@SpringBootTest(classes = UniMarketApplication.class)
@Transactional
public class ImagenTest {

    @Autowired
    private CloudinaryServicio cloudinaryServicio;



    @Test
    public void subirImagen()throws Exception{

        File fichero = new File("C://Users//kssm1//OneDrive//Documentos//GitHub//Marketplace//info//iconMarketplace.png");


        cloudinaryServicio.subirImagen(fichero, "Unimarket");






    }

}
