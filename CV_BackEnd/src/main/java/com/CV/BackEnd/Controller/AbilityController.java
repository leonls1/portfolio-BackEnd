/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CV.BackEnd.Controller;

import com.CV.BackEnd.Model.Ability;
import com.CV.BackEnd.Service.IAbilityService;
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


@RestController
@RequestMapping("CV/V1")
@CrossOrigin("http://localhost:4200/")
public class AbilityController {
    
    @Autowired
    private IAbilityService service;
    
    @GetMapping("/habilidades")
    public List<Ability> getHabilities(){
        return service.getHabilities();

    };
    
    @PostMapping("/habilidades/crear")
    public Ability saveHability(@RequestBody Ability ability){
        return service.saveHability(ability);
    };
    
    @GetMapping("/habilidades/buscar/{id}")
    public ResponseEntity<Ability> findHab(@PathVariable Long id){
        return service.findHab(id);
    };
    
    @PutMapping("/habilidades/actualizar/{id}")
    public ResponseEntity<Ability> updateHab(@PathVariable Long id,
                                             @RequestBody Ability ab){
        return service.updateHab(id, ab);
    };
    
    @DeleteMapping("/habilidades/borrar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteHab(@PathVariable Long id){
        return service.deleteHab(id);
    };
    
    
}
