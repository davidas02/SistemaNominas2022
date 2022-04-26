/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas.controlador;

import com.sauces.sistemanominas.modelo.Dni;
import com.sauces.sistemanominas.modelo.DniException;
import com.sauces.sistemanominas.modelo.Empleado;
import com.sauces.sistemanominas.modelo.EmpleadoEventual;
import com.sauces.sistemanominas.modelo.EmpleadoFijo;
import com.sauces.sistemanominas.modelo.SistemaNominas;
import com.sauces.sistemanominas.vista.Ventana;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author daw1
 */
public class Controlador {
    private Ventana vista;
    private SistemaNominas modelo;

    public Controlador(Ventana vista, SistemaNominas modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    public void crearEmpleado(){
        Empleado e=null;
        if(vista.getTipo().equals("FIJO")){
            try {
                e=new EmpleadoFijo(new Dni(vista.getDni()), vista.getNombre(),vista.getSalario());
            } catch (DniException ex) {
            vista.mostrarMensaje(ex.getMessage());
            }
        }else{
            try {
                e=new EmpleadoEventual(new Dni(vista.getDni()), vista.getNombre(),vista.getSalario(), vista.getHoras());
            } catch (DniException ex) {
                vista.mostrarMensaje(ex.getMessage());
            }
        }
        if(modelo.incluirEmpleado(e)){
            vista.mostrarMensaje("Empleado contratado");
        }else{
            vista.mostrarMensaje("No se ha podico contratar al empleado");
        }
    }
    public void buscarEmpleado() {
        String dni=vista.getDni();
        try {
           Empleado e= modelo.getEmpleado(dni);
           if(e!=null){
               vista.mostrarNombre(e.getNombre());
               vista.mostrarIngresos(e.ingresos());
               if(e instanceof EmpleadoFijo){
                   vista.mostrarSalario(((EmpleadoFijo) e).getSalario());
               }else{
                   vista.mostrarSalario(((EmpleadoEventual)e).getSalarioHora());
                   vista.mostrarHoras(((EmpleadoEventual)e).getHoras());
               }
           }
        } catch (DniException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }
    public void eliminarEmpleado(){
        Empleado empleado;
        try {
            empleado = modelo.getEmpleado(vista.getDni());
             if(modelo.eliminarEmpleado(empleado)){
                 vista.mostrarMensaje("Empleado Despedido");
                 vista.limpiarCampos();
            }
        } catch (DniException ex) {
          vista.mostrarMensaje(ex.getMessage());
        }
       
    }
}
