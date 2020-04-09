package mx.spechtech.ieatlt.controlador;

import mx.spechtech.ieatlt.modelo.Alimento;
import mx.spechtech.ieatlt.modelo.Cliente;
import mx.spechtech.ieatlt.modelo.Direccion;
import mx.spechtech.ieatlt.modelo.repositorio.RepositorioAlimento;
import mx.spechtech.ieatlt.modelo.repositorio.RepositorioCliente;
import mx.spechtech.ieatlt.modelo.repositorio.RepositorioDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControladorAuxiliar {
    @Autowired
    private RepositorioAlimento repositorioAlimento;
    @Autowired
    private RepositorioCliente repositorioCliente;
    @Autowired
    private RepositorioDireccion repositorioDireccion;

    @PostMapping(path = "/alimento")
    public @ResponseBody String crearOrden(Alimento a) {
        repositorioAlimento.save(a);
        return "Alimento guardado!";
    }

    @PostMapping(path = "/cliente")
    public @ResponseBody String crearCliente(Cliente c) {
        repositorioCliente.save(c);
        return "Cliente guardado!";
    }
    @PostMapping(path = "/direccion")
    public @ResponseBody String crearDireccion(Direccion d) {
        repositorioDireccion.save(d);
        return "Direccion guardada!";
    }
}
