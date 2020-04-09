package mx.spechtech.ieatlt.modelo.repositorio;

import mx.spechtech.ieatlt.modelo.Alimento;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioAlimento extends CrudRepository<Alimento, Integer> {
}
