/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author MASTER
 */
public class Ventas2 {
    
    private int idVentas;
    private int idAdmin;
    private String numSerie;
    private String fecha;
    private double monto;
    private int idCliente;

    public Ventas2() {
    }

    public Ventas2(int idVentas, int idAdmin, String numSerie, String fecha, double monto, int idCliente) {
        this.idVentas = idVentas;
        this.idAdmin = idAdmin;
        this.numSerie = numSerie;
        this.fecha = fecha;
        this.monto = monto;
        this.idCliente = idCliente;
    }

    public Ventas2(int idAdmin, String numSerie, String fecha, double monto, int idCliente) {
        this.idAdmin = idAdmin;
        this.numSerie = numSerie;
        this.fecha = fecha;
        this.monto = monto;
        this.idCliente = idCliente;
    }

    public Ventas2(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }   
    
}
