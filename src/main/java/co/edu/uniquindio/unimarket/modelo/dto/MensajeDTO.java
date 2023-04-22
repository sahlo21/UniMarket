package co.edu.uniquindio.unimarket.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
@ToString
public class MensajeDTO<T> {
    private HttpStatus estado;
    private boolean error;
    private T respuesta;
}