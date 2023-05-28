package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.modelo.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.modelo.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Categoria;
import co.edu.uniquindio.unimarket.modelo.entidades.Estado;
import co.edu.uniquindio.unimarket.modelo.entidades.Producto;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/producto")
@RestController
@AllArgsConstructor
public class ProductoController {
    private final ProductoServicio productoServicio;
    private final UsuarioServicio usuarioServicio;
    private final ImagenesController imagenesController;
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearProducto(@RequestBody ProductoDTO productoDTO) throws Exception{

        System.err.println("aASDAKJHSKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
        productoServicio.crearProducto(productoDTO);
        System.err.println("2222222222222222222222222222222222222222222222K");
        productoDTO.setImagenes(imagenesController.url);
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false,
                "el producto "+productoDTO.getNombre()+" se creo exitosamente") );
    }
    @PutMapping("/actualizar/{codigoProducto}")
    public ResponseEntity<MensajeDTO> actualizarProducto(@PathVariable int codigoProducto, @Valid @RequestBody ProductoDTO productoDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.actualizarProducto(codigoProducto,productoDTO)));
    }
    @DeleteMapping("/eliminar/{codigoProducto}")
    public ResponseEntity<MensajeDTO> eliminarProducto(@PathVariable int codigoProducto) throws Exception{
        productoServicio.eliminarProducto(codigoProducto);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Producto eliminado correctamente"));
    }
    @GetMapping("/obtener/{codigoProducto}")
    public ResponseEntity<MensajeDTO> obtener(@PathVariable int codigoProducto) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.obtener(codigoProducto)));
    }
   // @GetMapping("/listarProductoUsuario/{codigoUsuario}")
   // public ResponseEntity<MensajeDTO> listarProductosUsuario(@PathVariable String codigoUsuario){
   //     return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosUsuario(codigoUsuario)));
   // }

    @GetMapping("/listarProductosCategoria/{categoria}")
    public ResponseEntity<MensajeDTO> listarProductosCategoria(@PathVariable Categoria categoria){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosCategoria(categoria)));
    }
    @GetMapping("/listarProductosEstado/{estado}")
    public ResponseEntity<MensajeDTO> listarProductosEstado(@PathVariable Estado estado){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosEstado(estado)));
    }
    @GetMapping("misproductos/{correoUsuario}")
    public ResponseEntity<MensajeDTO> listarProductosUsuario(@PathVariable String correoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, productoServicio.listarProductosUsuario(correoUsuario)));
    }
    @GetMapping("/listarProductos")
    public ResponseEntity<MensajeDTO> listarProductos(){
            Estado estado= Estado.AUTORIZADOS;

        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosEstado(estado)));
    }
    @GetMapping("/listarProductosFavoritos/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> listarProductosFavoritos(@PathVariable int codigoUsuario){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosFavoritos(codigoUsuario)));
    }
    @GetMapping("/listarProductosPrecio/{precioMinimo}/{precioMaximo}")
    public ResponseEntity<MensajeDTO> listarProductosPrecio(@PathVariable float precioMinimo,@PathVariable float precioMaximo){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosPrecio(precioMinimo,precioMaximo)));
    }
    @GetMapping("/listarProductosNombre/{nombre}")
    public ResponseEntity<MensajeDTO> listarProductosNombre(@PathVariable String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosNombre(nombre)));
    }
    @PostMapping("/guardarFavorito/{codigoProducto}/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> guardarFavorito(@PathVariable int codigoProducto,@PathVariable int codigoUsuario) throws Exception{
        productoServicio.guardarFavorito(codigoProducto, codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Producto guardado en favoritos"));
    }
    @DeleteMapping("/eliminarFavorito/{codigoProducto}/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> eliminarFavorito(@PathVariable int codigoProducto,@PathVariable int codigoUsuario) throws Exception {
        productoServicio.eliminarFavorito(codigoProducto, codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Producto eliminado de favoritos"));
    }
    @GetMapping("/listarCategorias")
    public ResponseEntity<MensajeDTO> listarCategorias(){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarCategorias()));
    }
    @GetMapping("/categorias")
    public ResponseEntity<Categoria[]> getCategorias() {
        return ResponseEntity.status(HttpStatus.OK).body( Categoria.values());
    }
    @GetMapping("cedula/{emailUsuario}")
    public ResponseEntity<MensajeDTO> cedulaUsuario(@PathVariable String emailUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, usuarioServicio.cedulaUsuario(emailUsuario)));
    }

}
