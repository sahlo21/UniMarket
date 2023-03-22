package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.SesionDTO;
import co.edu.uniquindio.unimarket.dto.TokenDTO;

public interface ServicioSesion {
    TokenDTO login(SesionDTO sesionDTO);
    void logout(int codigoUsuario);
}
