/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DATOS.ACCESOADATOS;
import DATOS.ACCESODATOSIMPL;
import DOMINIO.MDEMPLEADO;
import EXCEPCIONES.ACCESODATOS;
import EXCEPCIONES.LECTURADATOS;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Iris Damian
 */
public class CATEMPLEADOSIMPLEMENTAR implements CATEMPLEADOS {
List<MDEMPLEADO> C = new ArrayList<MDEMPLEADO>();
    Scanner Lector = new Scanner(System.in);
    double SEnero, SFebrero,SMarzo;
    
    private final ACCESOADATOS A;
    
    public CATEMPLEADOSIMPLEMENTAR (){
        this.A = new ACCESODATOSIMPL();
    }
    @Override
    public void AgregarInformacion(String Info, String nombreArchivo) {
        boolean anexar = false;
        try {
            anexar = A.existe(nombreArchivo);
            A.escribir(Info,nombreArchivo, anexar);
        } catch (ACCESODATOS ex) {
            System.out.println("UPS HAY UN ERROR");
            ex.printStackTrace();
        }
    }

    @Override
    public void IniciarArchivo(String nombreArchivo) {
        try {
            if(A.existe(nombreArchivo)){
                A.borrar(nombreArchivo);
                A.crear(nombreArchivo);
            } else {
                A.crear(nombreArchivo);
            }
        } catch (ACCESODATOS ex) {
            System.out.println("UPS HAY UN ERROR");
            ex.printStackTrace();
        }
    }

    @Override
    public void CargarInformacion(String nombreArchivo) {
        try {
            C = A.listar(nombreArchivo);
        } catch (LECTURADATOS ex){
            System.out.println("UPS HAY UN ERROR");
            ex.printStackTrace();
        } 
    }

    @Override
    public void Calculos() {
        SEnero = 0.0; SFebrero = 0.0; SMarzo = 0.0;
        for (MDEMPLEADO emp : C){
             SEnero+=emp.getEnero();
             SFebrero+=emp.getFebrero();
             SMarzo+=emp.getMarzo();
             emp.setVentasTotales(emp.getEnero() + emp.getFebrero() + emp.getMarzo());
             emp.setPromedio(emp.getVentasTotales() / 3);
             emp = new MDEMPLEADO();
        } 
    }

    @Override
    public void ImprimirInformacion() {
        System.out.println("\n..NOMBRE..ENERO..FEBRERO..MARZO..TOTAL..PROMEDIO");
        for(MDEMPLEADO emp : C){
            System.out.println(".."+emp.getNombre()+"..Q"+emp.getEnero()+"..Q"+emp.getFebrero()+"..Q"+emp.getMarzo()+"..Q"+emp.getVentasTotales()+"..Q"+emp.getPromedio());     
        }
        System.out.println("\nTOTAL DE VENTAS EN LOS MESES");
        System.out.println("Enero Q"+SEnero);
        System.out.println("Febrero Q"+SFebrero);
        System.out.println("Marzo Q"+SMarzo+"\n");
    }

    @Override
    public void VenME() {
        
        String Ene="", Feb="", Mar="";
         Double ene=1000000000000.0, feb=1000000000000.0, mar=1000000000000.0;
         for (MDEMPLEADO emp : C) {
             if (ene >emp.getEnero()) {
                 ene =emp.getEnero();
                 Ene =emp.getNombre();
             }
             if (feb >emp.getFebrero()) {
                 feb =emp.getFebrero();
                 Feb =emp.getNombre();
             }
             if (mar >emp.getMarzo()) {
                 mar =emp.getMarzo();
                 Mar =emp.getNombre();
             }
         }
         System.out.println("La persona con menor venta de enero es: "+Ene+" total Q"+ene);
         System.out.println("La persona con menor venta de febrero es: "+Feb+" total Q"+feb);
         System.out.println("La persona con menor venta de marzo es: "+Mar+" total Q"+mar);
    }

