/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDATOS;

import DOMINIO.mdEMPLEADO;
import DOMINIO.mdUSUARIO;
import java.sql.*;

/**
 *
 * @author Iris Damian
 */
public class USUARIOCONEXION {
    public boolean validar (mdUSUARIO U){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        boolean P=false;
        try {
            conn = CONEXION.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM dbcomisiones.tb_usuarios where usuario = '"+U.getusuario()+"' and contraseña = '"+U.getcontraseña()+"';");
            rs=stmt.executeQuery();
            
            while (rs.next()) {
                    P=true;
            }      
        } 
        
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            CONEXION.CloseConnection(conn);
            CONEXION.CloseResul(rs);
            CONEXION.CloseStatement(stmt);
        }
        return P;
    }
}
