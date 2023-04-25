import co.edu.uniquindio.unimarket.UniMarketApplication;
import co.edu.uniquindio.unimarket.modelo.dto.ContrasenaDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.modelo.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(classes = UniMarketApplication.class)
    @Transactional
    public class UsuarioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private UsuarioRepo usuarioRepo;

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
        @Sql("classpath:dataset.sql")
        public void eliminarUsuarioTest() throws Exception{

            //Una vez creado, lo borramos
            int codigoBorrado = usuarioServicio.eliminarUsuario(1);

            //Si intentamos buscar un usuario con el codigo del usuario borrado debemos obtener una excepción indicando que ya no existe
            Assertions.assertThrows(Exception.class, () -> usuarioServicio.obtenerUsuario(codigoBorrado));

        }


    @Sql("classpath:dataset.sql" )
    @Test
    public void actualizarUsuarioTest() throws Exception{

        //Para actualizar el usuario primero se debe crear

        UsuarioGetDTO guardado = usuarioServicio.obtenerUsuario(1);
        System.err.println("HOLAAAAAAA: "+guardado.getNombre());
        UsuarioDTO modificado = new UsuarioDTO(
                guardado.getNombre(),
                guardado.getEmail(),
                "contrasenia",
                guardado.getDireccion(),
                "8191");
//

        //El servicio de actualizar nos retorna el usuario


        //El servicio de actualizar nos retorna el usuario
        UsuarioGetDTO usuarioActualizado = usuarioServicio.actualizarUsuario(guardado.getCodigo(), modificado);

        //Se comprueba que ahora el teléfono del usuario no es el que se usó cuando se creó inicialmente
        Assertions.assertNotEquals("2782", usuarioActualizado.getTelefono());

    }
        @Sql("classpath:dataset.sql" )
        @Test
        public void obtenerUsuarioTest()throws Exception{



            //Se llama el servicio para obtener el usuario completo dado su código
            UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuario(1);

            //Comprobamos que la dirección que está en la base de datos coincide con la que esperamos
            System.err.println("usuario: "+ usuarioGetDTO.getNombre()+ usuarioGetDTO.getEmail()+usuarioGetDTO.getDireccion()+usuarioGetDTO.getTelefono());

        }
    @Test
    @Sql("classpath:dataset.sql" )
    public void cambiarConstrasenaAnterior() throws Exception {
        Usuario usuarioGetDTO = usuarioRepo.obtenerUsuario2(1);

        //Comprobamos que la dirección que está en la base de datos coincide con la que esperamos
        System.err.println("usuario 1 : "+ usuarioGetDTO.getContrasena());

        ContrasenaDTO contrasenaDTO = new ContrasenaDTO("aceituna2","aceituna2");

        Usuario pastUsuario = usuarioServicio.obtener(1);

        String contrasenaAnterior = pastUsuario.getContrasena();


        usuarioServicio.cambiarConstrasenaAnterior(pastUsuario.getCodigo(),contrasenaDTO);

        String nuevaContrasena = usuarioRepo.buscarUsuario("kssm102001@gmail.com").getContrasena();


        Assertions.assertNotEquals(contrasenaAnterior,nuevaContrasena);

        Usuario usuarioGetDTO2 = usuarioRepo.obtenerUsuario2(1);

        //Comprobamos que la dirección que está en la base de datos coincide con la que esperamos
        System.err.println("usuario 2 : "+ usuarioGetDTO2.getContrasena());

    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void changePasswordRecuperated() throws Exception {

        ContrasenaDTO contrasenaDTO = new ContrasenaDTO("contresanaxd","contresanaxd");

        String contrasenaAnterior = usuarioRepo.buscarUsuario("kssm102001@gmail.com").getContrasena();


        usuarioServicio.cambiarContrasenaRecuperada("kssm102001@gmail.com",contrasenaDTO);

        String nuevaContrasena = usuarioRepo.buscarUsuario("kssm102001@gmail.com").getContrasena();

        Assertions.assertNotEquals(contrasenaAnterior,nuevaContrasena);
    }
    }

