package mx.spechtech.ieatlt.repositorio;

import mx.spechtech.ieatlt.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario, String> {
    Usuario findByEmail(String email);
}
