package mx.spechtech.ieatit.repositorio;

import mx.spechtech.ieatit.modelo.Alimento;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioAlimento extends CrudRepository<Alimento, Integer> {
}
