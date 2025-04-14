/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Controller;

import com.mycompany.app_controlventas_msantosq.DAO.CategoriaDAO;
import com.mycompany.app_controlventas_msantosq.DAO.ProductoDAO;
import com.mycompany.app_controlventas_msantosq.Model.Categoria;
import com.mycompany.app_controlventas_msantosq.Model.Producto;
import com.mycompany.app_controlventas_msantosq.view.NuevoProductoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Milagritos Quintana
 */
public class NuevoProductoController extends JFrame {
    
 private NuevoProductoView view;
    private ProductoDAO dao;
    private CategoriaDAO categoriaDAO;

    public NuevoProductoController(NuevoProductoView view) {
        this.view = view;
        this.dao = new ProductoDAO();
        this.categoriaDAO = new CategoriaDAO();

        // Cargar categorías al iniciar
        cargarCategorias();

        // Acción guardar producto
        this.view.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });

        // ✅ Acción limpiar campos
        this.view.getBtnLimpiar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.limpiarCampos();
            }
        });
    }

    private void cargarCategorias() {
        List<Categoria> categorias = categoriaDAO.obtenerCategorias();
        JComboBox<Object> combo = view.getCbxCategoria();
        combo.removeAllItems();
        for (Categoria c : categorias) {
            combo.addItem(c);
        }
    }

    private void guardarProducto() {
        try {
            String cod = view.getTxtCodProducto().getText();
            String nombre = view.getTxtNombre().getText();
            String codigo = view.getTxtCodigo().getText();
            double precio = Double.parseDouble(view.getTxtPrecio().getText());
            int stock = Integer.parseInt(view.getTxtStock().getText());
            Categoria categoriaSeleccionada = (Categoria) view.getCbxCategoria().getSelectedItem();

            if (categoriaSeleccionada == null) {
                JOptionPane.showMessageDialog(view, "⚠️ Debe seleccionar una categoría");
                return;
            }

            Producto p = new Producto(cod, nombre, codigo, precio, stock);
            p.setIdCategoria(categoriaSeleccionada.getIdCategoria());

            if (dao.insertarProducto(p)) {
                JOptionPane.showMessageDialog(view, "✅ Producto guardado correctamente");
                view.limpiarCampos(); // Limpiar luego de guardar
            } else {
                JOptionPane.showMessageDialog(view, "❌ Error al guardar producto");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "⚠️ Error: " + ex.getMessage());
        }
    }  
}