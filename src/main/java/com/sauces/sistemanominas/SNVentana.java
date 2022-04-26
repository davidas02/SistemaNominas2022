/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

import com.sauces.sistemanominas.controlador.Controlador;
import com.sauces.sistemanominas.modelo.SistemaNominas;
import com.sauces.sistemanominas.vista.Ventana;

/**
 *
 * @author PC
 */
public class SNVentana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ventana vista=new Ventana();
        SistemaNominas modelo=new SistemaNominas();
        Controlador controlador=new Controlador(vista, modelo);
        vista.setControlador(controlador);
        controlador.iniciar();
    }
    
}
