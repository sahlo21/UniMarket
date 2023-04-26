package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.modelo.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Calificacion;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/calificacion")
@RestController
@AllArgsConstructor
public class CalificacionController {
    private final CalificacionServicio calificacionServicio;
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearCalificacion(@Valid @RequestBody CalificacionDTO calificacionDTO) throws Exception{
        calificacionServicio.crearCalificacion(calificacionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Calificacion asignada correctamente"));
    }
    @GetMapping("/listarCalificacion/{codigoProducto}")
    public ResponseEntity<MensajeDTO> listarCalificacion(@PathVariable int codigoProducto){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, calificacionServicio.listarCalificacion(codigoProducto)));
    }
    @PostMapping("/promediarCalificaciones")
    public ResponseEntity<MensajeDTO> promediarCalificaciones(List<Calificacion> calificacionDTOList){
        calificacionServicio.promediarCalificaciones(calificacionDTOList);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Promedio de calificacion obtenido"));
    }
}
