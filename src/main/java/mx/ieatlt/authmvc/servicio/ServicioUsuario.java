package mx.ieatlt.authmvc.servicio;

import mx.ieatlt.authmvc.modelo.Direccion;
import mx.ieatlt.authmvc.modelo.Usuario;

public interface ServicioUsuario {
    void guardarCliente(Usuario usuario, Direccion direccion);
    void guardarRepartidor(Usuario usuario);
}
