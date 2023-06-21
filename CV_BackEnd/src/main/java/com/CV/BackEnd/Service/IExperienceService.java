/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CV.BackEnd.Service;


import com.CV.BackEnd.Model.Experience;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;


public interface IExperienceService {
        
    public List<Experience> getExperiences();
    
    public Experience saveExperience(Experience exp);

    public ResponseEntity<Experience> findExp(Long id);

    public ResponseEntity<Experience> updateExp(Long id, Experience ab);

    public ResponseEntity<Map<String, Boolean>> deleteExp(Long id);
}
