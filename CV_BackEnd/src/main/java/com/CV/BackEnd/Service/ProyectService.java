/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CV.BackEnd.Service;

import com.CV.BackEnd.Exception.ResourceNotFoundException;
import com.CV.BackEnd.Model.Proyect;
import com.CV.BackEnd.Repository.ProyectRepository;
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
public class ProyectService implements IProyectService {

    @Autowired
    private ProyectRepository repo;

    @Override
    public List<Proyect> getProyects() {
        List<Proyect> list = repo.findAll();
        return list;
    }

    @Override
    public Proyect saveProyect(Proyect proyect) {
        return repo.save(proyect);
    }

    @Override
    public ResponseEntity<Proyect> findProyect(Long id) {
       Proyect pro = repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("no existe el proyecto con el id: " + id));
        return ResponseEntity.ok(pro);
    }

    @Override
         //nombre, link, fechaCreacion, descripcion
    public ResponseEntity<Proyect> updateProyect(Long id, Proyect proyect) {
        Proyect pro = repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("no existe el proyecto con el id: " + id));
        
        pro.setNombre(proyect.getNombre());
        pro.setLink(proyect.getLink());
        pro.setDescripcion(proyect.getDescripcion());
        pro.setFechaCreacion(proyect.getFechaCreacion());        
        
        Proyect proyectUpdated = repo.save(pro);
        return ResponseEntity.ok(proyectUpdated);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteProyect(Long id) {
        Proyect pro = repo.findById(id)
				       .orElseThrow(() -> new ResourceNotFoundException("No existe el proyecto con el ID : " + id));
		
		repo.delete(pro);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta); 
    }

}
