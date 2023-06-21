/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CV.BackEnd.Controller;

import com.CV.BackEnd.Model.Experience;
import com.CV.BackEnd.Service.IExperienceService;
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
@RequestMapping("CV/V1/exp")
@CrossOrigin("http://localhost:4200/")
public class ExperienceController {
    
    @Autowired
    IExperienceService service;
    
    @GetMapping("/experiencias")
    public List<Experience> list(){
       return service.getExperiences();
    }
    

    @PostMapping("/crear")
    public Experience saveExp(@RequestBody Experience exp){
        return service.saveExperience(exp);
    };
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Experience> findHab(@PathVariable Long id){
        return service.findExp(id);
    };
    

    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Experience> updateHab(@PathVariable Long id,
                                               @RequestBody Experience exp){
        return service.updateExp(id, exp);
        
    };
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteHab(@PathVariable Long id){
        return service.deleteExp(id);
    };
    
}
