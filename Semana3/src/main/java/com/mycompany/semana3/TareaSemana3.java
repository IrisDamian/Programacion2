/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.semana3;

import java.util.Scanner;

/**
 *
 * @author Iris Damian
 */
public class TareaSemana3 {
    private static String[][] comi = new String[5][6];
    private static int [][] sumf = new  int[5][6];
    private static int [][] sumc = new  int[5][6];
    private static int [][] matriz = new  int[5][6];    
    private static  final int nom = 0;
    private static  final int Enero = 1;
    private static  final int Febrero = 2;
    private static  final int Marzo = 3;
    private static  final int res = 4;
    private static  final int pro = 5;
    private static final int encab = 0;
    private static final int Grant = 4;
    
    
           
    private static void Registro(){
       for (int i = 1; i < comi.length-1; i++) {
          CargaInformacion(i);  
        } 
    }
    
    
    private static void Titulos(){
       comi[encab][nom]="Nombre";
        comi[encab][Enero]="Enero";
        comi[encab][Febrero]="Febrero";
        comi[encab][Marzo]="Marzo";
        comi[encab][res]="Total";
        comi[encab][pro]="Promedio";
        comi[Grant][nom]="TOTAL"; 
    }
    
    
    public static void CargaInformacion(int Fila){
        Scanner lector = new  Scanner(System.in);
        Titulos();
        System.out.println("Escriba el nombre de la persona " +(Fila)+":");
        comi[Fila][nom]=lector.nextLine();
        System.out.println("Escriba el mes 1");
        comi[Fila][Enero]=lector.nextLine();
        System.out.println("Escriba el mes 2");
        comi[Fila][Febrero]=lector.nextLine();
        System.out.println("Escriba el mes 3");
        comi[Fila][Marzo]=lector.nextLine();
        
    }
    
   
    private static void TotalP (){
        for (int i = 1; i < comi.length-1; i++) {
          TotalPersona(i);  
        }
    
    }
    
    
    public static void TotalPersona(int fila){
        for (int i = 1; i < comi.length; i++) {
            int total = 0;
            for (int j = 1; j < comi.length-3; j++) {
                for (int k = 1; k < 4; k++) {
                sumf[j][i]=Integer.parseInt(comi[fila][k]);
                total+=sumf[j][i];
                comi[fila][res]=String.valueOf(total);
                comi[fila][pro]=String.valueOf(total/3);
                }
                
            }
            
        }    
    }
    
   
    private static void SumaGranTotal(){
        for (int i = 1; i < comi.length-1; i++) {
            GranTotal(i);  
        }
    
    }
    
    
    public static void GranTotal(int columnas){
        for (int i = 1; i < comi.length; i++) {
            int total=0,total2=0,total3=0;
            for (int j = 1; j < comi.length-3; j++) {
                for (int k = 1; k < 4; k++) {   
                sumc[j][i]=Integer.parseInt(comi[k][columnas]);
                total+=sumc[j][i];
                comi[Grant][columnas]=String.valueOf(total);
                
                sumc[j][i]=Integer.parseInt(comi[k][res]);
                total2+=sumc[j][i];
                comi[Grant][res]=String.valueOf(total2);
                
                sumc[j][i]=Integer.parseInt(comi[k][pro]);
                total3+=sumc[j][i];
                comi[Grant][pro]=String.valueOf(total3);
                    
                }
            }
            
        }
        
    }
    
    
     public static void ImprimirMatriz(String[][] Matriz) {
        for (int x = 0; x < Matriz.length; x++) {
            System.out.print("|");
            for (int y = 0; y < Matriz[x].length; y++) {
                System.out.print(Matriz[x][y]);
                if (y != Matriz[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }
   
     
     public static void MesTotalMayor(int columna,String mes){
         String NombreCliente="";
         int NumMayor=comi.length;
         
         for (int i = 1; i < comi.length-1; i++) {
             int Mayor=0;
            sumf[i][columna]=Integer.parseInt(comi[i][columna]);
            if(NumMayor < sumf[i][columna]){
                NumMayor=sumf[i][columna];
            }
           matriz[1][columna]=Integer.parseInt(comi[1][columna]);
           matriz[2][columna]=Integer.parseInt(comi[2][columna]);
           matriz[3][columna]=Integer.parseInt(comi[3][columna]);
            
           if(matriz[1][columna]> matriz[2][columna]&&matriz[1][columna]> matriz[3][columna]){
               Mayor=1;
               NombreCliente=comi[Mayor][nom];
           }
           if(matriz[2][columna]> matriz[1][columna]&&matriz[2][columna]> matriz[3][columna]){
               Mayor=2;
               NombreCliente=comi[Mayor][nom];
           }
           if(matriz[3][columna]> matriz[1][columna]&&matriz[3][columna]> matriz[2][columna]){
               Mayor=3;
               NombreCliente=comi[Mayor][nom];
           }     
        }
         if(mes=="1"){
         System.out.println("La mayor cantidad es de Q"+NumMayor);
         System.out.println("Su nombre es "+NombreCliente);
         System.out.println("\n");
         }
         else{
         System.out.println("Mayor venta es " + mes + " de Q"+NumMayor);
         System.out.println("Su nombre es "+NombreCliente);
         System.out.println("\n");  
         }
         
         
    }
      
   
     public static void MesTotalMenor(int columna,String mes){
       String NombreCliente="";
         int NumMenor=comi.length;

         for (int i = 1; i < comi.length-1; i++) {
             int Menor=0;
            sumf[i][columna]=Integer.parseInt(comi[i][columna]);
            if(NumMenor > sumf[i][columna]){
                NumMenor=sumf[i][columna];
            }
           matriz[1][columna]=Integer.parseInt(comi[1][columna]);
           matriz[2][columna]=Integer.parseInt(comi[2][columna]);
           matriz[3][columna]=Integer.parseInt(comi[3][columna]);
            
           if(matriz[1][columna]< matriz[2][columna]&&matriz[1][columna]< matriz[3][columna]){
               Menor=1;
               NombreCliente=comi[Menor][nom];
           }
           if(matriz[2][columna]< matriz[1][columna]&&matriz[2][columna]< matriz[3][columna]){
               Menor=2;
               NombreCliente=comi[Menor][nom];
           }
           if(matriz[3][columna]< matriz[1][columna]&&matriz[3][columna]< matriz[2][columna]){
               Menor=3;
               NombreCliente=comi[Menor][nom];
           }     
        }
         System.out.println("Menor venta es " + mes + " de Q"+NumMenor);
         System.out.println("Su nombre es "+NombreCliente);
         System.out.println("\n");     
         
     }
     
     
     public static void Modificar(){
         Scanner lector = new  Scanner(System.in);
         int colummna=0,fila=0;
         String valor="";
         
         
         System.out.println("¿En que numero de columna esta el dato?\n"
                 + "0. Modificar nombre de la persona\n"
                 + "1. Modificar cantidad de enero\n"
                 + "2. Modificar cantidad de febrero\n"
                 + "3. Modificar cantidad de marzo");
         colummna =lector.nextInt();
         System.out.println("¿En que numero de fila esta el dato?\n"
                 + "1. Modificar fila 1\n"
                 + "2. Modificar fila 2\n"
                 + "3. Modificar fila 3");
         fila =lector.nextInt(); 
         System.out.println("Escriba valores nuevos");
         valor=lector.nextLine();
         valor=lector.nextLine();
          for (int i = 1; i < comi.length-1; i++) {
              comi[fila][colummna]=valor;
          }
     }
    
     
     public static void Busqueda(){
        Scanner lector = new  Scanner(System.in);
        String Busqueda[]=new String[2];
        int cantbusqueda;
      
         System.out.println("Escriba la cantidad deseada a buscar");
         cantbusqueda=lector.nextInt();
         for (int i = 1; i < comi.length-1; i++) {
             
             if(Integer.parseInt(comi[i][Enero])==cantbusqueda){
                 Busqueda[0]=comi[i][nom];
                 Busqueda[1]="Enero";
             }
             
             if(Integer.parseInt(comi[i][Febrero])==cantbusqueda){
                 Busqueda[0]=comi[i][nom];
                 Busqueda[1]="Febrero";
             }
             
             if(Integer.parseInt(comi[i][Marzo])==cantbusqueda){
                 Busqueda[0]=comi[i][nom];
                 Busqueda[1]="Marzo";
             }  
         }
             System.out.println("Persona que vendio fue: " +Busqueda[0]);
             System.out.println("Mes en el  que vendio fue:  " +Busqueda[1]);
  
     }
     
     public static void main(String[] args) {
       Scanner lector = new  Scanner(System.in);
       int opcion=0;
       int seguir=1;
       
       while(seguir==1){
       System.out.println("MENU DE OPCIONES\n"
               + "1. Ingreso de informacion\n"
               + "2. Consultar quien vendio mas y quien vendio menos en la venta\n"
               + "3. Cosultar quien vendio mas en los 3 meses\n"
               + "4. Editar datos\n"
               + "5. Busqueda por cantidad\n"
               + "6. Tabla de matriz\n"
               + "7. Salir");
      opcion=lector.nextInt();
      
      switch(opcion){
          
          case 1:
              Registro();
              TotalP();
              SumaGranTotal();
              System.out.println("\n");
              ImprimirMatriz(comi);
              break;
          case 2:
              MesTotalMayor(Enero,"Enero");
              MesTotalMayor(Febrero,"Febrero");
              MesTotalMayor(Marzo,"Marzo");
              MesTotalMenor(Enero,"Enero");
              MesTotalMenor(Febrero,"Febrero");
              MesTotalMenor(Marzo,"Marzo");
              break;
          case 3:
              MesTotalMayor(res,"1");
              break;
          case 4:
              ImprimirMatriz(comi);
              System.out.println("\n");
              Modificar();
              TotalP();
              SumaGranTotal();
              System.out.println("Se realizo el cambio");
              break;
          case 5:
              Busqueda();
              break;
          case 6:
              ImprimirMatriz(comi);
              break;
          case 7:
              System.exit(0);
              break;
          default: 
              System.out.println("Opcion incorrecta");
              break;   
      }
       System.out.println("\n");
       System.out.println("Deseas volver a iniciar");
       System.out.println("Presiona el  1 - para iniciar");
       System.out.println("Presiona el  0 - para poder salir");
       seguir=lector.nextInt();
       System.out.println("\n");
       
     
        
    }
    
   }
}

