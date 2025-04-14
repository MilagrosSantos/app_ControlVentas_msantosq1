/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Controller;

import com.mycompany.app_controlventas_msantosq.DAO.ProductoDAO;
import com.mycompany.app_controlventas_msantosq.Model.Producto;
import com.mycompany.app_controlventas_msantosq.view.ActualizarStockView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Milagritos Quintana
 */
public class ActualizarStockController {
    private ActualizarStockView view;
    private ProductoDAO productoDAO;

    public ActualizarStockController(ActualizarStockView view) {
        this.view = view;
        this.productoDAO = new ProductoDAO();

        cargarProductos();

        // Listener para el comboBox: muestra stock actual al seleccionar producto
        view.getCbxProducto().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarStockActual();
            }
        });

        // Listener para el botón Guardar
        view.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarStock();
            }
        });
    }

    private void cargarProductos() {
        List<Producto> productos = productoDAO.listarProductos();
        JComboBox<Producto> combo = view.getCbxProducto();
        combo.removeAllItems();
        for (Producto p : productos) {
            combo.addItem(p); // Se usa el toString() de Producto
        }
    }

    private void mostrarStockActual() {
        Producto productoSeleccionado = (Producto) view.getCbxProducto().getSelectedItem();
        if (productoSeleccionado != null) {
            view.getTxtStockActual().setText(String.valueOf(productoSeleccionado.getStock()));
        } else {
            view.getTxtStockActual().setText("");
        }
    }

    private void actualizarStock() {
        Producto productoSeleccionado = (Producto) view.getCbxProducto().getSelectedItem();
        if (productoSeleccionado == null) {
            JOptionPane.showMessageDialog(view, "⚠️ Debes seleccionar un producto.");
            return;
        }

        try {
            int nuevoStock = Integer.parseInt(view.getTxtStockNuevo().getText());
            productoSeleccionado.setStock(nuevoStock);
            boolean exito = productoDAO.actualizarStock(productoSeleccionado);
            if (exito) {
                JOptionPane.showMessageDialog(view, "✅ Stock actualizado correctamente.");
                view.getTxtStockActual().setText(String.valueOf(nuevoStock));
                view.getTxtStockNuevo().setText("");
            } else {
                JOptionPane.showMessageDialog(view, "❌ Error al actualizar el stock.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "⚠️ Ingresa un número válido en el campo 'Stock Nuevo'.");
        }
    }
    
}
