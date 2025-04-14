/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milagritos Quintana
 */
public class GestionarClientesView extends JFrame {
 
    private JTable tablaClientes;
    private JTextField txtCodCliente, txtNombre, txtDni, txtTelefono;
    private JButton btnActualizar, btnEliminar;

    public GestionarClientesView() {
        setTitle("Administrar Clientes");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Administrar Clientes");
        lblTitulo.setBounds(260, 10, 200, 30);
        add(lblTitulo);

        tablaClientes = new JTable(new DefaultTableModel(
            new Object[][]{},
            new String[]{"Código", "Nombre", "DNI", "Teléfono"}
        ));
        JScrollPane scroll = new JScrollPane(tablaClientes);
        scroll.setBounds(30, 50, 620, 200);
        add(scroll);

        JLabel lblCod = new JLabel("Código:");
        lblCod.setBounds(30, 270, 100, 25);
        add(lblCod);
        txtCodCliente = new JTextField();
        txtCodCliente.setBounds(100, 270, 150, 25);
        txtCodCliente.setEditable(false); // Generalmente no editable
        add(txtCodCliente);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 310, 100, 25);
        add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setBounds(100, 310, 150, 25);
        add(txtNombre);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(280, 310, 100, 25);
        add(lblDni);
        txtDni = new JTextField();
        txtDni.setBounds(350, 310, 150, 25);
        add(txtDni);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(280, 270, 100, 25);
        add(lblTelefono);
        txtTelefono = new JTextField();
        txtTelefono.setBounds(350, 270, 150, 25);
        add(txtTelefono);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(540, 270, 100, 30);
        add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(540, 310, 100, 30);
        add(btnEliminar);
    }

    // Getters
    public JTable getTablaClientes() {
        return tablaClientes;
    }

    public JTextField getTxtCodCliente() {
        return txtCodCliente;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtDni() {
        return txtDni;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void limpiarCampos() {
        txtCodCliente.setText("");
        txtNombre.setText("");
        txtDni.setText("");
        txtTelefono.setText("");
    }
}
