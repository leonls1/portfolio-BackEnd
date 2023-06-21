/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CV.BackEnd.Service;

import com.CV.BackEnd.Exception.ResourceNotFoundException;
import com.CV.BackEnd.Model.Education;
import com.CV.BackEnd.Repository.EducationRepository;
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
public class EducationService implements IEducationService {

    @Autowired
    private EducationRepository repo;
    
    @Override
    public List<Education> getEducations() {
        List<Education> list = repo.findAll();
          return list;}

    @Override
    public Education saveEducation(Education edu) {
        return repo.save(edu);}

    @Override
    public ResponseEntity<Education> findEdu(Long id) {
        Education edu = repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("no existe la educacion con el id: " + id));
        return ResponseEntity.ok(edu);
    }

    @Override
    //fechaInicio, fechaFin, nombreLugar, tituloCarrera, descripcion
    public ResponseEntity<Education> updateEdu(Long id, Education education ) {
        Education edu = repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("no existe la educacion con el id: " + id));
        
        edu.setDateBegining(education.getDateBegining());
        edu.setDateEnd(education.getDateEnd());
        edu.setDescription(education.getDescription());
        edu.setPlace(education.getPlace());
        edu.setTittle(education.getTittle());
        
        
        Education eduUpdated = repo.save(edu);
        return ResponseEntity.ok(eduUpdated);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEdu(Long id) {
        Education edu = repo.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe la educacion con el ID : " + id));
		
		repo.delete(edu);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
    
}
