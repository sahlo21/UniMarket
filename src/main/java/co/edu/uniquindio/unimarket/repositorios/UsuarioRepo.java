package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
    @Query("select u from Usuario u where u.email = :correo")
    Usuario buscarUsuario(String correo);
    @Query("select u from Usuario u where u.codigo = :codigo")
    UsuarioGetDTO obtenerUsuario(int codigo);
    @Query("select u from Usuario u where u.email = :email")
    Optional<Usuario> findByEmail(String email);

}