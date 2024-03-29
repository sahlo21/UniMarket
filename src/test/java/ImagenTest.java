import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.servicios.interfaces.CloudinaryServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest(classes = UniMarketApplication.class)
@Transactional
public class ImagenTest {

    @Autowired
    private CloudinaryServicio cloudinaryServicio;


    @Test
    public void subirIamgen() throws Exception {
        File image = new File("src/test/resources/test.jpg");

        Map<String, String> map = cloudinaryServicio.subirImagen(image, "/UnimarketCloud");
        Map<String, String> mapResponse = new HashMap<>();

        mapResponse.put(map.get("public_id"), map.get("url"));

        for(Map.Entry mp: mapResponse.entrySet()){
            System.err.println(mp.getKey()+ ":" + mp.getValue());
        }

    }
    @Test
    public void eliminarImagen() throws Exception {
        cloudinaryServicio.eliminarImagen("co/edu/uniquindio/proyecto/UnimarketCloud/agk1v3k699yetsyqyrig");
    }

}
