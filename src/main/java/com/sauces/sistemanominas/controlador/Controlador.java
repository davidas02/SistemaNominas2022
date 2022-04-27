/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas.controlador;

import com.sauces.sistemanominas.modelo.DaoException;
import com.sauces.sistemanominas.modelo.Dni;
import com.sauces.sistemanominas.modelo.DniException;
import com.sauces.sistemanominas.modelo.Empleado;
import com.sauces.sistemanominas.modelo.EmpleadoDao;
import com.sauces.sistemanominas.modelo.EmpleadoDaoCsv;
import com.sauces.sistemanominas.modelo.EmpleadoDaoJson;
import com.sauces.sistemanominas.modelo.EmpleadoDaoObj;
import com.sauces.sistemanominas.modelo.EmpleadoDaoXml;
import com.sauces.sistemanominas.modelo.EmpleadoEventual;
import com.sauces.sistemanominas.modelo.EmpleadoFijo;
import com.sauces.sistemanominas.modelo.SistemaNominas;
import com.sauces.sistemanominas.vista.Ventana;
import java.util.logging.Level;
import java.util.logging.Logger;

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
         try {
            if(vista.getTipo().equals("FIJO")){

                    e=new EmpleadoFijo(new Dni(vista.getDni()), vista.getNombre(),vista.getSalario());

            }else{
                   e=new EmpleadoEventual(new Dni(vista.getDni()), vista.getNombre(),vista.getSalario(), vista.getHoras());
            }
            if(modelo.incluirEmpleado(e)){
                vista.mostrarIngresos(e.ingresos());
                vista.mostrarMensaje("Empleado contratado");
            }else{
                vista.mostrarMensaje("No se ha podico contratar al empleado");
            }
         } catch (DniException ex) {
            vista.mostrarMensaje(ex.getMessage());
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
        Empleado empleado=null;
        try {
            empleado = modelo.getEmpleado(vista.getDni());
            
             if(vista.solicitarConfirmacion()&&modelo.eliminarEmpleado(empleado)){
                 vista.mostrarMensaje("Empleado Despedido");
            }
        } catch (DniException ex) {
          vista.mostrarMensaje(ex.getMessage());
        }
    }
    public void modificarEmpleado(){
        if(vista.solicitarConfirmacion()){
          String dni=vista.getDni();
            try {
                Empleado e=modelo.getEmpleado(dni);
                e.setNombre(vista.getNombre());
                if(e instanceof EmpleadoFijo){
                    ((EmpleadoFijo) e).setSalario(vista.getSalario());
                }else{
                    if(e instanceof EmpleadoEventual){
                        ((EmpleadoEventual) e).setHoras(vista.getHoras());
                        ((EmpleadoEventual) e).setSalarioHora(vista.getSalario());
                    }
                }
            } catch (DniException ex) {
                vista.mostrarMensaje(ex.getMessage());
            }
        }
    }
    public void listarEmpleados(){
       switch(vista.getOrden()){
            case "DNI":
                vista.listarEmpleados(modelo.listarEmpleadosPorDNI());
                break;
            case "NOMBRE":
                vista.listarEmpleados(modelo.listarEmpleadosPorNombre());
                break;
            case "INGRESOS":
                vista.listarEmpleados(modelo.listarEmpleadosPorSueldo());
                break;
            default:
                vista.listarEmpleados(modelo.listarEmpleados());
                break;
        }
        
    }
    public void guardarEmpleados(){
    modelo.setEmpleadoDao(getDao(vista.getArchivo()));
        try {
           vista.mostrarMensaje("Se han guardado "+ modelo.guardarEmpleados()+" empleados");
        } catch (DaoException ex) {
           vista.mostrarMensaje(ex.getMessage());
        }
    }
    public void cargarEmpleados() {
        modelo.setEmpleadoDao(getDao(vista.getArchivo()));
         try {
           vista.mostrarMensaje("Se han cargado "+modelo.cargarEmpleados()+" empleados");
        } catch (DaoException ex) {
           vista.mostrarMensaje(ex.getMessage());
        } catch (DniException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
         
    }
    public void iniciar(){
        vista.mostrar();
    }
    private static EmpleadoDao getDao(String fichero) {
        EmpleadoDao ed = null;
        int posPunto = fichero.lastIndexOf(".") + 1;
        String extension = fichero.substring(posPunto);
        switch (extension) {
            case "csv":
                ed = new EmpleadoDaoCsv(fichero);
                break;
            case "obj":
                ed = new EmpleadoDaoObj(fichero);
                break;
            case "xml":
                ed = new EmpleadoDaoXml(fichero);
                break;
            case "json":
                ed = new EmpleadoDaoJson(fichero);
                break;
        }
        return ed;
    }
}
