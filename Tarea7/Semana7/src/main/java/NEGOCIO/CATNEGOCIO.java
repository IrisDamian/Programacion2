/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import java.util.Scanner;

/**
 *
 * @author Iris Damian
 */
public class CATNEGOCIO {
    Scanner Lector = new Scanner(System.in);
    private static final CATEMPLEADOSIMPLEMENTAR Cat = new CATEMPLEADOSIMPLEMENTAR();
    private static final String nombreArchivo = "C:\\Users\\Iris Damian\\Desktop\\Tarea7\\Archivo\\archivo.txt";
    
    public void AgregarInformacion(){
        String Nombre = "", Guardar = "";
        Double Enero=0.0,Febrero=0.0,Marzo=0.0,VentasT=0.0,Promedio=0.0;
        System.out.println("No. de personas a ingresar ");
        int C = Lector.nextInt();
        for (int i = 0; i <C; i++) {          
            System.out.println("Escribe tu nombre");
            Nombre=Lector.nextLine();
            Nombre=Lector.nextLine();
            System.out.println("Escriba la  ventas de Enero");
            Enero=Lector.nextDouble();
            System.out.println("Escriba la  ventas de Febrero");
            Febrero=Lector.nextDouble();
            System.out.println("Escriba la ventas de Marzo");
            Marzo=Lector.nextDouble();
            VentasT=(Enero+Febrero+Marzo);
            Promedio =(VentasT/3);
            Guardar=(Nombre+";"+Enero+";"+Febrero+";"+Marzo+";"+VentasT+";"+Promedio+";");
            Cat.AgregarInformacion(Guardar, nombreArchivo);
            }
    }
}
