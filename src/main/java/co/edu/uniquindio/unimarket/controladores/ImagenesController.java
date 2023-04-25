package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.modelo.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.CloudinaryServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.Map;
@RestController
@RequestMapping("api/imagenes")
@AllArgsConstructor
public class ImagenesController {
    private final CloudinaryServicio cloudinaryServicio;
    @PostMapping("/upload")
    public ResponseEntity<MensajeDTO> subirImagen(@RequestParam("file") MultipartFile file)
            throws Exception{
        File imagen = cloudinaryServicio.convertir(file);
        Map respuesta = cloudinaryServicio.subirImagen(imagen, "proyecto");
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                respuesta ) );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeDTO> eliminarImagen(@PathVariable String id) throws Exception{
        Map respuesta = cloudinaryServicio.eliminarImagen(id);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                respuesta ) );
    }
}
