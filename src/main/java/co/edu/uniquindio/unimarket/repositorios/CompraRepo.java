package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {
    @Query("select c from Compra c where c.usuario.codigo = :codigoUsuario")
    List<Compra> listarComprasUsuario(int codigoUsuario);
    @Query("select c from Compra c where c.codigo = :codigoCompra")
    CompraGetDTO obtenerCompra(int codigoCompra);

    @Query("select c from Compra c where c.codigo = :codigoCompra")
    Compra obtenerCompra2(int codigoCompra);

}
