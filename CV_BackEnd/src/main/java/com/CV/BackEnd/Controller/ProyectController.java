/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CV.BackEnd.Controller;

import com.CV.BackEnd.Model.Proyect;
import com.CV.BackEnd.Service.IProyectService;
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
@RequestMapping("CV/V1/pro")
@CrossOrigin("http://localhost:4200/")
public class ProyectController {
    
    @Autowired
    public IProyectService service;
    
    @GetMapping("/proyects")
    public List<Proyect> getProyects(){
        return service.getProyects();
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Proyect> findProyect(@PathVariable Long id){
        return service.findProyect(id);
    }
    
    @PostMapping("/save")
    public Proyect saveProyect(@RequestBody Proyect proyect){
        return service.saveProyect(proyect);
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<Proyect> editProyect(@RequestBody Proyect pro,
                                               @PathVariable Long id){
        return service.updateProyect(id, pro);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Map<String, Boolean>> deleteProyect(@PathVariable Long id){
        return service.deleteProyect(id);
    }
    
    
}
