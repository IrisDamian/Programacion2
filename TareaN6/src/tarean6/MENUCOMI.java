/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarean6;

import COM.COMI;
import java.util.Scanner;

/**
 *
 * @author Iris Damian
 */
public class MENUCOMI {
    
    COMI com = new COMI();
    
    public void Menu(){
    Scanner Lector=new Scanner(System.in);
        String opcion="";
        int opcion2=0;
        
        do {
        System.out.println("\n*****MENU PRINCIPAL*****");
        System.out.println("1-Registra  Informacion\n"
                + "2- Mayores y Menores ventas por Mes\n"
                + "3-Quien fue que Vendio Mas en los Tres Meses\n"
                + "4-Cambio de  Informacion\n"
                + "5-Buscar  Informacion\n"
                + "6-Tabla\n"
                + "7-Salir");
        System.out.println("Que deseas hacer: "); opcion=Lector.nextLine();
        
        switch(opcion){
            case "1":
                com.RegistraInformacion();
                com.Calculos();
                break;
            case "2":
                com.VMM();
                System.out.println("\n");
                com.VMEM();
                break;
            case "3":
                com.VM();
                break;
            case "4":
                com.MR();
                break;
            case "5":
                    com.Br();
                break;
            case "6":
                com.ImprimirInformacion();
                break;
          }
        } while(!opcion.equals("7"));
        
        System.out.println(" ¿Quieres Salir?\n"
                + "[8] Salir del Programa\n"
                + "[9] Regreso al Menu Principal");
        System.out.println("Opcion: "); opcion2=Lector.nextInt();
         
        if (opcion2==8) {
            System.exit(0);
        }
        if (opcion2==9) {
            Menu();
        }
    }
}
