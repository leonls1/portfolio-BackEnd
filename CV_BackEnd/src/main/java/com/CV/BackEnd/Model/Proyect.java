/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CV.BackEnd.Model;

/**
 *
 * @author leon
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name = "proyectos")
public class Proyect {
        @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre")
    private String nombre;
    
    @Column(name="link")
    private String link;
    
    @Column(name="fechaCreacion")
    private String FechaCreacion;
    
    @Column(name="descripcion")
    private String descripcion;

    public Proyect() {
    }

    public Proyect(Long id, String nombre, String link, String FechaCreacion, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.link = link;
        this.FechaCreacion = FechaCreacion;
        this.descripcion = descripcion;
    }
    
    
}
