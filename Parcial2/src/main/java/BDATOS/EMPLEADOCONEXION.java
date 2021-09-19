/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDATOS;

import DOMINIO.mdUSUARIO;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Iris Damian
 */
public class EMPLEADOCONEXION {
    private static final String SQL_SELECT ="SELECT * from tb_usuarios";
    private static final String SQL_INSERT ="INSERT into tb_usuarios(usuario,contraseña) values(?,?)";
    private static final String SQL_DELETE ="DELETE from tb_usuarios where id=";
    private static final String SQL_UPDATE ="UPDATE tb_usuarios set usuario=?,contraseña=? where id=?";
    

    public List<mdUSUARIO> Select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        mdUSUARIO u = null;
        List<mdUSUARIO> us = new ArrayList<mdUSUARIO>();
        try {
            conn = CONEXION.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                u = new mdUSUARIO();
                u.setid(id);
                u.setusuario(usuario);
                u.setcontraseña(contraseña);
                us.add(u);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            CONEXION.CloseConnection(conn);
            CONEXION.CloseStatement(stmt);
            CONEXION.CloseResul(rs);
        }

        return us;
    }
    public int Insert(mdUSUARIO usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = CONEXION.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getusuario());
            stmt.setString(2, usuario.getcontraseña());
            System.out.println("En ejecucion " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Se esta trabajando " + rows);
            if (rows >= 1) {
                System.out.println("Se esta trabajando " + rows);
            } else {
                System.out.println("Ups sucedio un error ");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            CONEXION.CloseConnection(conn);
            CONEXION.CloseStatement(stmt);
        }

        return rows;
    }

    public int Update(mdUSUARIO usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = CONEXION.getConnection();
            System.out.println("En ejecucion " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getusuario());
            stmt.setString(2, usuario.getcontraseña());
            stmt.setInt(3, usuario.getid());

            rows = stmt.executeUpdate();
            if (rows >= 1) {
                System.out.println("Se esta trabajando " + rows);
            } else {
                System.out.println("Ups sucedio un error");
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            CONEXION.CloseConnection(conn);
            CONEXION.CloseStatement(stmt);
        }

        return rows;
    }

    public int Delete(mdUSUARIO usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = CONEXION.getConnection();
            System.out.println("En Ejecucion " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getid());
            rows = stmt.executeUpdate();
            if (rows >= 1) {
                System.out.println("Se esta trabajando " + rows);
            } else {
                System.out.println("Ups sucedio un error");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            CONEXION.CloseConnection(conn);
            CONEXION.CloseStatement(stmt);  
        }
        return rows;
    }
}
