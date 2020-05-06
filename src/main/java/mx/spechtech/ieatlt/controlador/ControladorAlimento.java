package mx.spechtech.ieatlt.controlador;

import mx.spechtech.ieatlt.modelo.Alimento;
import mx.spechtech.ieatlt.repositorio.RepositorioAlimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import mx.spechtech.ieatlt.servicio.ServicioAutenticacion;

@Controller
@RequestMapping(path = "/alimentos")
public class ControladorAlimento {
    @Autowired
    private RepositorioAlimento repositorioAlimento;

    @Autowired
    private ServicioAutenticacion servicioAutenticacion;

    @GetMapping(path = "/crear")
    public String crearAlimento(Model model) {
        model.addAttribute("alimento", new Alimento());
        model.addAttribute("title", "Crear alimento");
        model.addAttribute("usuario", servicioAutenticacion.usuarioActual());
        return "alimentos/crear";
    }

    @PostMapping(path = "/crear")
    public ModelAndView crearAlimento(@ModelAttribute Alimento alimento) {
        repositorioAlimento.save(alimento);

        return new ModelAndView("redirect:/alimentos/listar");
    }

    @GetMapping(path="/listar")
    public String listarAlimentos(Model model) {
        model.addAttribute("alimentos", repositorioAlimento.findAll());
        model.addAttribute("usuario", servicioAutenticacion.usuarioActual());
        model.addAttribute("title", "Alimentos");
        return "alimentos/listar";
    }

    @GetMapping(path="/actualizar/{id}")
    public String listarAlimentos(@PathVariable("id") int id, Model model) {
        model.addAttribute("alimento", repositorioAlimento.findById(id).get());
        model.addAttribute("title", "Actualizar alimento");
        model.addAttribute("usuario", servicioAutenticacion.usuarioActual());
        return "alimentos/actualizar";
    }

    @PostMapping(path="/actualizar")
    public ModelAndView actualizarAlimento(
        @RequestParam int id,
        @ModelAttribute Alimento actualizacion) {
        Alimento alimento = repositorioAlimento.findById(id).get();
        alimento.setNombre(actualizacion.getNombre());
        alimento.setPrecio(actualizacion.getPrecio());
        alimento.setDescripcion(actualizacion.getDescripcion());
        repositorioAlimento.save(alimento);

        return new ModelAndView("redirect:/alimentos/listar");
    }

    @PostMapping(path="/eliminar")
    public ModelAndView eliminarAlimento(@RequestParam int id) {
        repositorioAlimento.deleteById(id);

        return new ModelAndView("redirect:/alimentos/listar");
    }
}
