package co.edu.uniquindio.unimarket.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona implements Serializable {
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

