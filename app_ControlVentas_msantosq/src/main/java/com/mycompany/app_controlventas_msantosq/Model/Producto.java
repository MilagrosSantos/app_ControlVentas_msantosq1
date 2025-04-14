/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Model;

/**
 *
 * @author Milagritos Quintana
 */
public class Producto {

    private String codProducto;
    private int cantidad;
    private String nombre;
    private String codigo;
    private double precio;
    private int stock;
    private int idCategoria; // ✅ Nuevo campo

    public Producto(String codProducto, String nombre, String codigo, double precio, int stock, int idCategoria) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
        this.idCategoria = idCategoria;
    }

    // Constructor sin categoría (opcional si lo necesitas en otros contextos)
    public Producto(String codProducto, String nombre, String codigo, double precio, int stock) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto() {} // ✅ Constructor vacío si lo usas en DAO o formularios

    // Getters y setters
    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codProducto='" + codProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", idCategoria=" + idCategoria +
                '}';
    }
}
