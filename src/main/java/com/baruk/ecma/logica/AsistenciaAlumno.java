/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baruk.ecma.logica;

import java.time.LocalTime;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author ikram
 */
@Entity
public class AsistenciaAlumno {
    
    @EmbeddedId
    private AsistenciaAlumnoId id;
    
    @ManyToOne
    @MapsId("alumnoId")
    private Alumno alumno;
    
    @ManyToOne
    @MapsId("claseId")
    private Clase clase;
    
    private boolean presente;

    public AsistenciaAlumno() {
    }

    public AsistenciaAlumno(AsistenciaAlumnoId id, Alumno alumno, Clase clase, boolean presente) {
        this.id = id;
        this.alumno = alumno;
        this.clase = clase;
        this.presente = presente;
    }

    public AsistenciaAlumnoId getId() {
        return id;
    }

    public void setId(AsistenciaAlumnoId id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }
    
    
}
