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
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public List<Empleado> listar() throws DaoException,DniException{
        List<Empleado> listado=new ArrayList<>();
        String linea;
        String[] tokens;
        String dni,nombre;
        float salario,salarioHora;
        int horas;
        Empleado empleado=null;
        try(BufferedReader entrada=Files.newBufferedReader(path)){
            linea=entrada.readLine();
            while(linea!=null){
                tokens=linea.split(",");
                if(tokens[0].equals("EmpleadoFijo")){
                    dni=tokens[1];
                    nombre=tokens[2];
                    salario=Float.parseFloat(tokens[3]);
                empleado=new EmpleadoFijo(Dni.valueOf(dni), nombre, salario);
                }else{
                    if(tokens[0].equals("EmpleadoEventual")){
                       dni=tokens[1];
                       nombre=tokens[2];
                       salarioHora=Float.parseFloat(tokens[3]);
                       horas=Integer.parseInt(tokens[4]);
                       empleado=new EmpleadoEventual(Dni.valueOf(dni), nombre, salarioHora, horas);
                    }
                }
                listado.add(empleado);
                linea=entrada.readLine();
            }
        }catch (DniException de) {
           throw new DniException(de.getMessage());
        } catch (IOException ex) { 
            throw new DaoException(ex.getMessage());
        } 
        return listado;
    }

    @Override
    public int insertar(List<Empleado> listado) throws DaoException {
        int n=0;
        String linea;
        try(BufferedWriter salida=Files.newBufferedWriter(path)){
            for(Empleado e:listado){
                linea=e.getClass().getSimpleName()+e.toString();
                salida.write(linea);
                salida.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(EmpleadoDaoCsv.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return n;
    }
}
