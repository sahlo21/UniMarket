package co.edu.uniquindio.unimarket.modelo.dto;
import co.edu.uniquindio.unimarket.modelo.entidades.UsuarioCupones;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CuponDTO  {

    private int codigo;

    private double valor;

}
