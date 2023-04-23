package co.edu.uniquindio.unimarket.modelo.dto;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@Getter
@Setter
public class CalificacionDTO  {

    private int codigo;

    private int estrellas;
}
