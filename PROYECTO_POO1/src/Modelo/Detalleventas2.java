/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author MASTER
 */
public class Detalleventas2 {
    
    private int idDV;
    private int idVen;
    private int idProduc;
    private int cantidad;
    private double precioVenta;

    public Detalleventas2() {
    }

    public Detalleventas2(int idDV, int idVen, int idProduc, int cantidad, double precioVenta) {
        this.idDV = idDV;
        this.idVen = idVen;
        this.idProduc = idProduc;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    public Detalleventas2(int idVen, int idProduc, int cantidad, double precioVenta) {
        this.idVen = idVen;
        this.idProduc = idProduc;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    public int getIdDV() {
        return idDV;
    }

    public void setIdDV(int idDV) {
        this.idDV = idDV;
    }

    public int getIdVen() {
        return idVen;
    }

    public void setIdVen(int idVen) {
        this.idVen = idVen;
    }

    public int getIdProduc() {
        return idProduc;
    }

    public void setIdProduc(int idProduc) {
        this.idProduc = idProduc;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public double total(){
        return this.getCantidad()*this.getPrecioVenta();
    }
    
    
    
}
