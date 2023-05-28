package co.edu.uniquindio.unimarket.modelo.entidades;


import co.edu.uniquindio.unimarket.modelo.dto.CompraDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Moderador extends CompraDTO.Persona implements Serializable {
    @OneToMany(mappedBy = "moderador")
    private List<ProductoModerado> productoModeradoList;

}
