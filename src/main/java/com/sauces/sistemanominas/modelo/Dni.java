/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Clase dni 
 * @author David Aparicio Sir
 */
public class Dni implements Comparable<Dni>, Serializable{
    private String numero;
    private char letra;
    public Dni() {
    }
    /**
     * Constructor de la clase dni
     * @param numero Numeros del dni
     * @param letra Letra del dni
     * @throws DniException Excepcion de la clase Sni
     */
    
    public Dni(String numero, char letra) throws DniException {
        if(!esValido(numero+letra)){
            throw new DniException("Formato incorrecto del DNI");
        }
        this.numero = numero;
        this.letra = letra;
    }

    /**
     *Constructor 
     * @param dni
     * @throws DniException
     */
    public Dni(String dni) throws DniException{
        if(!esValido(dni)){
            throw new DniException("Formato incorrecto del DNI");
        }
        this.numero =dni.substring(0,8) ;
        this.letra = dni.charAt(8);
    }

   

    /**
     *  Devuelve el numero del dni
     * @return Numero del DNI
     */
    public String getNumero() {
        return numero;
    }

    /**
     *  Establece el numero del DNI
     * @param numero nuevo numero del DNI
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     *  Devuelve la letra del DNI
     * @return
     */
    public char getLetra() {
        return letra;
    }

    /**
     *  Establece la nueva letra del DNI
     * @param letra letra del DNI
     */
    public void setLetra(char letra) {
        this.letra = letra;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.numero);
        hash = 61 * hash + this.letra;
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dni other = (Dni) obj;
        if (this.letra != other.letra) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return  numero + letra;
    }

    /**
     *
     * @param dni
     * @return
     */
    @Override
    public int compareTo(Dni dni) {
        return this.numero.compareTo(dni.numero);
    }
    public static Dni valueOf(String dni) throws DniException{
        return new Dni(dni);
    }
    /**
     *
     * @param dni
     * @return
     */
    public static boolean esValido(String dni){
        boolean correcto=false;
        int resto;
        String patron="([0-9]{8})([A-Z])";
        String letras="TRWAGMYFPDXBNJZSQVHLCKE";
        Pattern p=Pattern.compile(patron);
        Matcher m=p.matcher(dni);
        if(m.matches()){
            resto=Integer.parseInt(m.group(1))%23;
            if(letras.charAt(resto)==m.group(2).charAt(0)){
                correcto=true;
            }
        }
        return correcto;
    }
    
}
