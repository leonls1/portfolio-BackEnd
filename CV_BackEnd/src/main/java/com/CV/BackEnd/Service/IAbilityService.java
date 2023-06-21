/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CV.BackEnd.Service;

import com.CV.BackEnd.Model.Ability;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;


public interface IAbilityService {
    
    public List<Ability> getHabilities();
    
    public Ability saveHability(Ability ability);
    
    public ResponseEntity<Ability> findHab(Long id);
    
    public ResponseEntity<Ability> updateHab(Long id, Ability ab);
    
    public ResponseEntity<Map<String, Boolean>> deleteHab(Long id);
}
