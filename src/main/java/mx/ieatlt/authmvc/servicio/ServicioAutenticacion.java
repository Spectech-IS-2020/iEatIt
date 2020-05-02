package mx.ieatlt.authmvc.servicio;

import mx.ieatlt.authmvc.modelo.Usuario;

public interface ServicioAutenticacion {
    void autoLogin(String email, String password);

    Usuario usuarioActual();
}
