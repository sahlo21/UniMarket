package co.edu.uniquindio.unimarket.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class CuponGetDTO  {

    private int codigo;

    private float valor;

}
