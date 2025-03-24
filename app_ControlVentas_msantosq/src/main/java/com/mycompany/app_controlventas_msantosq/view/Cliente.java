/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.view;

/**
 *
 * @author Milagritos Quintana
 */
public class Cliente {
    private String codCliente;
    private String nombre;
    private int dni;
    private int telefono;

    public Cliente(String codCliente, String nombre, int dni, int telefono) {
        this.codCliente = codCliente;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente + ", nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono + '}';
    }
    

   
}
