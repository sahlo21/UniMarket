package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.SesionDTO;
import co.edu.uniquindio.unimarket.modelo.dto.TokenDTO;

public interface ServicioSesion {
    TokenDTO login(SesionDTO sesionDTO);
    void logout(int codigoUsuario);
    
}
