package co.edu.uniquindio.unimarket.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmailDTO {

    private String asunto;
    private String cuerpo;
    private String destinatario;

}
