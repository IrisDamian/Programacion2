/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDATOS;

import DOMINIO.mdEMPLEADO;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Iris Damian
 */
public class CONEXIONJDBC {
    private static final String SQL_SELECT="SELECT * FROM tb_comisiones;";
    private static final String SQL_INSERT="insert into tb_comisiones(nombre,enero,febrero,marzo,total,promedio) values(?,?,?,?,?,?);";
    private static final String SQL_DELETE="delete from tb_comisiones where codigo=";
    private static final String SQL_UPDATE ="update tb_comisiones set nombre=?,enero=?,febrero=?,marzo=?,total=?,promedio=? where codigo=?;";
    
    public List<mdEMPLEADO> SeleccionarInformacion(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        mdEMPLEADO C = null;
        List<mdEMPLEADO> comisiones = new ArrayList<mdEMPLEADO>();
        
        try {
            conn = CONEXION.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int Codigo = rs.getInt("codigo");
                String Nombre = rs.getString("nombre");
                Double Enero = rs.getDouble("enero");
                Double Febrero = rs.getDouble("febrero");
                Double Marzo = rs.getDouble("marzo");
                Double Total = rs.getDouble("total");
                Double Promedio = rs.getDouble("promedio");
                C = new mdEMPLEADO();
                C.setCodigo(Codigo);
                C.setNombre(Nombre);
                C.setEnero(Enero);
                C.setFebrero(Febrero);
                C.setMarzo(Marzo);
                C.setVentasTotales(Total);
                C.setPromedio(Promedio);
                comisiones.add(C);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            CONEXION.CloseConnection(conn);
            CONEXION.CloseResul(rs);
            CONEXION.CloseStatement(stmt);
        }
        return comisiones;
    }
    
    public int IngresarEmpleado(mdEMPLEADO empleado){
        int rows = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn=CONEXION.getConnection();
            stmt=conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getNombre());
            stmt.setDouble(2, empleado.getEnero());
            stmt.setDouble(3, empleado.getFebrero());
            stmt.setDouble(4, empleado.getMarzo());
            stmt.setDouble(5, empleado.getVentasTotales());
            stmt.setDouble(6, empleado.getPromedio());
            rows=stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            CONEXION.CloseConnection(conn);
            CONEXION.CloseStatement(stmt);
        }
        return rows;
    }

    public String VentaMayor(String mes, String vm){
        String total = "";
        String nom = "";
        Double tot = 0.0;
        int rows = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = CONEXION.getConnection();
            stmt = conn.prepareStatement("select nombre,"+mes +" from tb_comisiones where "+ mes+"=(select max("+mes+") from tb_comisiones);");
            rs = stmt.executeQuery();
            while(rs.next()){
                nom = rs.getString("nombre");
                tot = rs.getDouble(mes);
                
                total+=("La persona  es: "+nom+" Su venta es:"+tot);
            }        
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            CONEXION.CloseConnection(conn);
            CONEXION.CloseResul(rs);
            CONEXION.CloseStatement(stmt);
        }
        return total;
    }
    public String VentaMenor(String mes, String vm){
        String total = "";
        String nom = "";
        Double tot = 0.0;
        int rows = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = CONEXION.getConnection();
            stmt = conn.prepareStatement("select nombre,"+mes +" from tb_comisiones where "+ mes+"=(select min("+mes+") from tb_comisiones);");
            rs = stmt.executeQuery();
            while(rs.next()){
                nom = rs.getString("nombre");
                tot = rs.getDouble(mes);
                
                total+=("La persona  es: "+nom+" Su venta es:"+tot);
            }        
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            CONEXION.CloseConnection(conn);
            CONEXION.CloseResul(rs);
            CONEXION.CloseStatement(stmt);
        }
        return total;
    }
    

    public String VentaTotal(String total){
        String nom = "";
        String r = "";
        Double tot = 0.0;
        int rows = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = CONEXION.getConnection();
            stmt = conn.prepareStatement("select nombre,"+total +" from tb_comisiones where "+ total+"=(select max("+total+") from tb_comisiones);");
            rs = stmt.executeQuery();
            while(rs.next()){
                nom = rs.getString("nombre");
                tot = rs.getDouble(total);
            } 
            r = ("Su nombre es: " + nom + tot);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            CONEXION.CloseConnection(conn);
            CONEXION.CloseResul(rs);
            CONEXION.CloseStatement(stmt);
        }
        return r;
    }

}
