package mx.spechtech.ieatlt.modelo.repositorio;

import mx.spechtech.ieatlt.modelo.Estado;
import mx.spechtech.ieatlt.modelo.Orden;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioOrden extends CrudRepository<Orden, String> {
    List<Orden> findByEstado(Estado estado);
}
