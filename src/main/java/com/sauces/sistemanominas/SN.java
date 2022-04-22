/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

import com.sauces.sistemanominas.modelo.SistemaNominas;
import com.sauces.sistemanominas.modelo.Dni;
import com.sauces.sistemanominas.modelo.EmpleadoDaoXml;
import com.sauces.sistemanominas.modelo.DniException;
import com.sauces.sistemanominas.modelo.EmpleadoFijo;
import com.sauces.sistemanominas.modelo.Empleado;
import com.sauces.sistemanominas.modelo.EmpleadoDaoObj;
import com.sauces.sistemanominas.modelo.EmpleadoDaoCsv;
import com.sauces.sistemanominas.modelo.DaoException;
import com.sauces.sistemanominas.modelo.EmpleadoDaoJson;
import com.sauces.sistemanominas.modelo.EmpleadoDao;
import com.sauces.sistemanominas.modelo.EmpleadoEventual;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Properties propiedades = new Properties();
        try (BufferedReader ficheroLe = Files.newBufferedReader(Paths.get("propiedades.properties"))) {
            propiedades.load(ficheroLe);
            String fecha = propiedades.getProperty("fecha");
            String hora=propiedades.getProperty("hora");
            System.out.println("Ultima conexion " + fecha+" "+hora);
        } catch (IOException ioe) {
            System.out.println("Error de E/S");
        }
        Scanner teclado = new Scanner(System.in);
        int opcion, opcion2;
        String seguro, fichero;
        String dni, nombre;
        float salario;
        int horas;
        int n;
        List<Empleado> listado = null;
        SistemaNominas sn = new SistemaNominas();
        do {
            System.out.println("1.-Contratar Empleado");
            System.out.println("2.-Consultar Empleado");
            System.out.println("3.-Despedir Empleado");
            System.out.println("4.-Listar Empleados");
            System.out.println("5.-Listar Empleados por sueldo");
            System.out.println("6.-Listar Empleados por nombre");
            System.out.println("7.-Consultar total Salarios");
            System.out.println("8.-Guardar Empleados");
            System.out.println("9.-Cargar Empleados");
            System.out.println("0.-Salir");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    do {
                        System.out.println("1.-Contratar Empleado Fijo");
                        System.out.println("2.-Contratar Empleado Eventual");
                        System.out.println("0.-Salir");
                        opcion2 = teclado.nextInt();
                        teclado.nextLine();
                        switch (opcion2) {
                            case 1:
                                try {
                                System.out.println("Contratar Empleado Fijo");
                                System.out.println("Nombre del empleado");
                                nombre = teclado.nextLine();
                                System.out.println("DNI del empleado");
                                dni = teclado.nextLine();
                                System.out.println("Salario del empleado");
                                salario = teclado.nextFloat();
                                if (sn.incluirEmpleado(new EmpleadoFijo(Dni.valueOf(dni), nombre, salario))) {
                                    System.out.println("Empleado Fijo Incluido con exito");
                                    System.out.println(sn.getEmpleado(dni));
                                } else {
                                    System.out.println("No se ha podido incluir el empleado");
                                }
                            } catch (DniException de) {
                                System.out.println(de.getMessage());
                            }

                            break;

                            case 2:
                                try {
                                System.out.println("Contratar Empleado Eventual");
                                System.out.println("Nombre del empleado");
                                nombre = teclado.nextLine();
                                System.out.println("DNI del empleado");
                                dni = teclado.nextLine();
                                System.out.println("Salario por hora del empleado");
                                salario = teclado.nextFloat();
                                System.out.println("Horas trabajadas por el empleado");
                                horas = teclado.nextInt();
                                if (sn.incluirEmpleado(new EmpleadoEventual(Dni.valueOf(dni), nombre, salario, horas))) {
                                    System.out.println("Empleado Eventual Incluido con exito");
                                    System.out.println(sn.getEmpleado(dni));
                                } else {
                                    System.out.println("No se ha podido incluir el empleado");
                                }
                            } catch (DniException de) {
                                System.out.println(de.getMessage());
                            }

                            break;

                        }

                    } while (opcion2 != 0);

                    break;

                case 2:
                    System.out.println("Consultar empleado");
                    System.out.println("Introduce el DNI del empleado a Consultar");
                    dni = teclado.nextLine();
                     {
                        try {
                            if (sn.getEmpleado(Dni.valueOf(dni)) != null) {
                                System.out.println(sn.getEmpleado(Dni.valueOf(dni)));
                            } else {
                                System.out.println("El empleado no existe en el sistema");
                            }
                        } catch (DniException de) {
                            System.out.println(de.getMessage());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Despedir empleado");
                    System.out.println("Introduce el DNI del empleado a Despedir");
                    dni = teclado.nextLine();
                    System.out.println("Está seguro?? Entonces escriba SI de lo contrario escriba NO");
                    seguro = teclado.nextLine();
                    if (seguro.equals("SI")) {
                        try {
                            if (sn.getEmpleado(Dni.valueOf(dni)) != null) {
                                sn.eliminarEmpleado(sn.getEmpleado(dni));
                                System.out.println("Empleado despedido con exito");
                            } else {
                                System.out.println("No se ha podido despedir al empleado");
                            }
                        } catch (DniException de) {
                            System.out.println(de.getMessage());
                        }
                    }
                    break;
                case 4:
                    listado = sn.listarEmpleadosPorNombre();
                    for (Empleado e1 : listado) {
                        System.out.println(e1);
                    }
                    break;
                case 5:
                    listado = sn.listarEmpleadosPorSueldo();
                    for (Empleado e1 : listado) {
                        System.out.println(e1);
                    }
                    break;
                case 6:
                    listado = sn.listarEmpleadosPorNombre();
                    for (Empleado e1 : listado) {
                        System.out.println(e1);
                    }
                    break;
                case 7:
                    System.out.println(sn.getTotalSalarios());
                    break;
                case 8:
                    System.out.println("8.-Guardar Empleados");
                    System.out.println("Introduce el nombre del fichero a guardar");
                    fichero = teclado.nextLine();
                    sn.setEmpleadoDao(getDao(fichero));
                    try {
                        n = sn.guardarEmpleados();
                        System.out.println("Se han cargado " + n + " empleados");
                    } catch (DaoException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 9:
                    System.out.println("9.-Cargar Empleados");
                    System.out.println("Introduce el nombre del fichero a cargar");
                    fichero = teclado.nextLine();
                    sn.setEmpleadoDao(getDao(fichero));
                    try {
                        n = sn.cargarEmpleados();
                        System.out.println("Se han incluido " + n + " empleados");
                    } catch (DniException de) {
                        System.out.println(de.getMessage());
                    } catch (DaoException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opcion no disponible");
                case 0:
                    System.out.println("Hasta Luego!!");
                    break;

            }
        } while (opcion != 0);
        propiedades.setProperty("fecha" ,LocalDate.now().toString() );
        propiedades.setProperty("hora", LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
    try (BufferedWriter ficheroEs = Files.newBufferedWriter(Paths.get("propiedades.properties"))) {
            propiedades.store(ficheroEs, "comentario");
        } catch (IOException ioe) {
            System.out.println("Error de E/S");
        }
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
