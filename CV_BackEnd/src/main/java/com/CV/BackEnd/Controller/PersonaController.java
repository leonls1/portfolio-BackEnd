/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CV.BackEnd.Controller;

import com.CV.BackEnd.Model.Persona;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.CV.BackEnd.Service.IPersonaService;

@RestController
@RequestMapping("CV/V1")
@CrossOrigin("http://localhost:4200/")
public class PersonaController {
    @Autowired
    private IPersonaService service;

    
    @GetMapping("/personas")
    public List<Persona> getPersonas(){
        return service.getPersonas();
    };
    
    @PostMapping("/personas/crear")
    public Persona savePersona(@RequestBody Persona per){
        return service.savePersona(per);
    };
    
    @GetMapping("/personas/buscar/{id}")
    public ResponseEntity<Persona> findPersona(@PathVariable Long id){
        return service.findPersona(id);
    };  
    
    @PutMapping("/personas/actualizar{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id,
                                               @RequestBody Persona per){
        return service.updatePersona(id, per);
    };
    
    @DeleteMapping("/personas/borrar/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePersona(@PathVariable Long id){
        return service.deletePersona(id);
    };
}
