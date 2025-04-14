/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.view;

import com.mycompany.app_controlventas_msantosq.Model.Categoria;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milagritos Quintana
 */
public class GestionarProductosView extends JFrame {
 private JTable tablaProductos;
    private DefaultTableModel modeloTabla;
    private JButton btnActualizar, btnEliminar, btnEditar;
    private JTextField txtNombre, txtPrecio, txtCantidad, txtDescripcion;
    private JComboBox<Categoria> cbxCategoria;

    public GestionarProductosView() {
        setTitle("Administrar Productos");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior - Tabla (modelo actualizado sin descripción)
        modeloTabla = new DefaultTableModel(new String[]{"Código", "Nombre", "Cantidad", "Precio", "Categoría", "Estado"}, 0);
        tablaProductos = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaProductos);
        add(scroll, BorderLayout.CENTER);

        // Panel lateral - Botones
        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 5, 10));
        btnActualizar = new JButton("Actualizar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        add(panelBotones, BorderLayout.EAST);

        // Panel inferior - Formulario
        JPanel panelFormulario = new JPanel(new GridLayout(2, 5, 10, 10));
        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        txtCantidad = new JTextField();
        txtDescripcion = new JTextField(); // Aún puedes usarlo si luego lo agregas
        cbxCategoria = new JComboBox<>();
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(new JLabel("Precio:"));
        panelFormulario.add(new JLabel("Cantidad:"));
        panelFormulario.add(new JLabel("Descripción:"));
        panelFormulario.add(new JLabel("Categoría:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(txtPrecio);
        panelFormulario.add(txtCantidad);
        panelFormulario.add(txtDescripcion);
        panelFormulario.add(cbxCategoria);
        add(panelFormulario, BorderLayout.SOUTH);
    }

    // ✅ Getters públicos
    public JTable getTblProductos() { return tablaProductos; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }
    public JButton getBtnActualizar() { return btnActualizar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnEditar() { return btnEditar; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtPrecio() { return txtPrecio; }
    public JTextField getTxtCantidad() { return txtCantidad; }
    public JTextField getTxtDescripcion() { return txtDescripcion; }
    public JComboBox<Categoria> getCbxCategoria() { return cbxCategoria; }   
}