    @Override
    public void VenMA() {
        String Ene="", Feb="", Mar="";
         Double ene=0.0, feb=0.0, mar=0.0;
         for (MDEMPLEADO emp : C) {
             
             if (ene <emp.getEnero()) {
                 ene =emp.getEnero();
                 Ene =emp.getNombre();
             }
             if (feb <emp.getFebrero()) {
                 feb =emp.getFebrero();
                 Feb =emp.getNombre();
             }
             if (mar <emp.getMarzo()) {
                 mar =emp.getMarzo();
                 Mar =emp.getNombre();
             }
         }
         System.out.println("La persona con mayor venta de enero es: "+Ene+" total Q"+ene);
         System.out.println("La persona con mayor venta de febrero es "+Feb+" total Q"+feb);
         System.out.println("La persona con mayor venta de marzo es: "+Mar+" total Q"+mar);  
    }

    @Override
    public void VenMAT() {
        String Mayor = "";
        Double NumMayor = 0.0;
        for(MDEMPLEADO emp: C){
            if (NumMayor<emp.getVentasTotales()) {
                NumMayor =emp.getVentasTotales();
                Mayor =emp.getNombre();
                
            }
        }
        System.out.println("LA PERSONA QUE TIENE MAYOR VENTA ES: "+Mayor+" total Q"+NumMayor);
    }

    @Override
    public void Edit() {
     int ele=0, ele1=0, a=0, indice=0 ;
        String Name = "";
        double cant = 0.0;
        
        System.out.println("Deseas hacer alguna modificacion\n"
                + "1 Nombre\n"
                + "2 Cantidad");
        ele = Lector.nextInt();
        
        if (ele==1) {
            System.out.println("Cual nombre se modificara ");
             for(MDEMPLEADO emp: C){
                System.out.println("Indice "+a+" = "+emp.getNombre());
                a++;
            }
            System.out.println("Cual es el indice del nombre a modificar ");
            indice=Lector.nextInt();
            System.out.println("Ingresa el nuevo nombre ");
            Name=Lector.nextLine();
            Name=Lector.nextLine();
            C.get(indice).setNombre(Name);
                       
        }
        
        if (ele==2) {
            System.out.println("Que  mes  modificara \n"
                    + "1 Enero\n"
                    + "2 Febrero\n"
                    + "3 Marzo");
            ele1=Lector.nextInt();
            if (ele1==1) {
                for(MDEMPLEADO emp: C){
                    System.out.println("Indice "+a+" = "+emp.getEnero()+" le pertenece a "+emp.getNombre());
                    a++;
                }
            System.out.println("Indique el indice de la cantidad de Enero a modificar ");
            indice=Lector.nextInt();
            System.out.println("Escriba  la nueva cantidad");
            cant=Lector.nextDouble();
            C.get(indice).setEnero(cant);
                
            }
            if (ele1==2) {
               for(MDEMPLEADO emp: C){
                   System.out.println("Indice "+a+" = "+emp.getFebrero()+" le pertenece a "+emp.getNombre());
                    a++; 
                } 
           System.out.println("Indique el indice de la cantidad de Febrero a modificar ");
            indice=Lector.nextInt();
            System.out.println("Escriba la nueva cantidad");
            cant=Lector.nextDouble();
            C.get(indice).setFebrero(cant);
            }
            
            if (ele1==3) {
                for(MDEMPLEADO emp: C){
                   System.out.println("Indice "+a+" = "+emp.getMarzo()+" le pertenece a "+emp.getNombre());
                    a++; 
                }
            System.out.println("Indique el indice de la cantidad de Marzo a modificar ");
            indice=Lector.nextInt();
            System.out.println("Escriba la nueva cantidad");
            cant=Lector.nextDouble();
            C.get(indice).setMarzo(cant);
            }
            Calculos();           
        }     
    }

    @Override
    public void Busqueda() {
        String Nombre = "", Mes = "";
        Double Busqueda = 0.0;
        System.out.println("Escriba dicha cantidad que vendio ");
        Busqueda = Lector.nextDouble();
        for (MDEMPLEADO emp : C) {
             
            if(emp.getEnero()==Busqueda){
                Mes = "Enero";
                Nombre = emp.getNombre();
            }
            
            if(emp.getFebrero()==Busqueda){
                Mes = "Febrero";
                Nombre = emp.getNombre();
            }
            
            if(emp.getMarzo()==Busqueda){
                Mes = "Marzo";
                Nombre = emp.getNombre();
            }
            
        }       
        System.out.println("La persona es: "+Nombre);
        System.out.println("Mes de la venta es: <"+Mes);
    }
    }
    

