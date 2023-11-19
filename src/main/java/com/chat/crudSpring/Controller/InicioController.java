package com.chat.crudSpring.Controller;

import com.chat.crudSpring.Model.Persona;
import com.chat.crudSpring.Service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class InicioController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model) {
        var personas = personaService.listarPersona();
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Persona persona = personaService.encontrarPersona(id);
        model.addAttribute("persona", persona);
        return "editar";
    }

    @PostMapping("guardareditar/{id}")
    public String procesarFormularioEdicion(@PathVariable Long id, @ModelAttribute Persona persona) {
        personaService.modificarPersona(id, persona);
        return "redirect:/"; // Redirige a la lista después de la edición (puedes cambiar la URL según tus necesidades)
    }

    @PostMapping("eliminar/{id}")
    public String procesarEliminar(@PathVariable Long id) {
        Persona persona = personaService.encontrarPersona(id);
        personaService.eliminar(persona);
        return "redirect:/"; // Redirige a la lista después de la eliminación
    }


    @GetMapping("nuevo")
    public String mostrarFormularioNuevaPersona(Model model) {
        model.addAttribute("persona", new Persona());
        return "nuevo";
    }

    @PostMapping("nuevo")
    public String procesarFormularioNuevaPersona(@ModelAttribute Persona persona) {
        personaService.guardar(persona);
        return "redirect:/"; // Redirige a la lista después de agregar una nueva persona
    }

}

