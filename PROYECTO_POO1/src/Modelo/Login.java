/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.DBManager;
import Vista.frmLogin;
import Vista.frmMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import sun.security.pkcs11.Secmod;

/**
 *
 * @author MASTER
 */
public class Login {
    
    private int id;
    private String usuario;
    private String pass;

    String us="";
    int resultado=0;

    public Login() {
    }

    public Login(String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
    }

    public Login(int id, String usuario, String pass) {
        this.id = id;
        this.usuario = usuario;
        this.pass = pass;
    }

    public Login(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
    
    
}
