package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.dto.CuponGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Cupon;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuponRepo extends JpaRepository<Cupon, Integer> {
    @Query("select c from Cupon c where c.usuario.codigo = :codigoUsuario")
    List<Cupon> listarCupones(int codigoUsuario);
    @Query("select c from Cupon c where c.codigo = :codigoCupon")
    Cupon obtenerCupon(int codigoCupon);



}