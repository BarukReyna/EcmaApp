/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baruk.ecma.logica;

import java.time.LocalDate;
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
public class Profesor {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id_profesor;
    private String nombre;
    private String telefono;
    private int cantHoras;
    private LocalDate fechaPago;
    
    @OneToMany (mappedBy = "profesor")
    private List<Clase> clases;
    
    @ManyToMany (mappedBy = "profesor")
    private List<Disciplina> disciplinas;

    public Profesor() {
    }

    public Profesor(Long id_profesor, String nombre, String telefono, int cantHoras, LocalDate fechaPago, List<Clase> clases, List<Disciplina> disciplinas) {
        this.id_profesor = id_profesor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.cantHoras = cantHoras;
        this.fechaPago = fechaPago;
        this.clases = clases;
        this.disciplinas = disciplinas;
    }

    public Long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Long id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    
}
