package com.chat.crudSpring.Service;

import com.chat.crudSpring.Model.Persona;
import com.chat.crudSpring.ModelDAO.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDAO personaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersona() {
        return (List<Persona>) personaDAO.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDAO.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDAO.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(long id) {
        return personaDAO.findById(id).orElse(null);
    }


    @Override
    @Transactional
    public void modificarPersona(Long id, Persona persona) {
        Optional<Persona> personaExistenteOptional = personaDAO.findById(id);

        if (personaExistenteOptional.isPresent()) {
            Persona personaExistente = personaExistenteOptional.get();
            personaExistente.setNombre(persona.getNombre());
            personaExistente.setApellido(persona.getApellido());
            personaExistente.setEdad(persona.getEdad());
            personaExistente.setCarrera(persona.getCarrera());
            personaDAO.save(personaExistente);
        }
        // Puedes manejar una lógica adicional si la persona no existe
    }

}
