/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import DOMINIO.MDEMPLEADO;
import EXCEPCIONES.ACCESODATOS;
import EXCEPCIONES.ESCRITURADATOS;
import EXCEPCIONES.LECTURADATOS;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iris Damian
 */
public class ACCESODATOSIMPL implements ACCESOADATOS{

    @Override
    public boolean existe(String nombreArchivo) throws ACCESODATOS {
       File archivo = new File(nombreArchivo);
        return archivo.exists(); 
    }

    @Override
    public List<MDEMPLEADO> listar(String nombreArchivo) throws LECTURADATOS {
      MDEMPLEADO E = new MDEMPLEADO();
        List<MDEMPLEADO> Regresar = new ArrayList<MDEMPLEADO>();
        List<String> Almacenamiento = new ArrayList();
        
        try {
           BufferedReader entrada = null; 
            File archivo = new File(nombreArchivo);
            entrada = new BufferedReader(new FileReader(archivo));
            String Linea;
            while((Linea = entrada.readLine()) != null){
                Almacenamiento.add(Linea);
            }   
            entrada.close();
            
             for(String D:Almacenamiento){
                String[]Datos = D.split(";");
                E.setNombre(Datos[0]);
                E.setEnero(Double.parseDouble(Datos[1]));
                E.setFebrero(Double.parseDouble(Datos[2]));
                E.setMarzo(Double.parseDouble(Datos[3]));
                E.setVentasTotales(Double.parseDouble(Datos[4]));
                E.setPromedio(Double.parseDouble(Datos[5]));
                Regresar.add(E);
                E = new MDEMPLEADO();               
            }   
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) { 
            ex.printStackTrace(System.out);
        }
        return Regresar;   
    }

    @Override
    public void escribir(String Info, String nombreArchivo, boolean anexar) throws ESCRITURADATOS {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(Info);
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }

    @Override
    public void crear(String nombreArchivo) throws ACCESODATOS {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            System.out.println("CREADO UN NUEVO ARCHIVO");
            salida.close();
          } catch (IOException ex) {
            Logger.getLogger(ACCESODATOSIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            salida.close();
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws ACCESODATOS {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("UPS SE BORRO EL ARCHIVO");
    }
    }
   

    