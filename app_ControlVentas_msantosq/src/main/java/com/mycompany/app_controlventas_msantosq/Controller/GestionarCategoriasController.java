/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Controller;

import com.mycompany.app_controlventas_msantosq.DAO.CategoriaDAO;
import com.mycompany.app_controlventas_msantosq.Model.Categoria;
import com.mycompany.app_controlventas_msantosq.view.GestionarCategoriasView;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milagritos Quintana
 */
public class GestionarCategoriasController {
    private GestionarCategoriasView view;
    private CategoriaDAO dao;

    public GestionarCategoriasController(GestionarCategoriasView view) {
        this.view = view;
        this.dao = new CategoriaDAO();
        cargarTablaCategorias();
        agregarListeners();
        this.view.setVisible(true);
    }

    private void cargarTablaCategorias() {
        DefaultTableModel modelo = (DefaultTableModel) view.getTablaCategorias().getModel();
        modelo.setRowCount(0); 

        List<Categoria> categorias = dao.obtenerCategorias();
        for (Categoria c : categorias) {
            modelo.addRow(new Object[]{c.getIdCategoria(), c.getNombre(), c.isEstado() ? "Activo" : "Inactivo"});
        }
    }

    private void agregarListeners() {
        view.getBtnActualizar().addActionListener(e -> cargarTablaCategorias());

        view.getBtnEditar().addActionListener(e -> {
            int fila = view.getTablaCategorias().getSelectedRow();
            if (fila >= 0) {
                int id = (int) view.getTablaCategorias().getValueAt(fila, 0);
                String nombre = (String) view.getTablaCategorias().getValueAt(fila, 1);
                String estadoStr = (String) view.getTablaCategorias().getValueAt(fila, 2);
                boolean estado = estadoStr.equals("Activo");

                String nuevoNombre = JOptionPane.showInputDialog(view, "Editar nombre:", nombre);
                if (nuevoNombre != null && !nuevoNombre.isBlank()) {
                    boolean actualizado = dao.editarCategoria(id, nuevoNombre, estado);
                    if (actualizado) {
                        JOptionPane.showMessageDialog(view, " Categoría actualizada");
                        cargarTablaCategorias();
                    } else {
                        JOptionPane.showMessageDialog(view, "Error al actualizar categoría");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(view, "Selecciona una fila para editar");
            }
        });

        view.getBtnEliminar().addActionListener(e -> {
            int fila = view.getTablaCategorias().getSelectedRow();
            if (fila >= 0) {
                int id = (int) view.getTablaCategorias().getValueAt(fila, 0);
                int confirm = JOptionPane.showConfirmDialog(view, "¿Seguro que deseas eliminar la categoría?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    boolean eliminado = dao.eliminarCategoria(id);
                    if (eliminado) {
                        JOptionPane.showMessageDialog(view, " Categoría eliminada");
                        cargarTablaCategorias();
                    } else {
                        JOptionPane.showMessageDialog(view, "Error al eliminar categoría");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(view, "Selecciona una fila para eliminar");
            }
        });
    }
    
}
