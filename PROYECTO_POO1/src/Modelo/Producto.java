/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.DBManager;
import Vista.frmAgregarPro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sun.security.pkcs11.Secmod;

/**
 *
 * @author ADMIN-PC
 */
public class Producto {

    private int idPro;
    private String nombre;
    private double precio;
    private int stock;
    private String estado;
    static int codigoId =0;
    public Producto() {
     }

    public Producto(int idPro) {
        this.idPro = idPro;
    }

    public Producto(int idPro, String nombre, double precio, int stock, String estado) {
        this.idPro = idPro;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto(int idPro, String nombre, double precio, String estado) {
        this.idPro = idPro;
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
    }
    
    public Producto(String nombre, double precio, int stock, String estado) {
        this.idPro = codigoId;
        frmAgregarPro.txtCodigoP.setText(String.valueOf(codigoId));
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }
    

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

 
    
    
}
