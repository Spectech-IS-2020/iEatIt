package mx.spechtech.ieatlt.controlador;

import mx.spechtech.ieatlt.modelo.*;
import mx.spechtech.ieatlt.repositorio.RepositorioAlimento;
import mx.spechtech.ieatlt.repositorio.RepositorioDireccion;
import mx.spechtech.ieatlt.repositorio.RepositorioOrden;
import mx.spechtech.ieatlt.servicio.ServicioAutenticacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/orden")
public class ControladorOrden {
    @Autowired
    private RepositorioOrden repositorioOrden;
    @Autowired
    RepositorioAlimento repositorioAlimento;
    @Autowired
    ServicioAutenticacion servicioAutenticacion;

    /**
     * Devuelve la vista con los alimentos disponibles para añadirlos a una orden nueva
     *
     * @param model
     * @return
     */
    @GetMapping(path = "crear")
    public String crearOrden(Model model) {
        Iterable<Alimento> alimentos = repositorioAlimento.findAll();
        model.addAttribute("alimentos", alimentos);
        return "orden/crear";
    }

    /**
     * Almacena la orden con los alimentos con id en idAlimentos
     *
     * @param idAlimentos
     * @return
     */
    @PostMapping(path = "/crear")
    public String crearOrden(@RequestParam ArrayList<String> idAlimentos) {
        Usuario usuario = servicioAutenticacion.usuarioActual();
        Direccion direccion = usuario.getDireccion();
        List<Alimento> listaAlimentos = new LinkedList<>();
        for (String idAlimento : idAlimentos) {
            Optional<Alimento> alimento = repositorioAlimento.findById(Integer.parseInt(idAlimento));
            alimento.ifPresent(listaAlimentos::add);
        }
        Orden orden = new Orden(listaAlimentos, usuario, direccion);
        repositorioOrden.save(orden);

        return "redirect:/orden/detalles/" + orden.getIdOrden();
    }

    /**
     * Regresa la vista mostrando la orden con id idOrden
     *
     * @param idOrden Id de la orden que se muestra en la vista
     * @param model   Modelo para añadir los datos
     * @return
     */
    @GetMapping(path = "/detalles/{idOrden}")
    public String detallesOrden(@PathVariable String idOrden, Model model) {
        Optional<Orden> orden = repositorioOrden.findById(idOrden);
        model.addAttribute("orden", orden.get());
        return "orden/detalles";
    }

    @GetMapping(path = "/mostrar")
    public String mostrarOrdenes(@RequestParam Estado estado, Model model) {
        model.addAttribute("ordenes", repositorioOrden.findByEstado(estado));
        model.addAttribute("usuario", servicioAutenticacion.usuarioActual());
        return "/orden/listado";
    }

    @PostMapping(path = "/estado")
    public String cambiarEstado(@RequestParam Estado estado, @RequestParam String idOrden) {
        Orden orden = (repositorioOrden.findById(idOrden)).get();
        orden.setEstado(estado);
        repositorioOrden.save(orden);
        return "redirect:/orden/mostrar?estado=PENDIENTE";
    }
}
