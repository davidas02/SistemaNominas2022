/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author daw1
 */
public class SistemaNominas extends ComparadorSueldo {

    private List<Empleado> empleados;

    public SistemaNominas() {
        this.empleados = new ArrayList<>();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public boolean incluirEmpleado(Empleado empleado) {
        boolean incluido = false;
        if (empleado != null && !empleados.contains(empleado)) {
            incluido = empleados.add(empleado);
        }
        return incluido;
    }

    public Empleado getEmpleado(String dni) {
        for (Empleado em : empleados) {
            if (dni.equals(em.getDni())) {
                return em;
            }
        }
        return null;
    }

    public boolean eliminarEmpleado(Empleado empleado) {
        if (empleado != null) {
            return empleados.remove(empleado);
        }
        return false;
    }

    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados);
    }

    public List<Empleado> listarEmpleadosPorDNI() {
        List<Empleado> lista = new ArrayList<>(empleados);
        Collections.sort(lista);
        return lista;
    }

    public List<Empleado> listarEmpleadosPorNombre() {
        List<Empleado> salida = new ArrayList<>(empleados);

        Collections.sort(salida, new Comparator<Empleado>() {
            @Override
            public int compare(Empleado o1, Empleado o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        });
        return salida;
    }

    public List<Empleado> listarEmpleadosPorSueldo() {
        List<Empleado> lista = new ArrayList<>(empleados);
        Collections.sort(lista, new ComparadorSueldo());
        return lista;
    }

    public float getTotalSalarios() {
        float acum = 0;
        for (Empleado e : empleados) {
            acum += e.ingresos();
        }
        return acum;
    }
}
