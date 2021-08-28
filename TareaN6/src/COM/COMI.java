/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Iris Damian
 */
public class COMI {
    
    Scanner Lector=new Scanner(System.in);
    public List<DTCOMISION> Comisiones =new ArrayList<DTCOMISION>();
    
    double SumaEnero,sumaFebrero,SumaMarzo;
    
    
    public DTCOMISION RegistraInformacion(){
        DTCOMISION I=new DTCOMISION(); 
        System.out.println("Escribe la cantidad de personas que quieras ingresar: ");
        int cant=Lector.nextInt();
        for (int i = 0; i <cant; i++) {
            System.out.println("Escriba informacion del cliente:"+(i+1));
            System.out.println("Escriba su nombre:");
            I.setNombre(Lector.nextLine());
            I.setNombre(Lector.nextLine());
            System.out.println("Escriba las  Ventas de  Enero:");
            I.setEnero(Lector.nextDouble());
            System.out.println("Escriba las  Ventas de  Febrero:");
            I.setFebrero(Lector.nextDouble());
            System.out.println("Escriba las Ventas de Marzo:");
            I.setMarzo(Lector.nextDouble());
            Comisiones.add(I);
            I=new DTCOMISION();
        }
        return I;
    
    }
   
    public void Calculos(){
        SumaEnero=0.0;sumaFebrero=0.0;SumaMarzo=0.0;
        for (DTCOMISION C :Comisiones) {
             SumaEnero+=C.getEnero();
             sumaFebrero+=C.getFebrero();
             SumaMarzo+=C.getMarzo();
             C.setVentasTotales(C.getEnero() + C.getFebrero() + C.getMarzo());
             C.setPromedio(C.getVentasTotales() / 3);
             C=new DTCOMISION();
        }
    }
   
    public void ImprimirInformacion(){
        System.out.println("\n---NOMBRE---ENERO---FEBRERO---MARZO---TOTAL---PROMEDIO");
        for(DTCOMISION C :Comisiones){
            System.out.println("---"+C.getNombre()+"---Q"+C.getEnero()+"---Q"+C.getFebrero()+"---Q"+C.getMarzo()+"---Q"+C.getVentasTotales()+"--Q"+C.getPromedio());     
        }
        System.out.println("\nLas Ventas Totales por Meses son las Siguientes:");
        System.out.println("Enero: Q"+SumaEnero);
        System.out.println("Febrero: Q"+sumaFebrero);
        System.out.println("Marzo: Q"+SumaMarzo+"\n");
    }
   
    public void VMM(){
         String E="",F="",M="";
         Double e=0.0,f=0.0,m=0.0;
         for (DTCOMISION C : Comisiones) {
             
             if (e <C.getEnero()) {
                 e=C.getEnero();
                 E=C.getNombre();
             }
             if (f <C.getFebrero()) {
                 f=C.getFebrero();
                 F=C.getNombre();
             }
             if (m <C.getMarzo()) {
                 m=C.getMarzo();
                 M=C.getNombre();
             }
         }
         System.out.println("La Persona con mas venta  en el mes de Enero es: "+E+"con la cantidad de Q"+e);
         System.out.println("La Persona con mas venta en el mes de Febrero es: "+F+"con la cantidad de Q"+f);
         System.out.println("La Persona con mas venta en el mes de  Marzo es: "+M+"con la cantidad de Q"+m);   
     }
 
    public void VMEM(){
        String E="",F="",M="";
         Double e=0.0,f=0.0,m=0.0;
         for (DTCOMISION C : Comisiones) {
             if (e >C.getEnero()) {
                 e=C.getEnero();
                 E=C.getNombre();
             }
             if (f >C.getFebrero()) {
                 f=C.getFebrero();
                 F=C.getNombre();
             }
             if (m >C.getMarzo()) {
                 m=C.getMarzo();
                 M=C.getNombre();
             }
         }
         System.out.println("La Persona con menos venta en el mes de Enero es: "+E+" la cantidad de Q"+e);
         System.out.println("La Persona con menos venta  en el mes de Febrero es: "+F+" la cantidad de Q"+f);
         System.out.println("La Persona con menos venta en el mes Marzo es: "+M+" la cantidad de Q"+m);
    }
  
