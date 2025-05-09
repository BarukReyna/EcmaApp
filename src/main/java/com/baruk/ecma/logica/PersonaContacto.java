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
import javax.persistence.OneToMany;

/**
 *
 * @author ikram
 */
@Entity
public class PersonaContacto {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id_contacto;
    private String nombre;
    private String telefono;
    private String correo;
    private String parentesco;
    
    @OneToMany (mappedBy = "personaContacto")
    private List<Alumno> alumnos;

    public PersonaContacto() {
    }

    public PersonaContacto(Long id_contacto, String nombre, String telefono, String correo, String parentesco, List<Alumno> alumnos) {
        this.id_contacto = id_contacto;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.parentesco = parentesco;
        this.alumnos = alumnos;
    }

    public Long getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(Long id_contacto) {
        this.id_contacto = id_contacto;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    
    
}
