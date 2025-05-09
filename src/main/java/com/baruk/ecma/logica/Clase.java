/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baruk.ecma.logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
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
public class Clase {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id_clase;
    
    
    private String dia;
    
    @Temporal (TemporalType.TIME)
    private LocalTime hora_inicio;
    
    @Temporal (TemporalType.TIME)
    private LocalTime hora_fin;
    
    private int cupoMax;
    private String clasificacion;
    
    @ManyToOne
    private Profesor profesor;
    
    @ManyToOne
    private Disciplina disciplina;
    
    @ManyToMany (mappedBy = "clases")
    private List<Alumno> alumnos;
    
    @OneToMany (mappedBy = "clase")
    private List<AsistenciaAlumno> asistenciaAlumno;
    
    @OneToMany (mappedBy= "clase")
    private List<AsistenciaProfesor> asistenciaProfesor;


    public Clase() {
    }

    public Clase(Long id_clase, String dia, LocalTime hora_inicio, LocalTime hora_fin, int cupoMax, String clasificacion, Profesor profesor, Disciplina disciplina, List<Alumno> alumnos, List<AsistenciaAlumno> asistenciaAlumno, List<AsistenciaProfesor> asistenciaProfesor) {
        this.id_clase = id_clase;
        this.dia = dia;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.cupoMax = cupoMax;
        this.clasificacion = clasificacion;
        this.profesor = profesor;
        this.disciplina = disciplina;
        this.alumnos = alumnos;
        this.asistenciaAlumno = asistenciaAlumno;
        this.asistenciaProfesor = asistenciaProfesor;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<AsistenciaAlumno> getAsistenciaAlumno() {
        return asistenciaAlumno;
    }

    public void setAsistenciaAlumno(List<AsistenciaAlumno> asistenciaAlumno) {
        this.asistenciaAlumno = asistenciaAlumno;
    }

    public List<AsistenciaProfesor> getAsistenciaProfesor() {
        return asistenciaProfesor;
    }

    public void setAsistenciaProfesor(List<AsistenciaProfesor> asistenciaProfesor) {
        this.asistenciaProfesor = asistenciaProfesor;
    }

    

    public Long getId_clase() {
        return id_clase;
    }

    public void setId_clase(Long id_clase) {
        this.id_clase = id_clase;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getCupoMax() {
        return cupoMax;
    }

    public void setCupoMax(int cupoMax) {
        this.cupoMax = cupoMax;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    
    
}
