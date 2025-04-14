/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Model;

/**
 *
 * @author Milagritos Quintana
 */
public class Empleado {

    private String coEmpleado;
    private String nombre;
    private int dni;
    private String cargo;
    private int telefono;

    public Empleado(String coEmpleado, String nombre, int dni, String cargo, int telefono) {
        this.coEmpleado = coEmpleado;
        this.nombre = nombre;
        this.dni = dni;
        this.cargo = cargo;
        this.telefono = telefono;
    }

    public String getCoEmpleado() {
        return coEmpleado;
    }

    public void setCoEmpleado(String coEmpleado) {
        this.coEmpleado = coEmpleado;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Empleado{" + "coEmpleado=" + coEmpleado + ", nombre=" + nombre + ", dni=" + dni + ", cargo=" + cargo + ", telefono=" + telefono + '}';
    }    
}
