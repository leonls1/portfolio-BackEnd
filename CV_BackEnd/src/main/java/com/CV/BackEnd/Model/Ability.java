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
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name = "habilidades")
public class Ability {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="porcentaje")
    private int porcentaje;
    
    @Column(name="tipo")
    private boolean tipo; //0 para dura y 1 para blanda

    public Ability() {
    }

    public Ability(Long id, String nombre, int porcentaje, boolean tipo) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.tipo = tipo;
    }
    
}
