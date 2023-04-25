package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.modelo.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.modelo.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario, Integer> {
    @Query("select cm from Comentario cm where cm.producto.codigo = :codigoProducto")
    List<Comentario> listarComentarios(int codigoProducto);

}
