/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Model;

import java.time.LocalDateTime;

/**
 *
 * @author Milagritos Quintana
 */
public class Venta {

    private String codVenta;
    private String CodCliente;
    private String codProducto;
    private float Total;
    private LocalDateTime fecha;
    private float descuento;
    private String  metPago;
    
    public Venta() {
        // Constructor vacío necesario para crear objetos sin pasar parámetros
    }


    public Venta(String codVenta, String CodCliente, String codProducto, float Total, LocalDateTime fecha, float descuento, String metPago) {
        this.codVenta = codVenta;
        this.CodCliente = CodCliente;
        this.codProducto = codProducto;
        this.Total = Total;
        this.fecha = fecha;
        this.descuento = descuento;
        this.metPago = metPago;
    }
    

    public String getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(String codVenta) {
        this.codVenta = codVenta;
    }

    public String getCodCliente() {
        return CodCliente;
    }

    public void setCodCliente(String CodCliente) {
        this.CodCliente = CodCliente;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public String getMetPago() {
        return metPago;
    }

    public void setMetPago(String metPago) {
        this.metPago = metPago;
    }

    @Override
    public String toString() {
        return "Venta{" + "codVenta=" + codVenta + ", CodCliente=" + CodCliente + ", codProducto=" + codProducto + ", Total=" + Total + ", fecha=" + fecha + ", descuento=" + descuento + ", metPago=" + metPago + '}';
    }    
}
