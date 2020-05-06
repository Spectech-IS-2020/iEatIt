package mx.spechtech.ieatlt.servicio;

import mx.spechtech.ieatlt.modelo.Direccion;
import mx.spechtech.ieatlt.modelo.Usuario;

public interface ServicioUsuario {
    void guardarCliente(Usuario usuario, Direccion direccion);
    void guardarRepartidor(Usuario usuario, Direccion direccion);
}
