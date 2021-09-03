/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import DOMINIO.MDEMPLEADO;
import EXCEPCIONES.*;
import java.util.*;

/**
 *
 * @author Iris Damian
 */
public interface ACCESOADATOS {
    boolean existe(String nombreArchivo) throws ACCESODATOS;
    public List<MDEMPLEADO> listar(String nombreArchivo) throws LECTURADATOS;
    void escribir(String Info, String nombreArchivo, boolean anexar)throws ESCRITURADATOS;
    public void crear(String nombreArchivo)throws ACCESODATOS;
    public void borrar(String nombreArchivo)throws ACCESODATOS;
}
