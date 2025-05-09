/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baruk.ecma.logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author ikram
 */
@Entity
public class Alumno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_alumno;
    
    @Basic
    private String nombre;
    private int edad;
    private String telefono;
    
    @Temporal (TemporalType.DATE)
    private LocalDate fechaInscripcion;
    
    @Temporal (TemporalType.DATE)
    private LocalDate fechaPago;
    
    @ManyToOne 
    private PersonaContacto personaContacto;
    
    @ManyToMany (mappedBy = "alumnos")
    private List<Clase> clases;
    
    @ManyToMany (mappedBy = "alumnos")
    private List<Evento> eventos;
    
    @OneToMany (mappedBy = "alumnos")
    private List<AsistenciaAlumno> asistenciasAlumnos;

    public List<AsistenciaAlumno> getAsistenciasAlumnos() {
        return asistenciasAlumnos;
    }

    public void setAsistenciasAlumnos(List<AsistenciaAlumno> asistenciasAlumnos) {
        this.asistenciasAlumnos = asistenciasAlumnos;
    }

    public Alumno() {
    }

    public Alumno(Long id_alumno, String nombre, int edad, String telefono, LocalDate fechaInscripcion, LocalDate fechaPago, PersonaContacto personaContacto, List<Clase> clases, List<Evento> eventos, List<AsistenciaAlumno> asistenciasAlumnos) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaPago = fechaPago;
        this.personaContacto = personaContacto;
        this.clases = clases;
        this.eventos = eventos;
        this.asistenciasAlumnos = asistenciasAlumnos;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    
    

    public Long getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Long id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public PersonaContacto getPersonaContacto() {
        return personaContacto;
    }

    public void setPersonaContacto(PersonaContacto personaContacto) {
        this.personaContacto = personaContacto;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    
    
}
