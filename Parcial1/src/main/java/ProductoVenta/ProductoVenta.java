/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductoVenta;

import java.util.Scanner;

/**
 *
 * @author Iris Damian
 */
public class ProductoVenta {
    private int Cant;
    private String Nom;
    private Double Pre;
    private Double Pe;
    
    public int getCant() {
        return Cant;
    }

    public void setCant(int Cant) {
        this.Cant = Cant;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public Double getPre() {
        return Pre;
    }

    public void setPre(Double Pre) {
        this.Pre = Pre;
    }

    public Double getPe() {
        return Pe;
    }

    public void setPe(Double Pe) {
        this.Pe = Pe;
    }
    
    public void CargarInfo(int N){
        Scanner Lector = new  Scanner(System.in);
        System.out.println("Producto Numero: "+(N+1)+": ");
        System.out.println("Escribe cantidad de productos:"+(N+1)+": ");
        setCant(Lector.nextInt());
        System.out.println("Escribe el nombre de productos: "+(N+1)+": ");
        setNom(Lector.nextLine());
        setNom(Lector.nextLine());
        System.out.println("Escribe el precio unitario: "+(N+1)+": ");
        setPre((Double) Lector.nextDouble());
        System.out.println("Escribe el peso de productos: "+(N+1)+": ");
        setPe((Double) Lector.nextDouble());
    }
}

