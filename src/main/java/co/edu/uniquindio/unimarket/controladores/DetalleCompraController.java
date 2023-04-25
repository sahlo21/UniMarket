package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.modelo.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.modelo.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetallePrestamoServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/detalleCompra")
@RestController
@AllArgsConstructor
public class DetalleCompraController {
    private final DetallePrestamoServicio detallePrestamoServicio;
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearDetallePrestamo(@Valid @RequestBody DetalleCompraDTO detalleCompraDTO,@Valid @RequestBody Compra comrpa) throws Exception{
        detallePrestamoServicio.crearDetallePrestamo(detalleCompraDTO, comrpa);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Compra creada"));
    }
    @PutMapping("/actualizarUnidades/{unities}")
    public ResponseEntity<MensajeDTO> actualizarUnidades(@Valid @RequestBody Producto product,@PathVariable int unities){
        detallePrestamoServicio.actualizarUnidades(product, unities);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Unidades actualizadas"));
    }
    @GetMapping("/listarDetalleCompra/{idTransaction}")
    public ResponseEntity<MensajeDTO> listarDetallePorCompra(@PathVariable int idTransaction){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, detallePrestamoServicio.listarDetallePorCompra(idTransaction)));
    }
    @GetMapping("/obtener/{codigoDetalle}")
    public ResponseEntity<MensajeDTO> obtenerDetalleCompra(@PathVariable int codigoDetalle) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, detallePrestamoServicio.obtenerDetalleCompra(codigoDetalle)));
    }
}
