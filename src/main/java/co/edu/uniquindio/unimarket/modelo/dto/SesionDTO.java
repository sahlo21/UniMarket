package co.edu.uniquindio.unimarket.modelo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SesionDTO {
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
}