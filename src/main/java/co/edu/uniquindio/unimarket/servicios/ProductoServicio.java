package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;

import java.util.List;

public interface ProductoServicio {
    int crearProducto(ProductoDTO productoDTO);
    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO);
    int eliminarProducto(int codigoProducto);
    ProductoGetDTO obtenerProducto(int codigoProducto);
    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);
    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);
    List<ProductoGetDTO> listarProductosEstado(boolean estado);
    List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario);
    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);
    List<ProductoGetDTO> listarProductosNombre(String nombre);
}
