/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Conexion.DBManager;
import Modelo.Detalleventas2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author HAROLD
 */
public class controladorDetalleVenta {
    
    public static ArrayList<Detalleventas2> nota(int id){
        
        Connection con = null;
        DBManager dbm = new DBManager();
        PreparedStatement ps =null;
        ResultSet rs =null;
        ArrayList<Detalleventas2> lista=new ArrayList<>();
        Detalleventas2 dv = null;
        
        String sql = "select idP,cantidad,precioVenta from detalle_venta where idV=? ";
        con=dbm.getConexion();
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery(); 
          
            while (rs.next()) {                
                  dv = new Detalleventas2();
                dv.setIdProduc(rs.getInt(1));
                dv.setCantidad(rs.getInt(2));
                dv.setPrecioVenta(rs.getDouble(3));
                
                lista.add(dv);
            }       
        } catch (Exception e) {
            System.out.println("error lista:"+e.getMessage());
        }
        
        
        return lista;
    }
    
    public static void mostrar(JTextArea txtR){
        
        Connection con = null;
        DBManager dbm = new DBManager();
        PreparedStatement ps =null;
        ResultSet rs =null;
    //    ArrayList<Detalleventas2> lista=new ArrayList<>();
        Detalleventas2 dv = null;
        
        String sql = "select idP,cantidad,precioVenta from detalle_venta  where idV=39";
        con=dbm.getConexion();
        try {
            
            ps = con.prepareStatement(sql);
            //ps.setInt(1, venta);
            rs=ps.executeQuery(); 
            dv = new Detalleventas2();
            while (rs.next()) {                
                dv.setIdProduc(rs.getInt(1));
                dv.setCantidad(rs.getInt(2));
                dv.setPrecioVenta(rs.getDouble(3));
                
                txtR.append(""+dv.getIdProduc()+" "+ dv.getCantidad()+" "+dv.getPrecioVenta()+"\n");
            }       
        } catch (Exception e) {
            System.out.println("error lista:"+e.getMessage());
        }
        
    }
    
}
