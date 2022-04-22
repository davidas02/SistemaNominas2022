/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas.vista;

import com.sauces.sistemanominas.modelo.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daw1
 */
public class EmpleadoTableModel extends AbstractTableModel {
    private List<Empleado> listado;
    private String[] columnas;

    public EmpleadoTableModel() {
        this.listado=new ArrayList<>();
        this.columnas=new String[]{"DNI","NOMBRE","SALARIO","HORAS","INGRESOS"};
    }
    
    @Override
    public int getRowCount() {
        return listado.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean isCellEditable(int row,int col){
        return false;
    }
    
}
