/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Milagritos Quintana
 */
public class NuevoProductoView extends JFrame {
  private JTextField txtCodProducto, txtNombre, txtCodigo, txtPrecio, txtStock;
    private JComboBox<Object> cbxCategoria;
    private JButton btnGuardar, btnLimpiar;

    public NuevoProductoView() {
        setTitle("Nuevo Producto");
        setSize(400, 400); // Aumentado para que quepan los botones
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Código Producto
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Código Producto:"), gbc);
        txtCodProducto = new JTextField();
        gbc.gridx = 1;
        add(txtCodProducto, gbc);

        // Nombre
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Nombre:"), gbc);
        txtNombre = new JTextField();
        gbc.gridx = 1;
        add(txtNombre, gbc);

        // Código
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Código:"), gbc);
        txtCodigo = new JTextField();
        gbc.gridx = 1;
        add(txtCodigo, gbc);

        // Precio
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Precio:"), gbc);
        txtPrecio = new JTextField();
        gbc.gridx = 1;
        add(txtPrecio, gbc);

        // Stock
        gbc.gridx = 0; gbc.gridy = 4;
        add(new JLabel("Stock:"), gbc);
        txtStock = new JTextField();
        gbc.gridx = 1;
        add(txtStock, gbc);

        // Categoría
        gbc.gridx = 0; gbc.gridy = 5;
        add(new JLabel("Categoría:"), gbc);
        cbxCategoria = new JComboBox<>();
        gbc.gridx = 1;
        add(cbxCategoria, gbc);

        // Botón Guardar
        btnGuardar = new JButton("Guardar");
        gbc.gridx = 0; gbc.gridy = 6;
        add(btnGuardar, gbc);

        // ✅ Botón Limpiar
        btnLimpiar = new JButton("Limpiar");
        gbc.gridx = 1;
        add(btnLimpiar, gbc);
    }

    // Getters
    public JTextField getTxtCodProducto() { return txtCodProducto; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtCodigo() { return txtCodigo; }
    public JTextField getTxtPrecio() { return txtPrecio; }
    public JTextField getTxtStock() { return txtStock; }
    public JComboBox<Object> getCbxCategoria() { return cbxCategoria; }
    public JButton getBtnGuardar() { return btnGuardar; }
    public JButton getBtnLimpiar() { return btnLimpiar; } // Nuevo getter

    // ✅ Método para limpiar los campos
    public void limpiarCampos() {
        txtCodProducto.setText("");
        txtNombre.setText("");
        txtCodigo.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        cbxCategoria.setSelectedIndex(0);
    }
    
}
