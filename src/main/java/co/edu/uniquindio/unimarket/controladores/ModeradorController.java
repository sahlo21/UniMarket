package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.modelo.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/moderador")
@RestController
@AllArgsConstructor
public class ModeradorController {
    private final ModeradorServicio moderadorServicio;
    @GetMapping("/listarProducto/{estado}")
    public ResponseEntity<MensajeDTO> listarProductos(@PathVariable Estado estado){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, moderadorServicio.listarProductos(estado)));
    }
    @PutMapping("/revisarProducto/{codigoProducto}")
    public ResponseEntity<MensajeDTO> revisarProducto (@PathVariable int codigoProducto) throws Exception {
        moderadorServicio.revisarProducto(codigoProducto);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Estado del producto revisado"));
    }
}
