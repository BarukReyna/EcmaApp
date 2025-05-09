/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baruk.ecma.logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author ikram
 */
@Embeddable
public class AsistenciaAlumnoId implements Serializable{
    
    private Long alumnoId;
    private Long claseId;
    private LocalDate fecha;

    public AsistenciaAlumnoId() {
    }

    public AsistenciaAlumnoId(Long alumnoId, Long claseId, LocalDate fecha) {
        this.alumnoId = alumnoId;
        this.claseId = claseId;
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.alumnoId);
        hash = 83 * hash + Objects.hashCode(this.claseId);
        hash = 83 * hash + Objects.hashCode(this.fecha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AsistenciaAlumnoId other = (AsistenciaAlumnoId) obj;
        if (!Objects.equals(this.alumnoId, other.alumnoId)) {
            return false;
        }
        if (!Objects.equals(this.claseId, other.claseId)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }
    
    
    
}
