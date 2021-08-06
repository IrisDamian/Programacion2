/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductoCalculo;

import ProductoVenta.ProductoVenta;
import java.text.DecimalFormat;

/**
 *
 * @author Iris Damian
 */
public class ProductoCalculo {
    
    private String [][] TablaNo1;
    private final int E = 0;
    private final int Cant = 0;
    private final int Nom = 1;
    private final int Pre = 2;
    private final int Pe = 3;
    private int F = 1;
    private final int MaC1 = 4;
       
    private String [][] TablaNo2;
    private final int GasV = 3;
    private final int GasP = 4;
    private final int CosU = 5;
    private final int CosT = 6;
    private final int MaC2 = 7;

    double SuP = 0.0;
    double Supes = 0.0;
    double CoeG = 0.0;
    double CoeP = 0.0;
    double SuT = 0.0;
    
    public  void Crear1(int f){
        TablaNo1 = new String[f+1][MaC1];
        TablaNo1[E][Cant]="CANT:";
        TablaNo1[E][Nom]="NOMB:";
        TablaNo1[E][Pre]="PREC:";
        TablaNo1[E][Pe]="PESO";
    } 

    public void Agregar1(ProductoVenta Pro){
        TablaNo1[F][Cant]=Pro.getCant()+"";
        TablaNo1[F][Nom]=Pro.getNom();
        TablaNo1[F][Pre]=Pro.getPre()+"";
        TablaNo1[F][Pe]=Pro.getPe()+"";
        F++;           
    }
  
    public void Imprimir1(){
       for (int i=0; i<TablaNo1.length; i++) {
            System.out.print("|");
            for (int x=0; x<TablaNo1[i].length; x++) {
                System.out.print(TablaNo1[i][x]);
                if (x != TablaNo1[i].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    
    }

    public Double CoeGP(int f, double g, double p){
        int fi = f+1;
        for (int i=1; i<fi; i++) {
           SuP+=Double.valueOf(TablaNo1[i][Cant])*Double.valueOf(TablaNo1[i][Pre]);
           Supes+=Double.valueOf(TablaNo1[i][Cant])*Double.valueOf(TablaNo1[i][Pe]);
        }
        CoeG = g/SuP;
        CoeP = p/Supes;
        return SuP;      
    }

    public  void Crear2(int f){
        TablaNo2= new String[f+1][MaC2];
        TablaNo2[E][Cant]="CANT:";
        TablaNo2[E][Nom]="NOMB:";
        TablaNo2[E][Pre]="PREC:";
        TablaNo2[E][GasV]="GASV:";
        TablaNo2[E][GasP]="GASP:";
        TablaNo2[E][CosU]="COSU:";
        TablaNo2[E][CosT]="COST:";     
    } 

    public Double Agregar2(int f){
       int fi = f+1;
       DecimalFormat formato = new DecimalFormat("#.##");
        for (int i=1; i<fi; i++) {
           TablaNo2[i][Cant]=TablaNo1[i][Cant];
           TablaNo2[i][Nom]=TablaNo1[i][Nom];
           TablaNo2[i][Pre]=TablaNo1[i][Pre]; 
           TablaNo2[i][GasV]=(formato.format(Double.valueOf(TablaNo1[i][Pre])*CoeG))+"";
           TablaNo2[i][GasP]=(formato.format(Double.valueOf(TablaNo1[i][Pe])*CoeP))+"";
           TablaNo2[i][CosU]=(formato.format(Double.valueOf(TablaNo1[i][Pre])+Double.valueOf(TablaNo2[i][GasV])+Double.valueOf(TablaNo2[i][GasP])))+"";
           TablaNo2[i][CosT]=(formato.format(Double.valueOf(TablaNo2[i][Cant])*Double.valueOf(TablaNo2[i][CosU])))+"";
           SuT+=Double.valueOf(TablaNo2[i][CosT]);
        } 
        return SuT;      
    }

    public void Imprimir2(){
       for (int i=0; i<TablaNo2.length; i++) {
            System.out.print("|");
            for (int x=0; x<TablaNo2[i].length; x++) {
                System.out.print(TablaNo2[i][x]);
                if (x != TablaNo2[i].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }  
    }
}

