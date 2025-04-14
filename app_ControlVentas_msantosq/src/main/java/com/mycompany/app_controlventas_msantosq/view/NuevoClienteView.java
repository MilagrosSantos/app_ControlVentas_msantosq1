/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.view;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Milagritos Quintana
 */
public class NuevoClienteView extends JFrame{
     private JTextField txtCodCliente;
    private JTextField txtNombre;
    private JTextField txtDni;
    private JTextField txtTelefono;
    private JButton btnGuardar;
    private JButton btnLimpiar;

    public NuevoClienteView() {
        setTitle("Nuevo Cliente");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10)); // Una fila más para el nuevo botón
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Código Cliente:"));
        txtCodCliente = new JTextField();
        panel.add(txtCodCliente);

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("DNI:"));
        txtDni = new JTextField();
        panel.add(txtDni);

        panel.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panel.add(txtTelefono);

        btnGuardar = new JButton("Guardar");
        btnLimpiar = new JButton("Limpiar");

        panel.add(btnGuardar); // Botón Guardar
        panel.add(btnLimpiar); // Botón Limpiar

        add(panel);

        // Acción del botón Limpiar
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    // Método para limpiar los campos
    public void limpiarCampos() {
        txtCodCliente.setText("");
        txtNombre.setText("");
        txtDni.setText("");
        txtTelefono.setText("");
       
    }

    // Getters
    public JTextField getTxtCodCliente() { return txtCodCliente; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtDni() { return txtDni; }
    public JTextField getTxtTelefono() { return txtTelefono; }
    public JButton getBtnGuardar() { return btnGuardar; }
    public JButton getBtnLimpiar() { return btnLimpiar; }

}
