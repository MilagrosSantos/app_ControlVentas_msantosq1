/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Controller;

import com.mycompany.app_controlventas_msantosq.DAO.CategoriaDAO;
import com.mycompany.app_controlventas_msantosq.DAO.ProductoDAO;
import com.mycompany.app_controlventas_msantosq.Model.Categoria;
import com.mycompany.app_controlventas_msantosq.Model.Producto;
import com.mycompany.app_controlventas_msantosq.view.GestionarProductosView;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milagritos Quintana
 */
public class GestionarProductosController {
    
  private GestionarProductosView view;
    private ProductoDAO dao;
    private CategoriaDAO categoriaDAO;
    private DefaultTableModel modelo;

    public GestionarProductosController(GestionarProductosView view) {
        this.view = view;
        this.dao = new ProductoDAO();
        this.categoriaDAO = new CategoriaDAO();
        this.modelo = (DefaultTableModel) view.getTblProductos().getModel();

        cargarCategorias();
        cargarProductos();

        // Botón actualizar
        view.getBtnActualizar().addActionListener(e -> cargarProductos());

        // Botón eliminar
        view.getBtnEliminar().addActionListener(e -> eliminarProducto());

        // Botón editar
        view.getBtnEditar().addActionListener(e -> editarProducto());
    }

    private void cargarProductos() {
        modelo.setRowCount(0); 
        List<Producto> lista = dao.listarProductos();

        for (Producto p : lista) {
            Categoria categoria = categoriaDAO.buscarPorId(p.getIdCategoria());
            modelo.addRow(new Object[]{
                p.getCodProducto(),
                p.getNombre(),
                p.getStock(),
                p.getPrecio(),
                categoria != null ? categoria.getNombre() : "Desconocido",
                "Activo" 
            });
        }
    }

    private void eliminarProducto() {
        int fila = view.getTblProductos().getSelectedRow();
        if (fila != -1) {
            String codProducto = (String) modelo.getValueAt(fila, 0);
            int confirm = JOptionPane.showConfirmDialog(view, "¿Eliminar producto?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (dao.eliminarProducto(codProducto)) {
                    modelo.removeRow(fila);
                    JOptionPane.showMessageDialog(view, "Producto eliminado.");
                } else {
                    JOptionPane.showMessageDialog(view, "Error al eliminar.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(view, "Seleccione un producto para eliminar.");
        }
    }

    private void editarProducto() {
        int fila = view.getTblProductos().getSelectedRow();
        if (fila != -1) {
            String codProducto = (String) modelo.getValueAt(fila, 0);
            String nombre = view.getTxtNombre().getText();
            double precio = Double.parseDouble(view.getTxtPrecio().getText());
            int cantidad = Integer.parseInt(view.getTxtCantidad().getText());
            Categoria categoria = (Categoria) view.getCbxCategoria().getSelectedItem();

            Producto producto = new Producto();
            producto.setCodProducto(codProducto);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(cantidad);
            producto.setIdCategoria(categoria.getIdCategoria());

            if (dao.editarProducto(producto)) {
                JOptionPane.showMessageDialog(view, " Producto actualizado.");
                cargarProductos();
            } else {
                JOptionPane.showMessageDialog(view, " Error al actualizar.");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Seleccione un producto para editar.");
        }
    }

    private void cargarCategorias() {
        List<Categoria> lista = categoriaDAO.obtenerCategorias();
        view.getCbxCategoria().removeAllItems();
        for (Categoria cat : lista) {
            view.getCbxCategoria().addItem(cat);
        }
    }
}
