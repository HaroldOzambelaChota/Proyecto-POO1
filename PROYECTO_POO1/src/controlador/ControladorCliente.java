/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Conexion.DBManager;
import Modelo.Cliente;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author HAROLD
 */
public class ControladorCliente {
    public static int registrarCliente(Cliente cliente ){
        Connection conn=null;
        DBManager db=new DBManager();
        PreparedStatement pstm=null;
        String sqlInsert="insert into cliente(dniC,nombreC,direccionC) values(?,?,?)";
        conn=db.getConexion();
        int numeroInsertado=0;
        try {
            pstm=conn.prepareStatement(sqlInsert);
            pstm.setString(1, cliente.getDni());
            pstm.setString(2, cliente.getNombtre());
            pstm.setString(3, cliente.getDireccion());
            numeroInsertado=pstm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Se registro");
           
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return numeroInsertado;
    }
    public static String generarCodigo(){
        int codigo=0;
        Cliente c;
        DBManager db=new DBManager();
        Connection conn= db.getConexion();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        String codigoG = "";
        String sqlSelect="select * from cliente order by idCliente";
        
        try {
             pstm = conn.prepareStatement(sqlSelect);
             rs = pstm.executeQuery();
          
             rs.afterLast();
             
             if(rs.previous()){         
                 c= new Cliente(rs.getInt(1));
                 codigo=c.getIdCliente();
                 codigo++;
                if(codigo<10){
                     codigoG="000"+codigo;
                 }
                else{ 
                     codigoG+="00"+codigo;
                }
                
             }else{
                 codigoG="0000";
             }
             } catch (Exception e) {
                 e.printStackTrace(System.out);
             }
        return codigoG;
     }
    
    public static boolean buscarCliente(Cliente cliente, JTextField txtNombbre) {
        Connection conn;
        boolean encontrado = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBManager db = new DBManager();
        String buscar = "select nombreC from cliente where dniC=?";

        conn = db.getConexion();
        try {
            ps = conn.prepareStatement(buscar);
            ps.setString(1, cliente.getDni());

            rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setNombtre(rs.getString(1));
                txtNombbre.setText(cliente.getNombtre());
                encontrado = true;
                txtNombbre.setEditable(false);

            } else {
                encontrado = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return encontrado;
    }
    public static Cliente buscarClienteget(Cliente cliente, JTextField txtNombbre) {
        Connection conn;
        boolean encontrado = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBManager db = new DBManager();
        String buscar = "select idCliente,nombreC from cliente where dniC=?";

        conn = db.getConexion();
        try {
            ps = conn.prepareStatement(buscar);
            ps.setString(1, cliente.getDni());

            rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNombtre(rs.getString(2));
                txtNombbre.setText(cliente.getNombtre());
                encontrado = true;
                txtNombbre.setEditable(false);

            } else {
                encontrado = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return cliente;
    }
}
