/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMISIONES;

import NEGOCIO.CATNEGOCIO;
import java.util.Scanner;

/**
 *
 * @author Iris Damian
 */
public class MENUCOMI {
     CATNEGOCIO Cat = new CATNEGOCIO();
    
    public void Menu(){
    Scanner Lector=new Scanner(System.in);
        String op = "";
        int op2 = 0;
        
        do {      
        System.out.println("1 Ingreso de Datos\n"
                + "2 Ventas de mayor y menor\n"
                + "3 Gran total\n"
                + "4 Cambio de nombre\n"
                + "5 Cambio de  cantidad\n"
                + "6 Eliminar Datos\n"
                + "7 Busqueda\n"
                + "8 Tabla de Datos\n"
                + "9 Salir");
        System.out.println("Escoge una opcion "); 
        op = Lector.nextLine();
        
        switch(op){
             case "1":
                Cat.Ingresar();
                break;
            case "2":
                Cat.VentaMay();
                System.out.println("\n");
                Cat.VentaMen();
                break;
            case "3":
                Cat.VentaMayorT();
                break;
            case "4":
                Cat.EditarNom();
            case "5":
                Cat.EditarCan();
                break;
            case "6":
                Cat.BorrarEmpleado();
                break;
            case "7":
                Cat.Busqueda();
                break;
            case "8":
                Cat.Imprimir();
                break;    
          }
        } while(!op.equals("9"));
        
        System.out.println("¿Quieres salir?\n"
                + "1 Salir\n"
                + "2 Menu");
        System.out.println("Opcion "); 
        op2 = Lector.nextInt();
         
        if (op2==1) {
            System.exit(0);
        }
        if (op2==2) {
            Menu();
        }
    }
}
