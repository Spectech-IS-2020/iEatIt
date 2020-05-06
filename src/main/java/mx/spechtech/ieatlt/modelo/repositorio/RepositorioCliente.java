package mx.spechtech.ieatlt.modelo.repositorio;

import mx.spechtech.ieatlt.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioCliente extends CrudRepository<Cliente, Integer> {
}
