package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    @Query("select p from Producto p where p.usuario.codigo = :codigoUsuario")
    List<Producto> listarProductosUsuario(int codigoUsuario);
    @Query("select p from Producto p where p.nombre like concat( '%', :nombre, '%' ) ")
    List<Producto> listarProductosNombre(String nombre);
    @Query("select p from Producto p where p.codigo = :codigoProducto")
    Producto obtenerProducto(int codigoProducto);
    @Query("select p from Producto p where :categoria member of p.categoriaList")
    List<Producto> listarProductosCategoria(Categoria categoria);
    @Query("select p from Producto p where p.estado = :estado")
    List<Producto> listarProductosEstado(Estado estado);
    @Query("select p from Producto p join p.usuarioFavList uf on p.codigo = uf.codigo where uf.codigo = :codigoUsuario AND :codigoUsuario member of p.usuarioFavList")
    List<Producto> listarProductosFavoritos(int codigoUsuario);
    @Query("select p from Producto p where p.precio >= :precioMinimo AND p.precio <= :precioMaximo")
    List<Producto> listarProductosPrecio(float precioMinimo, float precioMaximo);

}