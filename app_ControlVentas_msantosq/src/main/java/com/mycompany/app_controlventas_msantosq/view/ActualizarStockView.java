/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.view;

import com.mycompany.app_controlventas_msantosq.Model.Producto;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Milagritos Quintana
 */
public class ActualizarStockView extends JFrame  {
    private JComboBox<Producto> cbxProducto;
    private JTextField txtStockActual;
    private JTextField txtStockNuevo;
    private JButton btnGuardar;

    public ActualizarStockView() {
        setTitle("Actualizar Stock de Productos");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel lblTitulo = new JLabel("Actualizar Stock de Productos", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        // Producto
        gbc.gridy++;
        gbc.gridwidth = 1;
        add(new JLabel("Producto:"), gbc);
        cbxProducto = new JComboBox<>();
        gbc.gridx = 1;
        add(cbxProducto, gbc);

        // Stock Actual
        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Stock Actual:"), gbc);
        txtStockActual = new JTextField();
        txtStockActual.setEditable(false);
        gbc.gridx = 1;
        add(txtStockActual, gbc);

        // Stock Nuevo
        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Stock Nuevo:"), gbc);
        txtStockNuevo = new JTextField();
        gbc.gridx = 1;
        add(txtStockNuevo, gbc);

        // Botón Guardar
        btnGuardar = new JButton("Guardar");
        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2;
        add(btnGuardar, gbc);
    }

    // Getters
    public JComboBox<Producto> getCbxProducto() { return cbxProducto; }
    public JTextField getTxtStockActual() { return txtStockActual; }
    public JTextField getTxtStockNuevo() { return txtStockNuevo; }
    public JButton getBtnGuardar() { return btnGuardar; }   
}
