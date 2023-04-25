package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.modelo.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Comentario;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/comentario")
@RestController
@AllArgsConstructor
public class ComentarioController {
    private final ComentarioServicio comentarioServicio;
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearComentario(@Valid @RequestBody ComentarioDTO comentarioDTO) throws Exception{
        comentarioServicio.crearComentario(comentarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Comentario creado correctamente"));
    }
    @GetMapping("/listar/{codigoProducto}")
    public ResponseEntity<MensajeDTO> listarComentarios(@PathVariable int codigoProducto){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, comentarioServicio.listarComentarios(codigoProducto)));
    }
}
