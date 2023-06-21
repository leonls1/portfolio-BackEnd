/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CV.BackEnd.Controller;

import com.CV.BackEnd.Model.Education;
import com.CV.BackEnd.Service.IEducationService;
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

/**
 *
 * @author leon
 */
@RestController
@RequestMapping("CV/V1/edu")
@CrossOrigin("http://localhost:4200/")
public class EducationController {

    @Autowired
    private IEducationService service;
    
    @GetMapping("/educacion")
    public List<Education> getEducations(){
        return service.getEducations();
    };
    
    @PostMapping("/crear")
    public Education saveHability(@RequestBody Education edu){
        return service.saveEducation(edu);
    };
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Education> findHab(@PathVariable Long id){
        return service.findEdu(id);
    };
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Education> updateHab(@PathVariable Long id,
                                               @RequestBody Education edu){
        return service.updateEdu(id, edu);
    };
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteHab(@PathVariable Long id){
        return service.deleteEdu(id);
    }; 
}
