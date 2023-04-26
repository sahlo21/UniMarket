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
    List<CuponGetDTO> listarCupones(int codigoUsuario);
    @Query("select c from Cupon c join Usuario u on c.usuario.codigo = u.codigo join Compra cm on u.codigo = cm.usuario.codigo where c.codigo = :codigoCupon")
    CuponGetDTO obtenerCupon(int codigoCupon);
    @Query("select c from Cupon c join Usuario u on c.usuario.codigo = u.codigo join Compra cm on u.codigo = cm.usuario.codigo where c.codigo = :codigoCupon")
    Cupon obtenerCupon2(int codigoCupon);

}