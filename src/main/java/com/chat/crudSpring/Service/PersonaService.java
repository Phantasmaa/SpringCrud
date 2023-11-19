package com.chat.crudSpring.Service;

import com.chat.crudSpring.Model.Persona;

import java.util.List;

public interface PersonaService {

    public List<Persona> listarPersona();

    public void guardar(Persona persona);

    public void eliminar(Persona persona);

    public Persona encontrarPersona(long id);

    void modificarPersona(Long id, Persona persona);
}
