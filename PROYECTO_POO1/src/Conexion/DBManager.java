/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Vista.frmMenu;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MASTER
 */
public class DBManager {
    
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/bdproyecto";
    String user = "root";
    String pass = "";
    
    public Connection getConexion(){
        
        try {
            Class.forName(driver);
            
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("error al conectar: "+e.getMessage());
        }
        return null;
    }
}
