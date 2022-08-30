/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Conexion.DBManager;
import Modelo.Cliente;

import Modelo.Detalleventas2;
import Modelo.Producto;

import Modelo.Ventas2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MASTER
 */
public class ControladorVentas2 {

    private static Connection conect = null;
    private static PreparedStatement pre = null;
    private static DBManager bd = new DBManager();
    private static ResultSet result = null;

    static int resp = 0;

    public static String generarCodigo() {
        int codigo = 0;
        Ventas2 venta2 = null;
        DBManager db = new DBManager();
        Connection conn = db.getConexion();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String codigoG = "";
        String sqlSelect = "select * from venta order by idV";

        try {
            pstm = conn.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();

            rs.afterLast();

            if (rs.previous()) {
                venta2 = new Ventas2(rs.getInt(1));
                codigo = venta2.getIdVentas();
                codigo++;
                if (codigo < 10) {
                    codigoG = "00000" + codigo;
                } else {
                    codigoG = "0000" + codigo;
                }

            } else {
                codigoG = "0000001";
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return codigoG;
    }

    /*public static int agregarV(Detalleventas2 dv) {

        Connection conn = null;
        PreparedStatement pst = null;
        DBManager db = new DBManager();
        int contador = 0;
        String sqlSelect = "insert into detalle_venta(idP,cantidad,precioVenta) values(?,?,?) ";

        conn = db.getConexion();
        try {
            pst = conn.prepareStatement(sqlSelect);

            pst.setInt(1, dv.getIdProduc());
            pst.setInt(2, dv.getCantidad());
            pst.setDouble(3, dv.getPrecioVenta());
            contador = pst.executeUpdate();

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        }
        return contador;
    }
     */
    public static int cantidadMaxima(int codigo) {
        int cantidad = 0;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        DBManager db = new DBManager();
        String sqlSelect = "select stockP from producto where idP=?";
        conn = db.getConexion();
        Producto producto = null;
        int limite = 0;
        try {
            ps = conn.prepareStatement(sqlSelect);

            ps.setInt(1, codigo);

            rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Producto(codigo);
                limite = rs.getInt(1);
                producto.setStock(limite);
                System.out.println("limite actual " + limite);
            } else {
                limite = 0;
            }

        } catch (Exception e) {

            System.out.println("error cantidad maxima: " + e.getMessage());
        }
        return limite;

    }

    public static void mostrarTabla(JTable tb, Detalleventas2 dv) {
        DefaultTableModel moT = new DefaultTableModel();

        Object[] fila = new Object[6];

        //moT.setColumnIdentifiers(titulo);
        int cont = 0;

        ArrayList list = new ArrayList();

        while (dv.getCantidad() > 0) {
            cont++;
            list.add(cont);
            list.add(dv.getIdProduc());
            list.add(nombreProducto(dv.getIdProduc()));
            list.add(dv.getPrecioVenta());
            list.add(dv.getCantidad());
            list.add(dv.total());

            fila[0] = list.get(0);
            fila[1] = list.get(1);
            fila[2] = list.get(2);
            fila[3] = list.get(3);
            fila[4] = list.get(4);
            fila[5] = list.get(5);

            moT.addRow(fila);

        }

        tb.setModel(moT);

    }

    public static String nombreProducto(int idPro) {
        Producto productoNombbre = null;
        DBManager db = new DBManager();
        Connection conn = db.getConexion();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String nombre = null;
        String sql = "select nombreP from producto where idP=?";
        try {

            pst = conn.prepareStatement(sql);
            pst.setInt(1, idPro);

            rs = pst.executeQuery();

            if (rs.next()) {
                productoNombbre = new Producto(idPro);
                productoNombbre.setNombre(rs.getString(1));
                nombre = productoNombbre.getNombre();
            }

        } catch (Exception e) {
            System.out.println("error nombre Producto: " + e.getMessage());
        }
        return nombre;

    }


    public static void limpiarTabla(JTable tabla) {
        DefaultTableModel moT = new DefaultTableModel();

        for (int i = moT.getRowCount() - 1; i >= 0; i--) {
            moT.removeRow(i);
        }

        tabla.setModel(moT);
    }

    public static void mostrarTitulo(JTable tblVenta) {
        String[] titulo = {"Nro", "codigo", "producto", "P.unitario", "cantidad", "total"};
        DefaultTableModel moT = new DefaultTableModel();

        moT.setColumnIdentifiers(titulo);
        tblVenta.setModel(moT);

    }
public static int guardarVenta(Ventas2 ven) {
        Ventas2 ventas = new Ventas2();
        //int r=0;
        Connection con = null;
        DBManager dbm = new DBManager();
        con = dbm.getConexion();
        PreparedStatement ps = null;
        String sql = "insert into venta(idA,numeroV,fechaV,monto,idC) values(?,?,?,?,?)";

        try {

            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, ven.getIdAdmin());
            ps.setString(2, ven.getNumSerie());
            ps.setString(3, ven.getFecha());
            ps.setDouble(4, ven.getMonto());
            ps.setInt(5, ven.getIdCliente());

            System.out.println("sql: " + sql);
            int lastInsertedID = ps.executeUpdate();
            System.out.println("Idcliente: " + lastInsertedID);
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Last Inserted ID = " + rs.getLong(1));
                lastInsertedID = rs.getInt(1);
                ventas.setIdVentas(lastInsertedID);
            }
            return lastInsertedID;
        } catch (Exception e) {
            System.out.println("error al guardar Venta: " + e.getMessage());
        }

        return resp;
    }

    public static int guardarDVenta(Detalleventas2 dv) {
        Connection con = null;
        DBManager dbm = new DBManager();
        PreparedStatement ps = null;
        con = dbm.getConexion();
        String sql = "insert into detalle_venta(idV,idP,cantidad,precioVenta) "
                + "values(?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            System.out.println("idventa; " + dv.getIdVen());
            System.out.println("IdProducto" + dv.getIdProduc());
            ps.setInt(1, dv.getIdVen());
            ps.setInt(2, dv.getIdProduc());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPrecioVenta());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("error al guardar detalle Venta" + e.getMessage());
        }
        return resp;
    }

    public static String NumSerie() {

        Connection con = null;
        DBManager dbm = new DBManager();
        con = dbm.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String serie = "";
        String sql = "select max(numeroV) from venta";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                serie = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println("error al generar serie: " + e.getMessage());
        }
        return serie;
    }

    public static void disminuirStock(int cantidad, int StockProducto, int id) {
       

       int stockNuevo = StockProducto-cantidad;

        String sql = "update producto set stockP=? where idP=?";
        conect = bd.getConexion();
        try {
            pre = conect.prepareStatement(sql);
            pre.setInt(1, stockNuevo);
            pre.setInt(2, id);

            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("error : " + ex.getMessage());
        }

    }

    public static int getStock(int idP) {
        int cantidad = 0;
        String sql = "select stockP from producto where idP=?";

        conect = bd.getConexion();
        try {
            pre = conect.prepareStatement(sql);
            pre.setInt(1, idP);
            result = pre.executeQuery();
            if (result.next()) {
                cantidad = result.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("error : "+e.getMessage());
        }

        return cantidad;

    }

}
