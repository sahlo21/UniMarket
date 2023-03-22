package co.edu.uniquindio.unimarket.servicios;

public interface CompraServicio {
    crearCompra();
    Lista<CompraGetDTO> listarCompras(int);
    CompraDTO obtenerCompra();
}
