/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author daw1
 */
public class EmpleadoDaoXml implements EmpleadoDao{
   private Path path;

    public EmpleadoDaoXml(String path) {
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
    public List<Empleado> listar() throws DaoException {
        XStream xstream=new XStream(new DomDriver());    
        //XStream.setupDefaultSecurity(xstream);
        xstream.allowTypeHierarchy(EmpleadoFijo.class);
        xstream.allowTypeHierarchy(EmpleadoEventual.class);
        List<Empleado> listadoEmpleados;
        
        try(BufferedReader br= Files.newBufferedReader(path);){
            listadoEmpleados=(List<Empleado>)xstream.fromXML(br);
        } catch (IOException ex) {
            throw  new DaoException(ex.getMessage());
        }
        return listadoEmpleados;
    }
    /**
     * 
     * @param listado listado de empleados
     * @return devuelve un fichero con formato xml
     * @throws DaoException 
     */
    @Override
    public int insertar(List<Empleado> listado) throws DaoException {
        XStream xstream=new XStream(new DomDriver());    
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypeHierarchy(EmpleadoFijo.class);
        xstream.allowTypeHierarchy(EmpleadoEventual.class);
        try(BufferedWriter bw=Files.newBufferedWriter(path)){
            xstream.toXML(listado,bw);
        } catch (IOException ex) {
            throw  new DaoException(ex.getMessage());
        }
        return listado.size();
    }
    
}
