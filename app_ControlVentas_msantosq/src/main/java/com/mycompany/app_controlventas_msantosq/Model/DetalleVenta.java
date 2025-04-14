/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Model;

/**
 *
 * @author Milagritos Quintana
 */
public class DetalleVenta {

    private int codProduct;
    private int cantidad;
    private float subTotal;

    public DetalleVenta(int codProduct, int cantidad, float subTotal) {
        this.codProduct = codProduct;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public int getCodProduct() {
        return codProduct;
    }

    public void setCodProduct(int codProduct) {
        this.codProduct = codProduct;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "codProduct=" + codProduct + ", cantidad=" + cantidad + ", subTotal=" + subTotal + '}';
    }
    
}
