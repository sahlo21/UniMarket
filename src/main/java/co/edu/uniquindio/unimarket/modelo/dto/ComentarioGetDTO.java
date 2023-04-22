package co.edu.uniquindio.unimarket.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Setter
public class ComentarioGetDTO {
    private int codigo;
    private LocalDate fechaCreacion;
    private String observacion;
    private int codigoUsuario;
    private int codigoProducto;
}
