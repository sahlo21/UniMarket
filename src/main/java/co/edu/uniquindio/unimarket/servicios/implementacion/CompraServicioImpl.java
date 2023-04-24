package co.edu.uniquindio.unimarket.servicios.implementacion;

import co.edu.uniquindio.unimarket.modelo.dto.*;
import co.edu.uniquindio.unimarket.modelo.entidades.*;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {
    private final CompraRepo compraRepo;

    @Override
    public int crearCompra(CompraDTO compraDTO){


        Compra compra = convertir(compraDTO);
        return compraRepo.save( compra ).getCodigo();
    }

    private Compra convertir(CompraDTO compraDTO) {
        Compra compra = new Compra();
        compra.setDetalleCompraList(compraDTO.getDetalleCompraList());
        compra.setFechaCreacion(LocalDateTime.now());
        compra.setMedioPago(compraDTO.getMedioPago());
        compra.setValorTotal(compraDTO.getValorTotal());
        return compra;
    }
    private CompraGetDTO convertir(Compra compra){

        CompraGetDTO compraGetDTO = new CompraGetDTO(
                compra.getCodigo(),
                compra.getFechaCreacion(),
                compra.getValorTotal(),
                compra.getMedioPago(),
                compra.getDetalleCompraList()
        );

        return compraGetDTO;
    }

    @Override
    public List<CompraGetDTO> listarComprasUsuario(int codigoUsuario) {

        List<Compra> lista = compraRepo.listarComprasUsuario(codigoUsuario);
        List<CompraGetDTO> respuesta = new ArrayList<>();

        for (Compra compra : lista) {
            respuesta.add(convertir(compra));
        }
        return respuesta;
    }
    @Override
    public Compra obtenerCompra(int codigoCompra) {
        Optional<Compra> compra = compraRepo.findById(codigoCompra);

        return compra.get();
    }
}

