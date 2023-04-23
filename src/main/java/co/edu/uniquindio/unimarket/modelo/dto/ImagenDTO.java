package co.edu.uniquindio.unimarket.modelo.dto;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter

public class ImagenDTO implements Serializable {


    private String ruta;

    private Producto producto;
}
