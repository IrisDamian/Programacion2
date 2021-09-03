/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMICIONES;

import NEGOCIO.CATEMPLEADOSIMPLEMENTAR;
import NEGOCIO.CATNEGOCIO;
import java.util.Scanner;

/**
 *
 * @author Iris Damian
 */
public class MENUCOMICIONES {
    CATNEGOCIO Cat = new CATNEGOCIO();
    private static final CATEMPLEADOSIMPLEMENTAR Ca = new CATEMPLEADOSIMPLEMENTAR();
    private static final String nombreArchivo = "C:\\Users\\Iris Damian\\Desktop\\Tarea7\\Archivo\\archivo.txt";
    
    public void Menu(){
    Scanner Lector=new Scanner(System.in);
        String op = "";
        int op2 = 0;
        
        do {      
        System.out.println("1 Archivo\n"
                + "2 Escribe  informacion\n"
                + "3 Ventas\n"
                + "4 Gran total de las ventas\n"
                + "5 Editar\n"
                + "6 Buscar\n"
                + "7 Tabla\n"
                + "8 Salir");
        System.out.println("Escoja una opcion "); op=Lector.nextLine();
        
        switch(op){
             case "1":
                Ca.IniciarArchivo(nombreArchivo);
                break;
            case "2":
                Cat.AgregarInformacion();
                Ca.CargarInformacion(nombreArchivo);
                Ca.Calculos();
                break;
            case "3":
                Ca.VenMA();
                System.out.println("\n");
                Ca.VenME();
                break;
            case "4":
                Ca.VenMAT();
                break;
            case "5":
               Ca.Edit();
                break;
            case "6":
                Ca.Busqueda();
                break;
            case "7":
                Ca.ImprimirInformacion();
                break;
          }
        } while(!op.equals("8"));
        
        System.out.println("Quieres salir\n"
                + "9 Salir\n"
                + "1 Menu");
        System.out.println("Opcion: "); op2 = Lector.nextInt();
         
        if (op2==9) {
            System.exit(0);
        }
        if (op2==1) {
            Menu();
        }
    }
}
