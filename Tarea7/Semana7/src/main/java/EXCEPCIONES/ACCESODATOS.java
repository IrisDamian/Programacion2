/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EXCEPCIONES;

/**
 *
 * @author Iris Damian
 */
public class ACCESODATOS extends Exception{
   String Mensaje;
    public ACCESODATOS(String msg){
        this.Mensaje = msg;
    }  
}
