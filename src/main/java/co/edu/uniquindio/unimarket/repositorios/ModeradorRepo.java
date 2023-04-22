package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.modelo.entidades.Moderador;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, String> {
    Optional<Moderador> findByEmail(String email);
}