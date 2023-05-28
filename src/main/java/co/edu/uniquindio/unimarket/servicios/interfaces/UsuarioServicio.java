package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.ContrasenaDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.modelo.entidades.UsuarioEmailDTO;

public interface UsuarioServicio {

    int crearUsuario(UsuarioDTO usuarioDTO)  throws Exception;
    UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception;
    int eliminarUsuario(int codigoUsuario) throws Exception;

    String cambiarContrasenaRecuperada(String emailPerson, ContrasenaDTO contrasenaDTO) throws Exception;

    UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception;
    Usuario obtener(int codigoUsuario) throws Exception;



    int cambiarConstrasenaAnterior(int idPerson, ContrasenaDTO passwordDTO) throws Exception;

    void recuperarContrasena(String usuarioEmailDTO) throws Exception;
    int cedulaUsuario(String cedulaUsuario)throws Exception;

}
