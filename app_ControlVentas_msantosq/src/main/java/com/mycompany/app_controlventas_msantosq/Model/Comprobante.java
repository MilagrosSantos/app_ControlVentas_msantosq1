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
public class Comprobante {

    private String codComprovante;
    private String codVenta;
    private String metPago;
    private LocalDateTime fecha; 

    public Comprobante(String codComprovante, String codVenta, String metPago, LocalDateTime fecha) {
        this.codComprovante = codComprovante;
        this.codVenta = codVenta;
        this.metPago = metPago;
        this.fecha = fecha;
    }

    public String getCodComprovante() {
        return codComprovante;
    }

    public void setCodComprovante(String codComprovante) {
        this.codComprovante = codComprovante;
    }

    public String getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(String codVenta) {
        this.codVenta = codVenta;
    }

    public String getMetPago() {
        return metPago;
    }

    public void setMetPago(String metPago) {
        this.metPago = metPago;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Comprobante{" + "codComprovante=" + codComprovante + ", codVenta=" + codVenta + ", metPago=" + metPago + ", fecha=" + fecha + '}';
    }    
}
