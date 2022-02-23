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

    private Map<Dni,Empleado> empleados;

    /**
     *  Constructor de la clase SistemaNominas
     */
    public SistemaNominas() {
        this.empleados = new TreeMap<>();
    }

    /**
     *  Metodo que devuelve la lista de empleados
     * @return Devuelve la lista de empleados
     */
    public Map<Dni,Empleado> getEmpleados() {
        return empleados;
    }

    /**
     *  Metodo que establece la lista de empleados
     * @param empleados Lista de empleados a establecer
     */
    public void setEmpleados(Map<Dni,Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     *  Metodo que incluye un empleado si no se ha incluido antes
     * @param empleado Empleado a introducir
     * @return Devuelve True si el empleado se ha añadido y false si no
     */
    public boolean incluirEmpleado(Empleado empleado) {
        boolean incluido=false;
            if(empleados.putIfAbsent(empleado.getDni(), empleado)==null){
            incluido=true;
            }
        return incluido;
    }

    /**
     *  Metodo que buesca en la lista un dni y si está devuelve el empleado
     * @param dni dni del empleado a buscar
     * @return Si el empleado se encuentra en la lista lo devuelve si no no devuelve nada
     */
    public Empleado getEmpleado(String dni) {
        if(empleados.containsKey(dni)){
            return empleados.get(dni);
        }
        return null;
    }

    /**
     *  Metodo que elimina un empleado de la lista de empleados
     * @param empleado Empleado a eliminar
     * @return devuelve True si el empleado se ha eliminado si no False
     */
    public boolean eliminarEmpleado(Empleado empleado) {
        if (empleado != null) {
            return empleados.remove(empleado.getDni(),empleado);
        }
        return false;
    }

    /**
     *  Metodo que devuelve una lista de empleados si ordenar
     * @return Devuelve una lista de empleados sin ordenar
     */
    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados.values());
    }

    /**
     *  Metodo que devuelve una lista de empleados ordenada por DNI
     * @return Devuelve una lista de empleados ordenada por DNI
     */
    public List<Empleado> listarEmpleadosPorDNI() {
        List<Empleado> lista = new ArrayList<>(empleados.values());
        Collections.sort(lista);
        return lista;
    }

    /**
     *  Metodo que devuelve una lista de empleados ordenada alfabeticamente
     * @return devuelve una lista de empleados ordenada alfabeticamente
     */
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

    /**
     *  Metodo que devuelve una lista de empleados ordenados por sueldo
     * @return decvuelve una lista de empleados ordenados por sueldo
     */
    public List<Empleado> listarEmpleadosPorSueldo() {
        List<Empleado> lista = new ArrayList<>(empleados.values());
        Collections.sort(lista, new ComparadorSueldo());
        return lista;
    }

    /**
     *  Metodo que devuelve la suma de los salarios
     * @return Devuelve el total de los salarios
     */
    public float getTotalSalarios() {
        float acum = 0;
        for (Empleado e : empleados.values()) {
            acum += e.ingresos();
        }
        return acum;
    }
}
