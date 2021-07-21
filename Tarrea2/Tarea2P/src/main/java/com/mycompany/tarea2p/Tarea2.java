
package com.mycompany.tarea2p;

import java.util.Scanner;

/**
 *
 * @author Iris Damian
 */
public class Tarea2 {
     private static Scanner texto = new Scanner(System.in);
     public static String EncCod(String P){
      String resul = "";
      int num = 14;
      int cd = 0;
        for(int x=0; x<P.length(); x++){
            cd = (int)P.charAt(x);
            cd = cd + num;
            char crt = (char) cd;
            resul = resul + crt;               
        }
        return resul;
    }
    public static String DesCod(String C,int num){
        String resul = "";
        int cd = 0;
        for(int x=0; x<C.length(); x++){
            cd = (int)C.charAt(x);
            cd = cd - num;
            char crt = (char) cd;
            resul = resul + crt;             
        }
        return resul;      
    }
    public static void main(String[] args) {
        String L = "", result = "", r = "";
        System.out.println("Pon el mensaje que tu deseas");
        L = texto.nextLine();
        result = EncCod(L);
        System.out.println("¡Exelente! Tu mensaje es: " + result);
        r = DesCod(result, 14);
        System.out.println("Tu codigo es: " + r);      
    }    
}
