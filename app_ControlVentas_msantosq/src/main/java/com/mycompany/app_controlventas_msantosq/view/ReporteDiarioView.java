/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.view;

import java.awt.event.ActionListener;


/**
 *
 * @author Milagritos Quintana
 */
public class ReporteDiarioView  extends javax.swing.JFrame {
   
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JTextArea txtAreaReporte;  // Para mostrar el reporte generado
    private javax.swing.JTextField txtFecha;       // Para ingresar la fecha de reporte

    public ReporteDiarioView() {
        initComponents();
    }

    private void initComponents() {
        txtFecha = new javax.swing.JTextField(20);  // Campo para ingresar la fecha
        btnGenerarReporte = new javax.swing.JButton("Generar Reporte");
        txtAreaReporte = new javax.swing.JTextArea(20, 40);  // Área para mostrar el reporte
        txtAreaReporte.setEditable(false);  // No editable por el usuario

        // Configurar layout
        this.setLayout(new java.awt.FlowLayout());
        this.add(new javax.swing.JLabel("Ingrese la fecha:"));
        this.add(txtFecha);
        this.add(btnGenerarReporte);
        this.add(new javax.swing.JScrollPane(txtAreaReporte)); // JScrollPane para el área de texto

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    public String getFecha() {
        return txtFecha.getText();  // Obtiene la fecha del campo de texto
    }

    public void setReporte(String reporte) {
        txtAreaReporte.setText(reporte);  // Muestra el reporte en el área de texto
    }

    // Método para agregar el listener al botón
    public void addGenerarReporteListener(ActionListener listener) {
        btnGenerarReporte.addActionListener(listener);  // Agrega el listener al botón
    }
}
