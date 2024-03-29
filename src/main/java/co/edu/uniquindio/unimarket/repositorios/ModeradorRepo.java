package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer> {
    @Query("select m from Moderador m where m.email = :email")
    Optional<Moderador> findByEmail(String email);
    @Query("select p from Producto p join ProductoModerado pm on p.codigo = pm.producto.codigo where pm.producto.codigo = :codigoProducto")
    List<ProductoGetDTO> listarProductos(int codigoProducto);
    @Query("select p from Producto p where p.codigo = :codigoProducto")
    Producto revisarProducto (int codigoProducto);
}