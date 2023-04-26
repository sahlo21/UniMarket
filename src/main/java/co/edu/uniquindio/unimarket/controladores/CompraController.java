package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/compra")
@RestController
@AllArgsConstructor
public class CompraController {
    private CompraServicio compraServicio;
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearCompra(@Valid @RequestBody CompraDTO compraDTO) throws Exception{
        compraServicio.crearCompra(compraDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Compra creada correctamente"));
    }
    @GetMapping("/listarComprasUsuario/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> listarComprasUsuario(@PathVariable int codigoUsuario){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, compraServicio.listarComprasUsuario(codigoUsuario)));
    }
    @GetMapping("/obtenerCompra/{codigoCompra}")
    public ResponseEntity<MensajeDTO> obtenerCompra(@PathVariable int codigoCompra){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, compraServicio.obtenerCompra(codigoCompra)));
    }
}
