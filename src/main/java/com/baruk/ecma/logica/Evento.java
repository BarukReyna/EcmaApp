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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ikram
 */
@Entity
public class Evento {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id_evento;
    
    private String nombre;
    
    
    private LocalDate fecha;
    private String tipo;
    
    @ManyToMany (mappedBy= "eventos")
    private List<Alumno> alumnos;

    public Evento() {
    }

    public Evento(Long id_evento, String nombre, LocalDate fecha, String tipo, List<Alumno> alumnos) {
        this.id_evento = id_evento;
        this.nombre = nombre;
        this.fecha = fecha;
        this.tipo = tipo;
        this.alumnos = alumnos;
    }

    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    
    
    
}
