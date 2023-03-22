package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Setter
public class ComentarioDTO {
    private String observacion;
    private int codigoUsuario;
    private int codigoProducto;
}
