package com.example.BlackNoise.Controller;

import com.example.blacknoise.model.Usuario;
import com.example.blacknoise.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public String obtenerUsuarioPorId(@PathVariable String id, Model model) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "bienvenida"; // Devuelve la vista bienvenida.html con el nombre del usuario
        } else {
            return "error"; // Devuelve una vista de error si el usuario no se encuentra
        }
    }
}