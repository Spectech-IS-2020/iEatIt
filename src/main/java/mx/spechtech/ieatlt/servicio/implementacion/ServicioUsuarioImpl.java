package mx.spechtech.ieatlt.servicio.implementacion;

import mx.spechtech.ieatlt.modelo.Direccion;
import mx.spechtech.ieatlt.modelo.Role;
import mx.spechtech.ieatlt.modelo.Usuario;
import mx.spechtech.ieatlt.repositorio.RepositorioDireccion;
import mx.spechtech.ieatlt.repositorio.RepositorioUsuario;
import mx.spechtech.ieatlt.servicio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuarioImpl implements ServicioUsuario {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private RepositorioDireccion repositorioDireccion;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private void save(Usuario usuario, Role rol) {
        usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
        usuario.setRole(rol);
        repositorioUsuario.save(usuario);
    }

    public void guardarCliente(Usuario usuario, Direccion direccion) {
        save(usuario, Role.CLIENTE);
        direccion.setUsuario(usuario);
        repositorioDireccion.save(direccion);
    }

    public void guardarRepartidor(Usuario usuario) {
        save(usuario, Role.REPARTIDOR);
    }
}
