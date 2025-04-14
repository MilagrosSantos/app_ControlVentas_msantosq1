/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.view;

import com.mycompany.app_controlventas_msantosq.DAO.CategoriaDAO;
import com.mycompany.app_controlventas_msantosq.Model.Categoria;
import java.awt.BorderLayout;
import java.util.List;
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
public class GestionarCategoriasView  extends JFrame {
    private JTable tablaCategorias;
    private JButton btnActualizar;
    private JButton btnEditar;
    private JButton btnEliminar;

    public GestionarCategoriasView() {
        setTitle("Gestionar Categorías");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tablaCategorias = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaCategorias);

        btnActualizar = new JButton("Actualizar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);

        // ✅ Cargar categorías al iniciar
        cargarCategorias();
    }

    private void cargarCategorias() {
        CategoriaDAO dao = new CategoriaDAO();
        List<Categoria> lista = dao.obtenerCategorias();

        String[] columnas = {"ID", "Nombre", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Categoria c : lista) {
            Object[] fila = {
                c.getIdCategoria(),
                c.getNombre(),
                c.isEstado() ? "Activo" : "Inactivo"
            };
            modelo.addRow(fila);
        }

        tablaCategorias.setModel(modelo);
    }

    public void cargarTabla(DefaultTableModel modelo) {
        tablaCategorias.setModel(modelo);
    }

    // ✅ Métodos getters públicos requeridos por el controlador

    public JTable getTablaCategorias() {
        return tablaCategorias;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }
}
