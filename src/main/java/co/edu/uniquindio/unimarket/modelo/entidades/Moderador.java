package co.edu.uniquindio.unimarket.modelo.entidades;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Moderador extends Persona implements Serializable {
    @OneToMany(mappedBy = "moderador")
    private List<ProductoModerado> productoModeradoList;

}
