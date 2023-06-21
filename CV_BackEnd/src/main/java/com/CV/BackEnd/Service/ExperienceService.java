/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CV.BackEnd.Service;

import com.CV.BackEnd.Exception.ResourceNotFoundException;
import com.CV.BackEnd.Model.Experience;
import com.CV.BackEnd.Repository.ExperienceRepository;
import jakarta.transaction.Transactional;
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

public class ExperienceService implements IExperienceService {

    @Autowired
    private ExperienceRepository repo;
    
    @Override
    public List<Experience> getExperiences() {
        List<Experience> list = repo.findAll();
          return list;
    }

    @Override
    public Experience saveExperience(Experience exp) {
        return repo.save(exp);}

    @Override
    public ResponseEntity<Experience> findExp(Long id) {
        Experience exp = repo.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("no existe la Experience con el id: " + id));
        return ResponseEntity.ok(exp);    
    }

    @Override
        //fechaInicio, fechaFin, nombreEmpresa, rol, descripcion
    public ResponseEntity<Experience> updateExp(Long id, Experience xp) {
       Experience exp = repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("no existe la Experience con el id: " + id));
        
        exp.setDescripcion(xp.getDescripcion());
        exp.setFechaFin(xp.getFechaFin());
        exp.setFechaInicio(xp.getFechaInicio());
        exp.setNombreEmpresa(xp.getNombreEmpresa());
        exp.setRol(xp.getRol());
        
        Experience xpUpdated = repo.save(exp);
        return ResponseEntity.ok(xpUpdated);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteExp(Long id) {
         Experience exp = repo.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el experience con el ID : " + id));
		
		repo.delete(exp);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta); 
    }
    
}
