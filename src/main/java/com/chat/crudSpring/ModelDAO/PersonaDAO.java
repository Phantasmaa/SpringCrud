package com.chat.crudSpring.ModelDAO;

import com.chat.crudSpring.Model.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDAO extends CrudRepository<Persona, Long> {
}
