/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CV.BackEnd.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author leon
 */
@Getter
@Setter
@Entity
@Table(name="Educacion")
public class Education {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="dateBegining")
    private String dateBegining;
    
    @Column(name="dateEnd")
    private String dateEnd;
    
    @Column(name="place")
    private String place;
    
    @Column(name="tittle")
    private String tittle;
    
    @Column(name="description")
    private String description;

    public Education(String dateBegining, String dateEnd, String place, String tittle, String description) {
        this.dateBegining = dateBegining;
        this.dateEnd = dateEnd;
        this.place = place;
        this.tittle = tittle;
        this.description = description;
    }
    public Education() {
    }
}
