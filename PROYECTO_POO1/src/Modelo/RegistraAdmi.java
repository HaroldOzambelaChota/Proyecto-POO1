/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.DBManager;
import Vista.frmMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author MASTER
 */
public class RegistraAdmi {
    
    private String usuAdmi;
    private String passAdmi;

    public RegistraAdmi() {
    }

    public RegistraAdmi(String usuAdmi, String passAdmi) {
        this.usuAdmi = usuAdmi;
        this.passAdmi = passAdmi;
    }

    public String getUsuAdmi() {
        return usuAdmi;
    }

    public void setUsuAdmi(String usuAdmi) {
        this.usuAdmi = usuAdmi;
    }

    public String getPassAdmi() {
        return passAdmi;
    }

    public void setPassAdmi(String passAdmi) {
        this.passAdmi = passAdmi;
    }
    
    
    public void registrarAdmin(String usu,String passA){
        
        DBManager dbm = new DBManager();
        Connection con = dbm.getConexion();
        Statement st = null;
        PreparedStatement ps=null;
        //ResultSet rs = null;
        
        
        try {
//            String sql = "insert into administrador values(0,usuario='"+usu+"',"
//                + "pass='"+passA+"')";
//            st = con.createStatement();
//            st.executeUpdate(sql);
            
            String sql2 = "insert into administrador(usuario,pass) values(?,?)";
            ps = con.prepareStatement(sql2);
            ps.setString(1, usu);
            ps.setString(2, passA);
            ps.execute();
            
            JOptionPane.showMessageDialog(null,"Se Registro Nuevo Administrador");
            Login lg = new Login();
            frmMenu.txtMosUsuario.setText(lg.us);
            
        } catch (Exception e) {
            System.out.println("Error al registrar administrador: "+e.getMessage());
        }
    }
    
    
}
