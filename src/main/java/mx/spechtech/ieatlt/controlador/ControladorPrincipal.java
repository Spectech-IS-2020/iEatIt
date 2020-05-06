package mx.spechtech.ieatlt.controlador;

import mx.spechtech.ieatlt.formulario.FormRegistro;
import mx.spechtech.ieatlt.modelo.Usuario;
import mx.spechtech.ieatlt.servicio.ServicioAutenticacion;
import mx.spechtech.ieatlt.servicio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorPrincipal {
    @Autowired
    private ServicioUsuario servicioUsuario;

    @Autowired
    private ServicioAutenticacion servicioAutenticacion;

    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {
        model.addAttribute("usuario", servicioAutenticacion.usuarioActual());
        model.addAttribute("title", "iEatIt");
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if(servicioAutenticacion.usuarioActual() != null)
            return "redirect:/home";
        model.addAttribute("title", "Iniciar sesión");
        return "auth/login";
    }

    @GetMapping("/registrar")
    public String registrar(Model model) {
        if(servicioAutenticacion.usuarioActual() != null)
            return "redirect:/home";
        model.addAttribute("formRegistro", new FormRegistro());
        model.addAttribute("title", "Crear cuenta");
        return "auth/registrar";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute FormRegistro formRegistro) {
        Usuario usuario = formRegistro.buildUsuario();
        servicioUsuario.guardarCliente(usuario, formRegistro.buildDireccion());
        servicioAutenticacion.autoLogin(usuario.getEmail(), usuario.getContrasenia());
        return "redirect:/home";
    }

    @GetMapping("/cliente/index")
    public String clienteIndex() {
        return "cliente/index";
    }

    @GetMapping("/administrador/index")
    public String administradorIndex() {
        return "administrador/index";
    }

    @GetMapping("/repartidor/index")
    public String repartidorIndex() {
        return "repartidor/index";
    }
}
