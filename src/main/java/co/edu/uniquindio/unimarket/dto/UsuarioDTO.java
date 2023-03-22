package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UsuarioDTO {
    private String codigo;
    private String nombre;
    private String email;
    private String contrasena;
    private String telefono;
    private String direccion;
}
