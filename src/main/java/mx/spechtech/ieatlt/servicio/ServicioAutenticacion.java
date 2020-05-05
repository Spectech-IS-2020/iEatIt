package mx.spechtech.ieatlt.servicio;

import mx.spechtech.ieatlt.modelo.Usuario;

public interface ServicioAutenticacion {
    void autoLogin(String email, String password);

    Usuario usuarioActual();
}
