/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 *
 * @author Iris Damian
 */
public class T1 {
     public static void main (String arg[]) throws IOException{
        
       BufferedReader lector=new BufferedReader (new InputStreamReader(System.in));
       Scanner lectornum=new Scanner(System.in);
       
       String nom,operar;
       double quetz,res;
       int num=1;
       
       while(num==1){
       System.out.println("Ingresa tu nombre:");
       nom= lector.readLine();
       System.out.println("Escribe una cantidad en Quetzales");
       quetz=lectornum.nextDouble();
       System.out.println("¿En que moneda desea realizar el cambio?\n"
               + "Escribe una opcion\n"
               + "(1) Dolares\n"
               + "(2) Euros\n"
               + "(3) Yuanes");
       operar=lector.readLine();
       
       switch(operar){
           case "1":
               res= quetz * 0.13;
               System.out.println("Tu nombre es " + nom);
               System.out.println("La cantidad total de dolares es: $"+ res);
               break;
           case "2":
               res= quetz * 0.11;
               System.out.println("Tu nombre es " + nom);
                System.out.println("La cantidad total de euros es: €"+ res);
               break;
           case "3":
               res= quetz * 0.84;
               System.out.println("Tu nombre es " + nom);
               System.out.println("La cantidad total de yuanes es: ¥"+ res);
               break;      
           default: 
              System.out.println("Opcion Erronea");
              break;  
       } 
       System.out.println("¿Quieres volver a operar?");
       System.out.println("Escriba 1 para volver a convertir");
       System.out.println("Escriba 2 para poder salir");
       num=lectornum.nextInt();       
       }  
       
    }    
}
