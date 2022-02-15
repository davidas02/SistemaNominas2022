/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

import java.util.Comparator;

/**
 *
 * @author daw1
 */
public class ComparadorSueldo implements Comparator<Empleado> {

    @Override
    public int compare(Empleado e1, Empleado e2) {
        int salida = 0;
        float s1 = e1.ingresos();
        float s2 = e2.ingresos();
        if (s1 > s2) {
            salida = 1;
        } else {
            if (s1 < s2) {
                salida = -1;
            }
        }
        return salida;
    }

}
