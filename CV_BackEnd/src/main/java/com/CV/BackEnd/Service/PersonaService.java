/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CV.BackEnd.Service;

import com.CV.BackEnd.Exception.ResourceNotFoundException;
import com.CV.BackEnd.Model.Persona;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.CV.BackEnd.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author leon
 */
@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository repo;


    @Override
    public List<Persona> getPersonas() {
               List<Persona> list= repo.findAll();
        return list;}

    @Override
    public Persona savePersona(Persona per) {
                return repo.save(per);
    }

    @Override
    public ResponseEntity<Persona> findPersona(Long id) {
                Persona per = repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("no existe la persona con el id: " + id));
        return ResponseEntity.ok(per);
    }

    @Override //nombre, apellido, descripcion, titulo
    public ResponseEntity<Persona> updatePersona(Long id, Persona per) {
        Persona pers = repo.findById(id)
                                        .orElseThrow(()-> new ResourceNotFoundException("no existe la persona con el id: " + id));
        pers.setNombre(per.getNombre());
        pers.setApellido(per.getApellido());
        pers.setDescripcion(per.getDescripcion());
        pers.setTitulo(per.getTitulo());                
        
        Persona perUpdated = repo.save(pers);
        return ResponseEntity.ok(perUpdated);}

    @Override
    public ResponseEntity<Map<String, Boolean>> deletePersona(Long id) {
        Persona per = repo.findById(id)
				    .orElseThrow(() -> new ResourceNotFoundException("No existe la persona con el ID : " + id));
		
		repo.delete(per);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta); 
    }
    
}
