package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.modelo.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;

import java.util.List;

public interface ProductoServicio {
    int crearProducto(ProductoDTO productoDTO) throws Exception;
    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO);
    int eliminarProducto(int codigoProducto);
    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;
    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);
    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);
    List<ProductoGetDTO> listarProductosEstado(boolean estado);
    List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario);
    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);
    List<ProductoGetDTO> listarProductosNombre(String nombre);
}
