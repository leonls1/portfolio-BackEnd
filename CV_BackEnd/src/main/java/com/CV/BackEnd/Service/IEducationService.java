/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CV.BackEnd.Service;

import com.CV.BackEnd.Model.Education;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author leon
 */
public interface IEducationService {
    public List<Education> getEducations();
    
    public Education saveEducation(Education ability);

    public ResponseEntity<Education> findEdu(Long id);

    public ResponseEntity<Education> updateEdu(Long id, Education ab);

    public ResponseEntity<Map<String, Boolean>> deleteEdu(Long id);
}
