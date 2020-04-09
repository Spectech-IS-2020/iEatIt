package mx.spechtech.ieatlt.controlador;

import mx.spechtech.ieatlt.modelo.Orden;
import mx.spechtech.ieatlt.modelo.repositorio.RepositorioOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/orden")
public class ControladorOrden {
    @Autowired
    private RepositorioOrden repositorioOrden;

    @PostMapping(path = "/crear")
    public @ResponseBody String crearOrden(Orden orden) {
        repositorioOrden.save(orden);
        return "Orden creada!";
    }
}
