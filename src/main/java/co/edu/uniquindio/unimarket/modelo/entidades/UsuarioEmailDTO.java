package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class UsuarioEmailDTO {


    @NotNull(message = "El email no puede ser nulo")
    @NotBlank(message = "El email no puede ser vacio")
    @Email
    private String email;
}