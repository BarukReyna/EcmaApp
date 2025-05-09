/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baruk.ecma.logica;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author ikram
 */
@Entity
public class AsistenciaProfesor {
    
    @EmbeddedId
    private AsistenciaProfesorId id;
    
    @ManyToOne
    @MapsId("claseId")
    private Clase clase;
    
    private boolean presente;

    public AsistenciaProfesor() {
    }

    public AsistenciaProfesor(AsistenciaProfesorId id, Clase clase, boolean presente) {
        this.id = id;
        this.clase = clase;
        this.presente = presente;
    }

    public AsistenciaProfesorId getId() {
        return id;
    }

    public void setId(AsistenciaProfesorId id) {
        this.id = id;
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
