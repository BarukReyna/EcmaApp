/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baruk.ecma.logica;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author ikram
 */
@Entity
public class Disciplina {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id_disciplina;
    
    private String nombre;
    private String area;
    
    @OneToMany (mappedBy = "disciplina")
    private List<Clase> clases;
    
    @ManyToMany (mappedBy = "disciplina")
    private List<Profesor> profesores;

    public Disciplina() {
    }

    public Disciplina(Long id_disciplina, String nombre, String area, List<Clase> clases, List<Profesor> profesores) {
        this.id_disciplina = id_disciplina;
        this.nombre = nombre;
        this.area = area;
        this.clases = clases;
        this.profesores = profesores;
    }

    public Long getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(Long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }
    
    
}
