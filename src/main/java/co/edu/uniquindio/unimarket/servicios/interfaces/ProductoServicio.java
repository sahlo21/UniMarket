package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;

import java.util.List;

public interface ProductoServicio {
    int crearProducto(ProductoDTO productoDTO) throws Exception;
    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception;
    int eliminarProducto(int codigoProducto) throws Exception;
    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;
    Producto obtener(int codigoProducto) throws Exception;
    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);
    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);
    List<ProductoGetDTO> listarProductosEstado(Estado estado);
    List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario);
    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);
    List<ProductoGetDTO> listarProductosNombre(String nombre);
    void actualizarUnidades(Producto producto,int unidades);
    void guardarFavorito(int codigoProducto, int codigoUsuario) throws Exception;
     void eliminarFavorito(int codigoProducto, int codigoUsuario) throws Exception;
}
