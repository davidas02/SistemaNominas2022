/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class EmpleadoDaoCsv implements EmpleadoDao{
    private Path path;

    public EmpleadoDaoCsv(String path) {
        this.path = Paths.get(path);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
    /**
     * Metodo que devuelve una lista de empleados que se han añadido al sistema
     * @return Devuelve una lista de empleados que se han añadido al sistema
     * @throws DaoException 
     */
    @Override
    public List<Empleado> listar() throws DaoException{
        List<Empleado> listado=new ArrayList<>();
        String linea;
        String[] tokens;
        String tipo;
        String dni,nombre;
        float salario,salarioHora;
        int horas;
        Empleado empleado=null;
        try(BufferedReader entrada=Files.newBufferedReader(path)){
            linea=entrada.readLine();
            while(linea!=null){
                tokens=linea.split(",");
                tipo=tokens[0];
                dni=tokens[1];
                nombre=tokens[2];
                switch(tipo){
                    case "EmpleadoFijo":
                    salario=Float.parseFloat(tokens[3]);
                    empleado=new EmpleadoFijo(Dni.valueOf(dni), nombre, salario);
                    
                        break;
                    case "EmpleadoEventual":
                       salarioHora=Float.parseFloat(tokens[3]);
                       horas=Integer.parseInt(tokens[4]);
                       empleado=new EmpleadoEventual(Dni.valueOf(dni), nombre, salarioHora, horas);
                       break;
            }
                listado.add(empleado);
                linea=entrada.readLine();
            }
        }catch (DniException | IOException de) {
           throw new DaoException(de.getMessage());
        } catch(Exception ex){
        throw new DaoException("Error de formato");
        }
        return listado;
    }
    /**
     * 
     * @param listado listado de empleados
     * @return devuelve un fichero con formato csv
     * @throws DaoException 
     */
    @Override
    public int insertar(List<Empleado> listado) throws DaoException {
        int n=0;
        String linea;
        try(BufferedWriter salida=Files.newBufferedWriter(path)){
            for(Empleado e:listado){
                linea=e.getClass().getSimpleName()+","+e.toString();
                salida.write(linea);
                salida.newLine();
                n++;
            }
        }catch(IOException ex){
            throw new DaoException(ex.getMessage());
        }  
        return n;
    }
}
