package mx.spechtech.ieatlt.controlador;

import mx.spechtech.ieatlt.modelo.Categoria;
import mx.spechtech.ieatlt.modelo.repositorio.RepositorioCategoria;
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

@Controller
@RequestMapping(path = "/categorias")
public class ControladorCategoria {
    @Autowired
    private RepositorioCategoria repositorioCategoria;

    @GetMapping(path = "/crear")
    public String crearCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        
        return "categorias/crear";
    }

    @PostMapping(path = "/crear")
    public ModelAndView crearCategoria(@ModelAttribute Categoria categoria) {
        repositorioCategoria.save(categoria);

        return new ModelAndView("redirect:/categorias/listar");
    }

    @GetMapping(path="/listar")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", repositorioCategoria.findAll());

        return "categorias/listar";
    }

    @GetMapping(path="/actualizar/{id}")
    public String listarCategorias(@PathVariable("id") int id, Model model) {
        model.addAttribute("categoria", repositorioCategoria.findById(id).get());

        return "categorias/actualizar";
    }

    @PostMapping(path="/actualizar")
    public ModelAndView actualizarCategoria(
        @RequestParam int id,
        @ModelAttribute Categoria actualizacion) {
        Categoria categoria = repositorioCategoria.findById(id).get();
        categoria.setNombre(actualizacion.getNombre());
        categoria.setDescripcion(actualizacion.getDescripcion());
        repositorioCategoria.save(categoria);

        return new ModelAndView("redirect:/categorias/listar");
    }

    @PostMapping(path="/eliminar")
    public ModelAndView eliminarCategoria(@RequestParam int id) {
        repositorioCategoria.deleteById(id);

        return new ModelAndView("redirect:/categorias/listar");
    }
}