/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baruk.ecma.logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author ikram
 */
@Embeddable
public class AsistenciaProfesorId implements Serializable{
    
    private Long claseId;
    private LocalDate fecha;
    private LocalTime horaInicio;

    public AsistenciaProfesorId() {
    }

    public AsistenciaProfesorId(Long claseId, LocalDate fecha, LocalTime horaInicio) {
        this.claseId = claseId;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.claseId);
        hash = 23 * hash + Objects.hashCode(this.fecha);
        hash = 23 * hash + Objects.hashCode(this.horaInicio);
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
        final AsistenciaProfesorId other = (AsistenciaProfesorId) obj;
        if (!Objects.equals(this.claseId, other.claseId)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return Objects.equals(this.horaInicio, other.horaInicio);
    }
    
    
}
