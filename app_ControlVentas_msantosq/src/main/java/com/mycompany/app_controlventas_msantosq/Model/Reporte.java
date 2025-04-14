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
public class Reporte {

  private String idVenta;
    private String nombreCliente;
    private String nombreProducto;
    private float total;
    private LocalDateTime fechaVenta;
    private String metodoPago;

    public Reporte(String idVenta, String nombreCliente, String nombreProducto, float total, LocalDateTime fechaVenta, String metodoPago) {
        this.idVenta = idVenta;
        this.nombreCliente = nombreCliente;
        this.nombreProducto = nombreProducto;
        this.total = total;
        this.fechaVenta = fechaVenta;
        this.metodoPago = metodoPago;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public float getTotal() {
        return total;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public String getMetodoPago() {
        return metodoPago;
    }
}
