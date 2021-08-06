/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductoProrrateo;

import ProductoCalculo.ProductoCalculo;
import ProductoVenta.ProductoVenta;
import java.util.Scanner;

/**
 *
 * @author Iris Damian
 */
public class ProductoPorrateo {
    public static void main(String[] args) {
    Double SL = 0.0;
    Double Fl = 0.0;
    Double IA = 0.0;
    Double AC = 0.0;
    Double CB = 0.0;
    Double FI = 0.0;
    
        ProductoCalculo PRO = new ProductoCalculo();
        ProductoVenta VEN = new ProductoVenta();
        Scanner Lector= new  Scanner(System.in);
        System.out.println("Escribe dicha cantidad de productos: ");
        int C = Lector.nextInt();
        PRO.Crear1(C);
        for (int i=0; i<C; i++) {
            VEN.CargarInfo(i);
            PRO.Agregar1(VEN);
        }
        PRO.Imprimir1(); 
        System.out.println("\n Escribe el total del seguro local: ");
        SL = Lector.nextDouble();
        System.out.println("Escribe el total de  flete: ");
        Fl = Lector.nextDouble();
        System.out.println("Escribe el total de  aduana: ");
        IA = Lector.nextDouble();
        System.out.println("Escribe el total  de acarreo:");
        AC=Lector.nextDouble();
        System.out.println("Escribe el total  de comision bancaria:");
        CB = Lector.nextDouble();
        Double SUM1 = SL+IA+CB;
        Double SUM2 = Fl+AC;
        Double SUM3 = PRO.CoeGP(C,SUM1,SUM2);
        PRO.Crear2(C);
        FI = PRO.Agregar2(C);
        
        PRO.Imprimir2();
        System.out.println("\nTOTAL "+ FI+"\n");
        System.out.println("FACTURA TOTAL:  "+SUM3+"\n"
                + "TOTAL GASTOS AL MAYOR: "+SUM1+"\n"
                + "TOTAL GASTOS AL PESO:  "+SUM2+"\n"
                + "GRAN TOTAL "+(SUM1+SUM2+SUM3));     
    } 
}

