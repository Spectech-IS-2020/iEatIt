package mx.ieatlt.authmvc.controlador;

import mx.ieatlt.authmvc.modelo.Direccion;
import mx.ieatlt.authmvc.modelo.Usuario;
import mx.ieatlt.authmvc.servicio.ServicioAutenticacion;
import mx.ieatlt.authmvc.servicio.ServicioUsuario;
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
    public String home() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/login")
    public String login() {
        if(servicioAutenticacion.usuarioActual() != null)
            return "redirect:/home";
        return "auth/login";
    }

    @GetMapping("/registrar")
    public String registrar(Model model) {
        if(servicioAutenticacion.usuarioActual() != null)
            return "redirect:/home";
        model.addAttribute("formCliente", new Usuario());
        model.addAttribute("formDireccion", new Direccion());
        return "auth/registrar";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Usuario formCliente, @ModelAttribute Direccion formDireccion) {
        servicioUsuario.guardarCliente(formCliente, formDireccion);
        servicioAutenticacion.autoLogin(formCliente.getEmail(), formCliente.getContrasenia());
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
