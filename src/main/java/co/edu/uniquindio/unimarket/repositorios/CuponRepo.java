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
    @Query("select cp from Cupon cp join UsuarioCupones uc on cp.codigo = uc.cupon.codigo where uc.usuario.codigo = :codigoUsuario")
    List<CuponGetDTO> listarCupones(int codigoUsuario);
    @Query("select c from Compra c join Usuario u on c.usuario.codigo = u.codigo join UsuarioCupones uc on u.codigo = uc.usuario.codigo where uc.cupon.codigo = :codigoCupon")
    CuponGetDTO obtenerCompra(int codigoCupon);

}