package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.ContrasenaDTO;
import co.edu.uniquindio.unimarket.modelo.dto.EmailDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.modelo.entidades.UsuarioEmailDTO;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {
    private final UsuarioRepo usuarioRepo;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final EmailServicio emailServicio;

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception{

        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getEmail());

        if(buscado!=null){
            throw new Exception("El correo "+usuarioDTO.getEmail()+" ya estÃ¡ en uso");
        }

        Usuario usuario = convertir(usuarioDTO);
        return usuarioRepo.save( usuario ).getCodigo();
    }

    @Override
    public UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception{

        /**
         * TODO Validar que el correo no se repita
         */

        validarExiste(codigoUsuario);

        Usuario usuario = convertir(usuarioDTO);
        usuario.setCodigo(codigoUsuario);

        return convertir( usuarioRepo.save(usuario) );
    }

    @Override
    public int eliminarUsuario(int codigoUsuario) throws Exception{
        validarExiste(codigoUsuario);
        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;
    }
    private boolean validatePassword(String newPassword, String newPasswordRepeated) throws Exception {

        if(newPassword.equals(newPasswordRepeated) != true){
            throw new Exception("Las contraseñas no coinciden");
        }

        return true;
    }

     @Override
    public int cambiarConstrasenaAnterior(int idPerson, ContrasenaDTO passwordDTO) throws Exception {
        Usuario usuarioEncontrado = usuarioRepo.obtenerUsuario2(idPerson);

        if(usuarioEncontrado == null){
            throw new Exception("No se encontro una persona con el id " + idPerson);
        }
        String newPassword = passwordDTO.getPassword();
        String newPasswordRepeated = passwordDTO.getPasswordRepeated();

        validatePassword(newPassword,newPasswordRepeated);

        usuarioEncontrado.setContrasena(passwordEncoder.encode(newPassword));

        usuarioRepo.save(usuarioEncontrado);
        emailServicio.enviarEmail(new EmailDTO("Se actualizó su contraseña", "Ha actualizado con exito la contraseña de su cuenta", usuarioEncontrado.getEmail()));

        return usuarioEncontrado.getCodigo();
    }

    @Override
    public void recuperarContrasena(String usuarioEmailDTO) throws Exception {
        emailServicio.enviarEmail(new EmailDTO("Recuperar contraseña","Para recuperar su contraseña ingrese al siguiente enlace: https://www.unimarket.com/api/personas/recuperar_contraseña/" + usuarioEmailDTO,usuarioEmailDTO));


    }
@Override
    public String cambiarContrasenaRecuperada(String emailPerson, ContrasenaDTO contrasenaDTO) throws Exception {
        Usuario usuarioEncontrado = usuarioRepo.buscarUsuario(emailPerson);

        if(usuarioEncontrado == null){
            throw new Exception("No se encontro una persona con el correo " + emailPerson);
        }

        String newPassword = contrasenaDTO.getPassword();
        String newPasswordRepeated = contrasenaDTO.getPasswordRepeated();

        validatePassword(newPassword,newPasswordRepeated);

        usuarioEncontrado.setContrasena(passwordEncoder.encode(newPassword));

        usuarioRepo.save(usuarioEncontrado);
        emailServicio.enviarEmail(new EmailDTO("Se recuperó su contraseña", "Ha recuperado con exito la contraseña de su cuenta", usuarioEncontrado.getEmail()));

        return usuarioEncontrado.getContrasena();
    }


        @Override
    public UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception{
        return convertir( obtener(codigoUsuario) );
    }

    public Usuario obtener(int codigoUsuario) throws Exception{
        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario);

        if(usuario.isEmpty() ){
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

        return usuario.get();
    }



    private void validarExiste(int codigoUsuario) throws Exception{
        boolean existe = usuarioRepo.existsById(codigoUsuario);

        if( !existe ){
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

    }

    private UsuarioGetDTO convertir(Usuario usuario){

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getCodigo(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getTelefono());

        return usuarioDTO;
    }

    private Usuario convertir(UsuarioDTO usuarioDTO){

        Usuario usuario = new Usuario();
        usuario.setNombre( usuarioDTO.getNombre() );
        usuario.setEmail( usuarioDTO.getEmail() );
        usuario.setDireccion( usuarioDTO.getDireccion() );
        usuario.setTelefono( usuarioDTO.getTelefono() );
        usuario.setContrasena( passwordEncoder.encode( usuarioDTO.getContrasena()));

        return usuario;
    }
}
