package com.chat.crudSpring.Controller;


import com.chat.crudSpring.Service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@Slf4j
public class EditarPersonaController {

    @Autowired
    private PersonaService personaService;

    public String inicio(Model model) {

        var personas = personaService.listarPersona();
        model.addAttribute("personas", personas);
        return "index";
    }


}
