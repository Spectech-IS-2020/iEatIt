package mx.ieatlt.authmvc.servicio.implementacion;

import mx.ieatlt.authmvc.modelo.Direccion;
import mx.ieatlt.authmvc.modelo.Role;
import mx.ieatlt.authmvc.modelo.Usuario;
import mx.ieatlt.authmvc.repositorio.RepositorioDireccion;
import mx.ieatlt.authmvc.repositorio.RepositorioUsuario;
import mx.ieatlt.authmvc.servicio.ServicioUsuario;
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
        save(usuario, Role.ROLE_CLIENTE);
        repositorioDireccion.save(direccion);
    }

    public void guardarRepartidor(Usuario usuario) {
        save(usuario, Role.ROLE_REPARTIDOR);
    }
}
