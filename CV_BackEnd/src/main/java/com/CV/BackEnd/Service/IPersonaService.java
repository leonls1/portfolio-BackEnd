/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CV.BackEnd.Service;


import com.CV.BackEnd.Model.Persona;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author leon
 */
public interface IPersonaService {
   public List<Persona> getPersonas();
    
    public Persona savePersona(Persona per);

    public ResponseEntity<Persona> findPersona(Long id);

    public ResponseEntity<Persona> updatePersona(Long id, Persona per);

    public ResponseEntity<Map<String, Boolean>> deletePersona(Long id); 
}
