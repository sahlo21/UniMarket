package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;

public interface UsuarioServicio {
    int crearUsuario(UsuarioDTO usuarioDTO);
    int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO);
    int eliminarUsuario(int codigoUsuario);

    UsuarioDTO obtenerUsuario(int codigoUsuario);

}
