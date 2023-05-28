package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.modelo.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.modelo.dto.SesionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.TokenDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ServicioSesion;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthController {
    private final UsuarioServicio usuarioServicio;
    private final ServicioSesion servicioSesion;
    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> login(@Valid @RequestBody SesionDTO loginUser) {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                servicioSesion.login(loginUser)) );
    }
    @PostMapping("/registro")
    public ResponseEntity<MensajeDTO> registrarCliente(@Valid @RequestBody UsuarioDTO usuario) throws Exception {

        usuarioServicio.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,
                false, "Cliente creado correctamente"));

    }
    @PostMapping
    public ResponseEntity<MensajeDTO> registrar(@Valid @RequestBody UsuarioDTO usuario) throws Exception {
        usuarioServicio.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false," usuario "+usuario.getNombre()+" Creado exitosamente"));
    }
}
