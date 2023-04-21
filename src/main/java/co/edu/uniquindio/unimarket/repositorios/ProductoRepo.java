package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
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
    ProductoGetDTO obtenerProducto(int codigoProducto);
    @Query("select p from Producto p where p.categoriaList = :categoria")
    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);
    @Query("select p from Producto p where p.estado = :estado")
    List<ProductoGetDTO> listarProductosEstado(boolean estado);
    @Query("select p from Producto p join FavotirosProductos fp on p.codigo = fp.producto.codigo join Usuario u on fp.usuario.codigo = u.codigo where u.codigo = :codigoUsuario")
    List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario);
    @Query("select p from Producto p where p.precio >= :precioMinimo AND p.precio <= :precioMaximo")
    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);

   // @Query("select p from Producto p where p.usuario.codigo = :codigoUsuario")
    //List<Producto> listarProductosUsuario(int codigoUsuario);

    //@Query("select p from Producto p where p.nombre like concat( '%', :nombre, '%' ) and p.activo = 1")
   // List<Producto> listarProductosNombre(String nombre);



}