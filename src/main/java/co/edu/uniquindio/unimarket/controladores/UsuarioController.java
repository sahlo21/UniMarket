package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.modelo.dto.ContrasenaDTO;
import co.edu.uniquindio.unimarket.modelo.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.modelo.entidades.UsuarioEmailDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/usuario")
@RestController
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioServicio usuarioServicio;
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) throws Exception{
        usuarioServicio.crearUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Usuario creado correctamente"));
    }
    @PutMapping("/actualizar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> actualizarUsuario(@PathVariable int codigoUsuario, @Valid @RequestBody UsuarioDTO usuarioDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, usuarioServicio.actualizarUsuario(codigoUsuario, usuarioDTO)));
    }
    @DeleteMapping("/eliminar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> eliminarUsuario(@PathVariable int codigoUsuario) throws Exception{
        usuarioServicio.eliminarUsuario(codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Usuario eliminado correctamente"));
    }
    @GetMapping("/obtener/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> obtener (@PathVariable int codigoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, usuarioServicio.obtener(codigoUsuario)));
    }
    @PutMapping("/cambiarContraseniaAnterior/{idPerson}")
    public ResponseEntity<MensajeDTO> cambiarConstrasenaAnterior(@PathVariable int idPerson, @Valid @RequestBody ContrasenaDTO passwordDTO) throws Exception{
        usuarioServicio.cambiarConstrasenaAnterior(idPerson, passwordDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Contrasenia cambiada correctamente"));
    }
    @PutMapping("/cambiarContrasenaRecuperada/{emailPerson}")
    public ResponseEntity<MensajeDTO> cambiarContrasenaRecuperada(@PathVariable String emailPerson,@Valid @RequestBody ContrasenaDTO contrasenaDTO) throws Exception{
        usuarioServicio.cambiarContrasenaRecuperada(emailPerson,contrasenaDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Contrasenia cambiada correctamente"));
    }
    @PostMapping("/recuperarContrasena/{usuarioEmailDTO}")
    public ResponseEntity<MensajeDTO> recuperarContrasena(@PathVariable UsuarioEmailDTO usuarioEmailDTO) throws Exception{
        usuarioServicio.recuperarContrasena(usuarioEmailDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Correo enviado correctamente"));
    }
}
