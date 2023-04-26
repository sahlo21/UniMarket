package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.CuponDTO;
import co.edu.uniquindio.unimarket.modelo.dto.CuponGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Compra;
import co.edu.uniquindio.unimarket.modelo.entidades.Cupon;
import co.edu.uniquindio.unimarket.modelo.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.repositorios.CuponRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CuponServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CuponServicioImpl implements CuponServicio {

    @Autowired
    CuponRepo cuponRepo;
    @Autowired
    UsuarioRepo usuarioRepo;


    @Autowired
    CompraRepo compraRepo;
    @Override
    public int crearCupon(CuponDTO cuponDTO) {
        Cupon cupon = new Cupon();
        cupon.setValor(cuponDTO.getValor());
        cupon.setUsuario(usuarioRepo.obtenerUsuario2(cuponDTO.getCodigoUsuario()));

        return cuponRepo.save( cupon ).getCodigo();
    }

    @Override
    public List<CuponGetDTO> listarCupones(int codigoUsuario) {

        List<CuponGetDTO> lista = cuponRepo.listarCupones(codigoUsuario);

        return lista;
    }

    @Override
    public CuponGetDTO obtenerCupon(int codigoCupon) {

        CuponGetDTO cupon= cuponRepo.obtenerCupon(codigoCupon);
        return cupon;

    }
    @Override
    public CuponGetDTO redimirCupon(int codigoCupon, int codigoCompra) {

        CuponGetDTO cupon= cuponRepo.obtenerCupon(codigoCupon);
        Compra compra= compraRepo.obtenerCompra2(codigoCompra);

        compra.setValorTotal(compra.getValorTotal()-cupon.getValor());
      compraRepo.save(compra);
        return cupon;

    }
    @Override
    public void  asignarCupon(int codigoCupon, int codigoUsuario) {

        Cupon cupon= cuponRepo.obtenerCupon2(codigoCupon);

        Usuario usuario= usuarioRepo.obtenerUsuario2(codigoUsuario);

        usuario.getCuponList().add(cupon);

        usuarioRepo.save(usuario);


    }


}

