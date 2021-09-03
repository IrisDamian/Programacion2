/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

/**
 *
 * @author Iris Damian
 */
public interface CATEMPLEADOS {
    public void AgregarInformacion(String Info,String nombreArchivo);
    public void IniciarArchivo(String nombreArchivo);
    public void CargarInformacion(String nombreArchivo);
    public void Calculos();
    public void ImprimirInformacion();
    public void VenME();
    public void VenMA();
    public void VenMAT();
    public void Edit();
    public void Busqueda();
}
