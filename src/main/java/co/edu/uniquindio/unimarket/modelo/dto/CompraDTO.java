package co.edu.uniquindio.unimarket.modelo.dto;

import co.edu.uniquindio.unimarket.modelo.entidades.MedioPago;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {
    private int codigoUsuario;
    private MedioPago medioPago;
;
    private List<DetalleCompraDTO> detalleCompraList;

    @MappedSuperclass
    @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class Persona implements Serializable {
        @Id
        @EqualsAndHashCode.Include
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false, length = 15)
        private int codigo;
        @Column(nullable = false, length = 50)
        private String nombre;
        @Column(nullable = false, length = 100)
        private String contrasena;
        @Column(nullable = false, length = 50)
        private String email;



    }
}
