/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Conexion.DBManager;
import Modelo.Login;
import Vista.frmMenu;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author HAROLD
 */
public class ControladorLogin {
    
    public static boolean validarUsuario(Login login){
        
        boolean validar = false;
        
            DBManager dbm = new DBManager();
            Connection con = dbm.getConexion();
            Statement st = null;
            ResultSet rs = null;
            PreparedStatement ps = null;
            //Login log=null;
            
            //String sql = "select * from administrador where usuario='"+usu+"' and pass='"+passw+"'";
            String sqlSelect="select * from administrador where usuario=? and pass=?";
        try {
            
            //String sql2 = "selecl * from trabajadores where usuario = ? adn pass = ?";
            //st = con.createStatement();
            //ps = con.prepareStatement(sql);
            //rs = st.executeQuery(sql);
            //rs = ps.executeQuery(sql2);
            //ps.setString(1,usu);
            //ps.setString(2,passw);
            ps=con.prepareStatement(sqlSelect);
            ps.setString(1, login.getUsuario());
            ps.setString(2, login.getPass());
            rs=ps.executeQuery();
            
            if(rs.next()) {
                login.setId(rs.getInt(1));
                String usuario=rs.getString(2);
                String password=rs.getString(3);
    
                JOptionPane.showMessageDialog(null, "Bienvenido "+login.getUsuario());
                validar = true;
               
            }else{
                validar =false;
                }
        } catch (Exception e) {
            System.out.println("error al ingresar al sistema: "+e.getMessage());
            validar=false;
        }
        return validar;
    }
    
    public static int obtenetIdA(JTextField nombre){
        
        int id=0;
        
        Connection con = null;
        DBManager dbm = new DBManager();
        con = dbm.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "select id_admin from administrador where usuario =?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,rs.getString("usuario"));
            
            rs = ps.executeQuery();
            
            while (rs.next()) { 
                
                id = rs.getInt("id_admin");
                return id;
            }
            
        } catch (Exception e) {
        }
        return id;
    }
}
