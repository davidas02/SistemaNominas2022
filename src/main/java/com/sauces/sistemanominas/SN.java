/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author daw1
 */
public class SN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        int opcion, opcion2;
        String dni,nombre;
        float salario;
        int horas;
        List<Empleado> listado;
        SistemaNominas sn=new SistemaNominas();
        do {
            System.out.println("1.-Contratar Empleado");
            System.out.println("2.-Consultar Empleado");
            System.out.println("3.-Despedir Empleado");
            System.out.println("4.-Listar Empleados");
            System.out.println("5.-Listar Empleados por sueldo");
            System.out.println("6.-Listar Empleados por nombre");
            System.out.println("7.-Consultar total Salarios");
            System.out.println("0.-Salir");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    do {
                        System.out.println("1.-Contratar Empleado Fijo");
                        System.out.println("2.-Contratar Empleado Eventual");
                        System.out.println("0.-Salir");
                        opcion2=teclado.nextInt();
                        teclado.nextLine();
                        switch(opcion2){
                            case 1:
                                System.out.println("Contratar Empleado Fijo");
                                System.out.println("Nombre del empleado");
                                nombre=teclado.nextLine();
                                System.out.println("DNI del empleado");
                                dni=teclado.nextLine();
                                System.out.println("Salario del empleado");
                                salario=teclado.nextFloat();
                                if(sn.incluirEmpleado(new EmpleadoFijo(dni, nombre, salario))){
                                System.out.println("Empleado Fijo Incluido con exito");
                                    System.out.println(sn.getEmpleado(dni));
                                }else{
                                    System.out.println("No se ha podido incluir el empleado");
                                }
                                break;
                            case 2:
                                System.out.println("Contratar Empleado Eventual");
                                System.out.println("Nombre del empleado");
                                nombre=teclado.nextLine();
                                System.out.println("DNI del empleado");
                                dni=teclado.nextLine();
                                System.out.println("Salario por hora del empleado");
                                salario=teclado.nextFloat();
                                System.out.println("Horas trabajadas por el empleado");
                                horas=teclado.nextInt();
                                if(sn.incluirEmpleado(new EmpleadoEventual(dni, nombre, salario, horas))){
                                System.out.println("Empleado Eventual Incluido con exito");
                                    System.out.println(sn.getEmpleado(dni));
                                }else{
                                    System.out.println("No se ha podido incluir el empleado");
                                }
                                break;
                        }
                        
                    } while (opcion2 != 0);
                    
                    break;
                case 2:
                    System.out.println("Consultar empleado");
                    System.out.println("Introduce el DNI del empleado a Consultar");
                    dni=teclado.nextLine();
                    System.out.println(sn.getEmpleado(dni));
                    break;
                case 3:
                    System.out.println("Consultar empleado");
                    System.out.println("Introduce el DNI del empleado a Despedir");
                    dni=teclado.nextLine();
                    if(sn.eliminarEmpleado(sn.getEmpleado(dni))){
                        System.out.println("Empleado despedido con exito");
                    }else{
                        System.out.println("No se ha podido despedir al empleado");
                    }
                    break;
                case 4:
                    listado=sn.listarEmpleadosPorNombre();
                    for(Empleado e1: listado){
                        System.out.println(e1);
                    }
                    break;
                case 5:
                    listado=sn.listarEmpleadosPorSueldo();
                    for(Empleado e1:listado){
                        System.out.println(e1);
                    }
                    break;
                case 6:
                    listado=sn.listarEmpleadosPorNombre();
                    for(Empleado e1:listado){
                        System.out.println(e1);
                    }
                    break;
                case 7:
                    System.out.println(sn.getTotalSalarios());
                    break;
                default:
                    System.out.println("Opcion no disponible");
                case 0:
                    System.out.println("Hasta Luego!!");
                    break;

            }
        } while (opcion != 0);
    }

}
