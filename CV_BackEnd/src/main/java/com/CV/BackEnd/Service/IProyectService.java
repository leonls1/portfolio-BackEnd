/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CV.BackEnd.Service;


import com.CV.BackEnd.Model.Proyect;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author leon
 */
public interface IProyectService {
        
    public List<Proyect> getProyects();
    
    public Proyect saveProyect(Proyect proyect);

    public ResponseEntity<Proyect> findProyect(Long id);

    public ResponseEntity<Proyect> updateProyect(Long id, Proyect proyect);

    public ResponseEntity<Map<String, Boolean>> deleteProyect(Long id);
}
