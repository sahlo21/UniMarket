package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.modelo.dto.CuponDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CuponGetDTO;
import co.edu.uniquindio.unimarket.modelo.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.CuponServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/cupon")
@RestController
@AllArgsConstructor
public class CuponController {
    private final CuponServicio cuponServicio;
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearCupon(@Valid @RequestBody CuponDTO cuponDTO){
        cuponServicio.crearCupon(cuponDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Cupon creado correctamente"));
    }
    @GetMapping("/listarCupones/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> listarCupones(@PathVariable int codigoUsuario){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, cuponServicio.listarCupones(codigoUsuario)));
    }
    @GetMapping("/obtenerCompra/{codigoCupon}")
    public ResponseEntity<MensajeDTO> obtenerCompra(@PathVariable int codigoCupon){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, cuponServicio.obtenerCompra(codigoCupon)));
    }
}
