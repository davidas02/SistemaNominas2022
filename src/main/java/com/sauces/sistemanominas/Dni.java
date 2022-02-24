/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
<<<<<<< HEAD
 *
 * @author daw1
=======
 *  Clase dni 
 * @author David Aparicio Sir
>>>>>>> desarrollo
 */
public class Dni implements Comparable<Dni>{
    private String numero;
    private char letra;
<<<<<<< HEAD

=======
    public Dni() {
    }
    /**
     * Constructor de la clase dni
     * @param numero Numeros del dni
     * @param letra Letra del dni
     * @throws DniException Excepcion de la clase Sni
     */
    
>>>>>>> desarrollo
    public Dni(String numero, char letra) throws DniException {
        if(!esValido(numero+letra)){
            throw new DniException("Formato incorrecto del DNI");
        }
        this.numero = numero;
        this.letra = letra;
    }
<<<<<<< HEAD
=======

    /**
     *Constructor 
     * @param dni
     * @throws DniException
     */
>>>>>>> desarrollo
    public Dni(String dni) throws DniException{
        if(!esValido(dni)){
            throw new DniException("Formato incorrecto del DNI");
        }
<<<<<<< HEAD
        this.numero=dni.substring(0,7);
        letra=dni.charAt(8);
    }
=======
        this.numero =dni.substring(0,7) ;
        this.letra = dni.charAt(8);
    }

   

    /**
     *  Devuelve el numero del dni
     * @return Numero del DNI
     */
>>>>>>> desarrollo
    public String getNumero() {
        return numero;
    }

<<<<<<< HEAD
=======
    /**
     *  Establece el numero del DNI
     * @param numero nuevo numero del DNI
     */
>>>>>>> desarrollo
    public void setNumero(String numero) {
        this.numero = numero;
    }

<<<<<<< HEAD
=======
    /**
     *  Devuelve la letra del DNI
     * @return
     */
>>>>>>> desarrollo
    public char getLetra() {
        return letra;
    }

<<<<<<< HEAD
    public void setLetra(char letra) {
        this.letra = letra;
    }
=======
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
>>>>>>> desarrollo
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.numero);
        hash = 61 * hash + this.letra;
        return hash;
    }

<<<<<<< HEAD
=======
    /**
     *
     * @param obj
     * @return
     */
>>>>>>> desarrollo
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

<<<<<<< HEAD
=======
    /**
     *
     * @return
     */
>>>>>>> desarrollo
    @Override
    public String toString() {
        return  numero + letra;
    }

<<<<<<< HEAD
=======
    /**
     *
     * @param dni
     * @return
     */
>>>>>>> desarrollo
    @Override
    public int compareTo(Dni dni) {
        return this.numero.compareTo(dni.numero);
    }
<<<<<<< HEAD
    public static boolean esValido(String dni){
    boolean correcto=false;
    int resto;
    String patron="([0-9]{8})([A-Z])";
    String letras="TRWAGMYFPDXBNJZSQVHLCKE";
    Pattern p=Pattern.compile(patron);
    Matcher m=p.matcher(dni);
=======
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
>>>>>>> desarrollo
        if(m.matches()){
            resto=Integer.parseInt(m.group(1))%23;
            if(letras.charAt(resto)==m.group(2).charAt(0)){
                correcto=true;
<<<<<<< HEAD
            } else {

=======
>>>>>>> desarrollo
            }
        }
        return correcto;
    }
    
}
