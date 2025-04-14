/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.view;

import com.mycompany.app_controlventas_msantosq.DAO.CategoriaDAO;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;




/**
 *
 * @author Milagritos Quintana
 */
public class NuevaCategoriaView extends JDialog {

    private JTextField txtDescripcion;
    private JButton btnGuardar;
    private JButton btnCancelar;

    public NuevaCategoriaView(JFrame parent) {
        super(parent, "Nueva Categoría", true);
        initComponents();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel del formulario
        JPanel panelFormulario = new JPanel(new GridLayout(2, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblDescripcion = new JLabel("Descripción:");
        txtDescripcion = new JTextField();

        panelFormulario.add(lblDescripcion);
        panelFormulario.add(txtDescripcion);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        add(panelFormulario, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        pack();

        // Acción al presionar "Guardar"
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = txtDescripcion.getText().trim();
                if (descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar una descripción.");
                } else {
                    CategoriaDAO dao = new CategoriaDAO();
                    boolean exito = dao.insertarCategoria(descripcion);
                    if (exito) {
                        JOptionPane.showMessageDialog(null, "Categoría guardada correctamente.");
                        dispose(); // Cierra la ventana
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar la categoría.");
                    }
                }
            }
        });

        // Acción al presionar "Cancelar"
        btnCancelar.addActionListener(e -> dispose());
    }

}
