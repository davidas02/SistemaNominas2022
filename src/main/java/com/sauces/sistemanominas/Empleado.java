package com.sauces.sistemanominas;

import java.io.Serializable;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daw1
 */
public abstract class Empleado implements Comparable<Empleado>,Serializable {
    private Dni dni;
    private String nombre;
    public Empleado(){
    }
    public Empleado(Dni dni, String nombre) throws DniException {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Dni getDni() {
        return dni;
    }

    public void setDni(Dni dni) throws DniException {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return dni.toString() + "," + nombre;
    }

    @Override
    public int compareTo(Empleado empleado) {
        
        return this.dni.compareTo(empleado.dni);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.dni);
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
        if (obj instanceof Empleado) {
            final Empleado other = (Empleado) obj;
            if (Objects.equals(this.dni, other.dni)) {
                return true;
            }
        }
        return false;
    }
    public abstract float ingresos();
}
