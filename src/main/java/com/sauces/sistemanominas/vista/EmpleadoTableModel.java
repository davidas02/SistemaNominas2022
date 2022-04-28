/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas.vista;

import com.sauces.sistemanominas.modelo.Dni;
import com.sauces.sistemanominas.modelo.Empleado;
import com.sauces.sistemanominas.modelo.EmpleadoEventual;
import com.sauces.sistemanominas.modelo.EmpleadoFijo;
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

    public void setListado(List<Empleado> listado) {
        this.listado = listado;
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
    public Object getValueAt(int row, int col) {
        Empleado e=listado.get(row);
        Object o=null;
        switch(col){
            case 0: o=e.getDni();
                break;
            case 1: o=e.getNombre();
                break;
            case 2: if(e instanceof EmpleadoFijo){
                        o=((EmpleadoFijo) e).getSalario();
                    }else{
                        o=((EmpleadoEventual)e).getSalarioHora();
                    }
                break;
            case 3 :
                if(e instanceof EmpleadoEventual){
                    o=((EmpleadoEventual) e).getHoras();
                }else{
                    o=0;
                }
                break;
            case 4 :
                o=e.ingresos();
                break;
        }
        return o;
    }
    public boolean isCellEditable(int row,int col){
        return false;
    }
    public Class<?> getColumnClass(int col){
        Class<?> clase=null;
        switch(col){
            case 0: clase=String.class;
            break;
            case 1: clase=String.class;
            break;
            case 2: clase=Float.class;
            break;
            case 3: clase= Integer.class;
            break;
            case 4: clase=Float.class;
            break;
        }
        return clase;
    }
    public String getColumnName(int col){
        return columnas[col];
    }
}
