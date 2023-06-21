/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CV.BackEnd.Service;

import com.CV.BackEnd.Exception.ResourceNotFoundException;
import com.CV.BackEnd.Model.Ability;
import com.CV.BackEnd.Repository.AbilityRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author leon
 */
@Service
public class AbilityService implements IAbilityService {

    @Autowired
    private AbilityRepository repo;
    
    @Override
    public List<Ability> getHabilities() {
          List<Ability> list = repo.findAll();
          return list;
       }

    @Override
    public Ability saveHability(Ability ability) {
        return repo.save(ability);
    }

    @Override
    public ResponseEntity<Ability> findHab(Long id) {
        Ability abi = repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("no existe la habilidad con el id: " + id));
        return ResponseEntity.ok(abi);
    
    }

    @Override
    public ResponseEntity<Ability> updateHab(Long id, Ability ab) {
        Ability abi = repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("no existe la habilidad con el id: " + id));
        
        abi.setNombre(ab.getNombre());
        abi.setPorcentaje(ab.getPorcentaje());
        abi.setTipo(ab.isTipo());
        
        Ability abiUpdated = repo.save(abi);
        return ResponseEntity.ok(abiUpdated);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteHab(Long id) {
        Ability abi = repo.findById(id)
				       .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID : " + id));
		
		repo.delete(abi);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta); 
    }
    
}
