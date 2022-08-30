/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author HAROLD
 */
public class Cliente {
    private int idCliente;
    private String nombtre;
    private String dni;
    private String direccion;

    public Cliente() {
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(int idCliente, String nombtre, String dni, String direccion) {
        this.idCliente = idCliente;
        this.nombtre = nombtre;
        this.dni = dni;
        this.direccion = direccion;
    }

    public Cliente(String nombtre, String dni, String direccion) {
        this.nombtre = nombtre;
        this.dni = dni;
        this.direccion = direccion;
    }

    public Cliente(String dni) {
        this.dni = dni;
    }

    public String getNombtre() {
        return nombtre;
    }

    public void setNombtre(String nombtre) {
        this.nombtre = nombtre;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }
     
}