    public void VM(){
        String M="";
        Double NM=0.0;
        for(DTCOMISION C: Comisiones){
            if (NM<C.getVentasTotales()) {
                NM=C.getVentasTotales();
                M=C.getNombre();
                
            }
        }
        System.out.println("La persona que vendio mas en estos 3 Meses es: "+M+" la cantidad de: Q"+NM);
    }

    public void MR(){
        int e=0,a=0,i=0,e2=0;
        String Name="";
        double NuevaCant=0.0;
        
        System.out.println("Quiere Modificar un Nombre o una Cantidad?\n"
                + "{1} -> Modificar Nombre\n"
                + "{2} -> Modificar Cantidad");
        e=Lector.nextInt();
        
        if (e==1) {
            System.out.println("Escriba el Nombre que Quiere Modificar: ");
            for (DTCOMISION C : Comisiones) {
                System.out.println("Indice: "+a+" = "+C.getNombre());
                a++;
            }
            System.out.println("Escriba el indice del Nombre que Desea Modificar: ");
            i=Lector.nextInt();
            System.out.println("Escribe el nuevo Nombre a Ingresar: ");
            Name=Lector.nextLine();
            Name=Lector.nextLine();
            Comisiones.get(i).setNombre(Name);
            
        }
        
        if (e==2) {
            System.out.println("Escribe el mes donde se encuentra la cantidad a Modificar: \n"
                    + "{1}->Enero\n"
                    + "{2}->Febrero\n"
                    + "{3}->Marzo");
            e2=Lector.nextInt();
            if (e2==1) {
                for(DTCOMISION C: Comisiones){
                    System.out.println("Indice: "+a+" = "+C.getEnero()+" Pertenece a: "+C.getNombre());
                    a++;
                }
            System.out.println("Escribe el indice de la cantidad de Enero que quiere Modificar: ");
            i=Lector.nextInt();
            System.out.println("Escribe la nueva cantidad a Ingresar");
            NuevaCant=Lector.nextDouble();
            Comisiones.get(i).setEnero(NuevaCant);
                
            }
            if (e2==2) {
               for(DTCOMISION C: Comisiones){
                   System.out.println("Indice: "+a+" = "+C.getFebrero()+" Pertenece a: "+C.getNombre());
                    a++; 
                } 
           System.out.println("Escribe el indice de la cantidad de Febrero que quiere Modificar: ");
            i=Lector.nextInt();
            System.out.println("Escribe la nueva cantidad a Ingresar");
            NuevaCant=Lector.nextDouble();
            Comisiones.get(i).setFebrero(NuevaCant);
            }
            if (e2==3) {
                for(DTCOMISION C: Comisiones){
                   System.out.println("Indice: "+a+" = "+C.getMarzo()+" Pertenece a: "+C.getNombre());
                    a++; 
                }
            System.out.println("Escribe el indice de la cantidad de Marzo que quiere Modificar: ");
            i=Lector.nextInt();
            System.out.println("Escribe la nueva cantidad a Ingresar");
            NuevaCant=Lector.nextDouble();
            Comisiones.get(i).setMarzo(NuevaCant);
            }
            Calculos();
                      
        }     
    }
 
    public void Br(){
        String N="",M="";
        Double B=0.0;
        System.out.println("Escribe la cantidad que vendio la persona? ");
        B=Lector.nextDouble();
        for (DTCOMISION C : Comisiones) {
             
            if(C.getEnero()==B){
                M="Enero";
                N=C.getNombre();
            }
            
            if(C.getFebrero()==B){
                M="Febrero";
                N=C.getNombre();
            }
            
            if(C.getMarzo()==B){
                M="Marzo";
                N=C.getNombre();
            }
            
        }
        System.out.println("Su resultado de la Busqueda es: ");
        System.out.println("Nombre de la Persona: "+N);
        System.out.println("Mes que se realizo la venta es: "+M);
    }
}
