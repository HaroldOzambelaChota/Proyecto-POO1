/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Conexion.DBManager;
import Modelo.Producto;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HAROLD
 */
public class ControladorProducto {
   static int resp;
    private static String sql="insert into producto(nombreP,precioP,stockP,estadoP)values (?,?,?,?)"; 
    public static int insertar(Producto producto){
        int insertado=0;
        DBManager dbm = new DBManager();
        Connection con = dbm.getConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,producto.getNombre() );
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setString(4, producto.getEstado());
            insertado=ps.executeUpdate();
         } catch (Exception e) {
            System.out.println("error al agregar producto"+e.getMessage());
        }
            return insertado;
    }
     public static void mostrar(DefaultTableModel modT,JTable tblProducto){
        Object[] reporte= new Object[5];
        Producto producto= null;
        DBManager db=new DBManager();
        Connection conn= db.getConexion();
        PreparedStatement pstm=null;
        ResultSet rs=null;      
        modT= new DefaultTableModel();
 
        String titulo[]={
         "id","nombre","precio","stock","disponibilidad"   
         };
         
        modT.setColumnIdentifiers(titulo);
        
        String sqlSelect="select * from producto";
        try {
            pstm=conn.prepareStatement(sqlSelect);
            rs=pstm.executeQuery();
            while(rs.next()){
                producto=new Producto(rs.getInt(1), rs.getString(2), rs.getDouble(3),rs.getInt(5), rs.getString(4) );
                reporte[0]=producto.getIdPro();
                reporte[1]=producto.getNombre();
                reporte[2]=producto.getPrecio();
                reporte[3]=producto.getStock();
                reporte[4]=producto.getEstado();
                
                modT.addRow(reporte);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        
        }
        tblProducto.setBackground(Color.WHITE);
        tblProducto.setModel(modT);
        tblProducto.getModel();
        
     }
     public static String generarCodigo(){
        int codigo=0;
        Producto producto= null;
        DBManager db=new DBManager();
        Connection conn= db.getConexion();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        String codigoG = "";
        String sqlSelect="select * from producto order by idP";
        
        try {
             pstm = conn.prepareStatement(sqlSelect);
             rs = pstm.executeQuery();
          
             rs.afterLast();
             
             if(rs.previous()){         
                 producto= new Producto(rs.getInt(1));
                 codigo=producto.getIdPro();
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
    public static int eliminar(int codigo){
        int eliminado=0;
        Connection conn=null;
        PreparedStatement pst=null;
        String sqlEliminar="delete from producto where idP=?";
        DBManager db= new DBManager();
        conn=db.getConexion();
        Producto pEliminar= null;
        try {
            pEliminar= new Producto(codigo);
            pst=conn.prepareStatement(sqlEliminar);
            pst.setInt(1, pEliminar.getIdPro());
            eliminado=pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
        }
        return eliminado;
    }

    public static int actualizar(int codigo,String nombre,double precio,String estado,int stock){
            Connection conn=null;
            int actualizado=0;
            PreparedStatement pstm=null;
            String sqlUpdate="update producto set nombreP=?,precioP=?,estadoP=?,stockP=? where idP=?";
            DBManager db= new DBManager();
            Producto actualizaP=null;
            conn=db.getConexion();
            try {
                pstm=conn.prepareStatement(sqlUpdate);
                actualizaP=new Producto(codigo, nombre, precio, stock, estado);
                pstm.setString(1, actualizaP.getNombre());
                pstm.setDouble(2, actualizaP.getPrecio());
                pstm.setString(3, actualizaP.getEstado());
                pstm.setInt(4, actualizaP.getStock());
                pstm.setInt(5, actualizaP.getIdPro());
                actualizado=pstm.executeUpdate();
               
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            
            return actualizado;
        
    }
    public static boolean buscar(JTextField txtNombre,JTextField txtPrecio,JRadioButton rbn,JRadioButton rbn2,JTextField txtStock, int codigo){
        Connection conn=null;
        PreparedStatement pstm=null;
        DBManager db= new DBManager();
        ResultSet res=null;
        Producto buscarP=null;
        String sqlBuscar="select * from producto where idP=? ";
        conn=db.getConexion();
        boolean encontrado=false;
        String rb;
        try {
            
            pstm=conn.prepareStatement(sqlBuscar);
            pstm.setInt(1,codigo );
            res=pstm.executeQuery();
            if(res.next()){
                buscarP= new Producto(res.getString(2),res.getDouble(3), res.getInt(5), res.getString(4));
                
                txtNombre.setText(buscarP.getNombre());
                txtPrecio.setText(String.valueOf(buscarP.getPrecio()));
                if(buscarP.getEstado().equals("A")){
                    rbn.setSelected(true);
                    rbn2.setSelected(false);
                }
                else {
                    rbn2.setSelected(true);
                    rbn.setSelected(false);
                }
                txtStock.setText(String.valueOf(buscarP.getStock()));
                encontrado=true;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return encontrado;
        
    }
    
    public static boolean buscarProducto(Producto producto, JTextField txtNombre, JTextField txtPrecio, JTextField txtStock) {
        Connection conn;
        boolean encontrado = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBManager db = new DBManager();
        String buscar = "select nombreP, precioP, stockP from producto where idP=?";

        conn = db.getConexion();
        try {
            ps = conn.prepareStatement(buscar);
            ps.setInt(1, producto.getIdPro());

            rs = ps.executeQuery();

            if (rs.next()) {
                producto.setNombre(rs.getString(1));
                producto.setPrecio(rs.getDouble(2));
                producto.setStock(rs.getInt(3));
                txtNombre.setText(producto.getNombre());
                txtPrecio.setText(String.valueOf(producto.getPrecio()));
                txtStock.setText(String.valueOf(producto.getStock()));
                txtNombre.setEditable(false);
                txtPrecio.setEditable(false);
                txtStock.setEditable(false);
                encontrado = true;
            } else {
                encontrado = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return encontrado;
    }
    
    public static int actualizarStock(int cantidad,int idP){
        
        Connection con = null;
        DBManager dbm = new DBManager();
        con = dbm.getConexion();
        PreparedStatement ps = null;
        String sql = "update producto set stockP=? where idP =?";
    
        try {
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, cantidad);
            ps.setInt(2, idP);
            
            ps.executeUpdate();
              
            
        } catch (Exception e) {
            System.out.println("error al actualizar stock: "+e.getMessage());
        }
        return resp;
    }
    
    public static Producto listarID(int id){
        Producto pro = new Producto();
        Connection con = null;
        DBManager dbm = new DBManager();
        con= dbm.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select from producto where idP==?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            while (rs.next()) {                
                pro.setIdPro(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
            }
            
        } catch (Exception e) {
            System.out.println("error al listar producto");
        }
        return pro;
    }
    
    public static String nombPro(int id){
        
        Connection con = null;
        DBManager dbm = new DBManager();
        PreparedStatement ps = null;
        con = dbm.getConexion();
        
        ResultSet rs = null;
    
        String sql = "select nombreP from producto where idP=?";
    
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            
            if (rs.next()) {
            
                return rs.getString(1);
                
            }
        } catch (Exception e) {
            System.out.println("error p: "+e.getMessage());
        }
        return "";
    }
}
