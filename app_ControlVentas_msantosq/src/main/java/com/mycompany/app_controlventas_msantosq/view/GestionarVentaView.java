/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milagritos Quintana
 */
public class GestionarVentaView  extends JFrame{
    private JTable tablaVentas;
    private JButton btnEliminar, btnActualizar;
    private DefaultTableModel modelo;

    public GestionarVentaView() {
        setTitle("Gestionar Ventas");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        modelo = new DefaultTableModel(new String[]{"ID", "Cliente", "Fecha", "Total"}, 0);
        tablaVentas = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tablaVentas);

        btnEliminar = new JButton("Eliminar");
        btnActualizar = new JButton("Actualizar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public JTable getTablaVentas() {
        return tablaVentas;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }
}
