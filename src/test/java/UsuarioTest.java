import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = UniMarketApplication.class)
    @Transactional
    public class UsuarioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void crearUsuarioTest() throws Exception{

        //Se crea el usuario con el servicio de crearUsuario
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "12345",
                "Calle 123");

        int codigo = usuarioServicio.crearUsuario(usuarioDTO);

        //Se espera que si se registra correctamente entonces el servicio no debe retornar 0
        Assertions.assertNotEquals(0, codigo);
        System.err.println("usuario: "+usuarioDTO.getContrasena()+ usuarioDTO.getNombre()+ usuarioDTO.getEmail()+usuarioDTO.getDireccion()+usuarioDTO.getTelefono());

    }

        @Test
        public void eliminarUsuarioTest() throws Exception{

            //Para eliminar el usuario primero se debe crear
            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    "Pepito 1",
                    "pepe1@email.com",
                    "1234",
                    "Calle 123",
                    "123123");

            int codigo = usuarioServicio.crearUsuario(usuarioDTO);

            //Una vez creado, lo borramos
            int codigoBorrado = usuarioServicio.eliminarUsuario(codigo);

            //Si intentamos buscar un usuario con el codigo del usuario borrado debemos obtener una excepción indicando que ya no existe
            Assertions.assertThrows(Exception.class, () -> usuarioServicio.obtenerUsuario(codigoBorrado));

        }


        @Test
        public void actualizarUsuarioTest() throws Exception{

            //Para actualizar el usuario primero se debe crear
            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    "Pepito 1",
                    "pepe1@email.com",
                    "1234",
                    "Calle 123",
                    "343");

            int codigoNuevo = usuarioServicio.crearUsuario(usuarioDTO);

            //El servicio de actualizar nos retorna el usuario
            UsuarioGetDTO usuarioActualizado = usuarioServicio.actualizarUsuario(codigoNuevo, new UsuarioDTO("Pepito Perez", "pepe1@email.com", "1234", "Calle 123", "1111"));

            //Se comprueba que ahora el teléfono del usuario no es el que se usó cuando se creó inicialmente
            Assertions.assertNotEquals("2782", usuarioActualizado.getTelefono());

        }

        @Test
        public void obtenerUsuarioTest()throws Exception{

            //Para obtener el usuario primero se debe crear
            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    "Pepito 1",
                    "pepe1@email.com",
                    "1234",
                    "Calle 123",
                    "343");

            int codigoNuevo = usuarioServicio.crearUsuario(usuarioDTO);

            //Se llama el servicio para obtener el usuario completo dado su código
            UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuario(codigoNuevo);

            //Comprobamos que la dirección que está en la base de datos coincide con la que esperamos
            Assertions.assertEquals("Calle 123", usuarioGetDTO.getDireccion());
            System.err.println("usuario: "+ usuarioGetDTO.getNombre()+ usuarioGetDTO.getEmail()+usuarioGetDTO.getDireccion()+usuarioGetDTO.getTelefono());

        }

    }

