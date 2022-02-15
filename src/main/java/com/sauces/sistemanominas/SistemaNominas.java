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
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author daw1
 */
public class SistemaNominas extends ComparadorSueldo {

    private Map<String,Empleado> empleados;

    public SistemaNominas() {
        this.empleados = new TreeMap<>();
    }

    public Map<String,Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Map<String,Empleado> empleados) {
        this.empleados = empleados;
    }

    public boolean incluirEmpleado(Empleado empleado) {
        boolean incluido=false;
            if(empleados.putIfAbsent(empleado.getDni(), empleado)==null){
            incluido=true;
            }
        return incluido;
    }

    public Empleado getEmpleado(String dni) {
        if(empleados.containsKey(dni)){
            return empleados.get(dni);
        }
        return null;
    }

    public boolean eliminarEmpleado(Empleado empleado) {
        if (empleado != null) {
            return empleados.remove(empleado.getDni(),empleado);
        }
        return false;
    }

    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados.values());
    }

    public List<Empleado> listarEmpleadosPorDNI() {
        List<Empleado> lista = new ArrayList<>(empleados.values());
        Collections.sort(lista);
        return lista;
    }

    public List<Empleado> listarEmpleadosPorNombre() {
        List<Empleado> salida = new ArrayList<>(empleados.values());

        Collections.sort(salida, new Comparator<Empleado>() {
            @Override
            public int compare(Empleado o1, Empleado o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        });
        return salida;
    }

    public List<Empleado> listarEmpleadosPorSueldo() {
        List<Empleado> lista = new ArrayList<>(empleados.values());
        Collections.sort(lista, new ComparadorSueldo());
        return lista;
    }

    public float getTotalSalarios() {
        float acum = 0;
        for (Empleado e : empleados.values()) {
            acum += e.ingresos();
        }
        return acum;
    }
}
