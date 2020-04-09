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
import org.springframework.web.bind.annotation.RequestParam;
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
    public @ResponseBody String crearOrden(@RequestParam String nombre, @RequestParam double precio) {
        repositorioAlimento.save(new Alimento(nombre, precio));
        return "Alimento guardado!";
    }

    @PostMapping(path = "/cliente")
    public @ResponseBody String crearCliente(@RequestParam String nombre) {
        repositorioCliente.save(new Cliente(nombre));
        return "Cliente guardado!";
    }
    @PostMapping(path = "/direccion")
    public @ResponseBody String crearDireccion(@RequestParam String direccion) {
        Cliente c = repositorioCliente.findById(8).get();
        Direccion d = new Direccion(direccion, c);
        repositorioDireccion.save(d);
        return "Direccion guardada!";
    }
}
