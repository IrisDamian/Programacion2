/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import BDatos.CONEXIONJDBC;
import DOMINIO.mdEMPLEADO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Iris Damian
 */
public class CATNEGOCIO {
    Scanner Lec = new Scanner(System.in);
    mdEMPLEADO c = new  mdEMPLEADO();
    CONEXIONJDBC comision = new CONEXIONJDBC();
    
    public void Ingresar(){
       System.out.println("Escribe la cantidad de personas: ");
        int cant = Lec.nextInt(); 
        for(int i=0; i<cant; i++){
          Double ENE = 0.0, FEB = 0.0, MAR = 0.0, PROM = 0.0;
          System.out.println("Escribe el nombre");
          c.setNombre(Lec.nextLine());
          c.setNombre(Lec.nextLine());
          System.out.println("Escribe el total de enero");
          ENE = Lec.nextDouble();
          c.setEnero(ENE);
          System.out.println("Escrine el total de  febrero");
          FEB = Lec.nextDouble();
          c.setFebrero(FEB);
          System.out.println("Escribe el  total de  marzo");
          MAR = Lec.nextDouble();
          c.setMarzo(MAR);
          c.setVentasTotales(ENE + FEB + MAR);
          PROM =(ENE + FEB + MAR)/3;
          c.setPromedio(PROM);
          comision.IngresarEmpleado(c);
        }
        System.out.println("Genial ya se  ingresaron los datos");
    }

    public void Imprimir(){
        List< mdEMPLEADO> Imprimir = comision.SeleccionarInformacion();
        for ( mdEMPLEADO C : Imprimir) {
            System.out.println("Empleado" +C);       
        }
    }

    public void VentaMay(){
        comision.VentaMayor("Enero");
        comision.VentaMayor("Febrero");
        comision.VentaMayor("Marzo");
    }   

    public void VentaMen(){
        comision.VentaMenor("Enero");
        comision.VentaMenor("Febrero");
        comision.VentaMenor("Marzo");
    }

    public void VentaMayorT(){
        comision.VentaMayor("Total");  
    }

    public void BorrarEmpleado(){
        List< mdEMPLEADO> Imprimir=comision.SeleccionarInformacion();
        for ( mdEMPLEADO CO : Imprimir) {
            System.out.println("Codigo "+CO.getCodigo()+" Nombre "+CO.getNombre()+" Promedio "+CO.getPromedio());
        }
        System.out.println("Escribe el codigo del empleado ");
        int Cod = Lec.nextInt();
        comision.Borrar(Cod);
        System.out.println("ups el data se ha eliminado");
    }

    public void EditarNom(){
        String Cod = "";
        List< mdEMPLEADO> Imprimir = comision.SeleccionarInformacion();
        for ( mdEMPLEADO CO : Imprimir) {
            System.out.println("Codigo "+CO.getCodigo()+" Nombre "+CO.getNombre());
        }
            System.out.println("Escribe el codigo del empleado");
            Cod = Lec.nextLine();
            Cod = Lec.nextLine();
            System.out.println("Escribe el nuevo nombre ");
            String Nombre=Lec.nextLine();
            comision.EditarNombre("nombre","'"+Nombre+"'", Cod);
    }

    public void EditarCan(){
        String Cod = "", Col = "";
        Double Cant1 = 0.0, Cant2 = 0.0, Cant3 = 0.0;
        Double S = 0.0, P = 0.0;
        List< mdEMPLEADO> Imprimir = comision.SeleccionarInformacion();
        System.out.println("Escribe el mes\n"
                + "1 ENERO\n"
                + "2 FEBRERO\n"
                + "3 MARZO");
        int op = Lec.nextInt();

        if (op==1) {
            for ( mdEMPLEADO CO : Imprimir) {
                System.out.println("Codigo "+CO.getCodigo()+" Nombre "+CO.getNombre()+" Ventas Enero Q"+CO.getEnero());   
            }
            System.out.println("\nEscribe el codigo del empleado");
            Cod = Lec.nextLine();
            Cod = Lec.nextLine();
            System.out.println("Escribe la  nueva cantidad");
            Cant1 = Lec.nextDouble();
            Col = "enero";
            for ( mdEMPLEADO md : Imprimir) {
                if (md.getCodigo()==(Integer.parseInt(Cod))) {
                    Cant2 = md.getFebrero();
                    Cant3 = md.getMarzo();                  
                }
            }    
        }

        else if (op==2) {
            for ( mdEMPLEADO CO : Imprimir) {
                System.out.println("Codigo "+CO.getCodigo()+" Nombre "+CO.getNombre()+" Ventas Febrero Q"+CO.getFebrero());   
            }
            System.out.println("\nEscribe el codigo del empleado");
            Cod = Lec.nextLine();
            Cod = Lec.nextLine();
            System.out.println("Escribe la nueva cantidad");
            Cant1 = Lec.nextDouble();
            Col = "febrero";
            for ( mdEMPLEADO md : Imprimir) {
                if (md.getCodigo()==(Integer.parseInt(Cod))) {
                    Cant2 = md.getEnero();
                    Cant3 = md.getMarzo();                  
                }
            }    
        }

        else if (op==3) {
            for ( mdEMPLEADO CO : Imprimir) {
                System.out.println("Codigo "+CO.getCodigo()+" Nombre "+CO.getNombre()+" Ventas Marzo Q"+CO.getMarzo());   
            }
            System.out.println("\nEscribe el codigo del empleado");
            Cod = Lec.nextLine();
            Cod = Lec.nextLine();
            System.out.println("Escribe la nueva cantidad");
            Cant1 = Lec.nextDouble();
            Col = "marzo";
            for ( mdEMPLEADO md : Imprimir) {
                if (md.getCodigo()==(Integer.parseInt(Cod))) {
                    Cant2 = md.getEnero();
                    Cant3 = md.getFebrero();                  
                }
            }    
        }
        S = Cant1 + Cant2 + Cant3;
        P = S/3;
        comision.EditarCantidad(Col, Cod, Cant1, S, P);
    }
    
    public void Busqueda(){
        System.out.println("Escribe la cantidad que quieres encontrar ");
        Double b = Lec.nextDouble();
        comision.Buscar(b);
    }
}
