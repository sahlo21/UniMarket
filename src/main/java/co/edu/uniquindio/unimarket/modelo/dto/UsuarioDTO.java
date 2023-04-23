package co.edu.uniquindio.unimarket.modelo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Setter
@Getter
public class UsuarioDTO {

    @NotNull
    @NotBlank
    @Length(max = 150, message = "El nombre debe tener maximo 100 caracteres")
    private String nombre;

    @NotNull
    @NotBlank
    @Length(max = 100, message = "El correo debe tener maximo 100 caracteres")
    private String email;

    @NotNull
    @NotBlank
    @Length(max = 50, message = "La contrasena debe tener maximo 50 caracteres")
    private String contrasena;

    @NotNull
    @NotBlank
    @Length(max = 100, message = "La direccion debe tener maximo 100 caracteres")
    private String direccion;

    @NotNull
    @NotBlank
    @Length(max = 12, message = "El telefono debe tener maximo 12 caracteres")
    private String telefono;
}
