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

@Getter@Setter
@Entity
@Table(name = "experiencia")
public class Experience {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="fechaInicio")
    private String fechaInicio;

    @Column(name="fechaFin")
    private String fechaFin;
    
    @Column(name="nombreEmpresa")
    private String nombreEmpresa;
    
    @Column(name="rol")
    private String rol;
    
    @Column(name="descripcion")
    private String descripcion;

    public Experience() {
    }

    public Experience(Long id, String fechaInicio, String fechaFin, String nombreEmpresa, String rol, String descripcion) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombreEmpresa = nombreEmpresa;
        this.rol = rol;
        this.descripcion = descripcion;
    }
    
    
    
}
