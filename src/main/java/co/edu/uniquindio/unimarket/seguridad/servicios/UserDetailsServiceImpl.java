package co.edu.uniquindio.unimarket.seguridad.servicios;

import co.edu.uniquindio.unimarket.modelo.entidades.Moderador;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ModeradorRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.seguridad.modelo.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private ModeradorRepo moderadorRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> cliente = usuarioRepo.findByEmail(email);
        if(cliente.isEmpty()){
            Optional<Moderador> admin = moderadorRepo.findByEmail(email);
            if(admin.isEmpty())
                throw new UsernameNotFoundException("El usuario no existe");
            return UserDetailsImpl.build(admin.get());
        }else{
            return UserDetailsImpl.build(cliente.get());
        }
    }
}