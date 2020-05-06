package mx.spechtech.ieatlt.repositorio;

import mx.spechtech.ieatlt.modelo.Estado;
import mx.spechtech.ieatlt.modelo.Orden;
import mx.spechtech.ieatlt.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioOrden extends CrudRepository<Orden, String> {
    List<Orden> findByEstadoAndRepartidor(Estado estado, Usuario usuario);
    List<Orden> findByEstado(Estado estado);
}
