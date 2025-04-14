/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Controller;

import com.mycompany.app_controlventas_msantosq.DAO.ClienteDAO;
import com.mycompany.app_controlventas_msantosq.DAO.ProductoDAO;
import com.mycompany.app_controlventas_msantosq.DAO.VentaDAO;
import com.mycompany.app_controlventas_msantosq.Model.Venta;
import com.mycompany.app_controlventas_msantosq.view.NuevaVentaView;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milagritos Quintana
 */
public class NuevaVentaController {
   private NuevaVentaView view;
    private ClienteDAO clienteDAO;
    private ProductoDAO productoDAO;
    private VentaDAO ventaDAO;

    public NuevaVentaController(NuevaVentaView view, ClienteDAO clienteDAO, ProductoDAO productoDAO, VentaDAO ventaDAO) {
        this.view = view;
        this.clienteDAO = clienteDAO;
        this.productoDAO = productoDAO;
        this.ventaDAO = ventaDAO;
        cargarClientes();
        cargarProductos();
        agregarListeners();
    }

    private void cargarClientes() {
        List<String> clientes = clienteDAO.obtenerNombresClientes();
        view.cargarClientes(clientes);
    }

    private void cargarProductos() {
        List<String> productos = productoDAO.obtenerNombresProductos();
        view.cargarProductos(productos);
    }

    private void agregarListeners() {
        view.addAgregarProductoListener(e -> agregarProducto());
        view.addRegistrarVentaListener(e -> registrarVenta());
        view.addCancelarListener(e -> cancelarVenta());
    }

    private void agregarProducto() {
        String producto = view.getProductoSeleccionado();
        int cantidad = view.getCantidad();
        double precio = productoDAO.obtenerPrecioProducto(producto);
        view.agregarProductoALaTabla(producto, cantidad, precio);
        actualizarTotal();
    }

    private void actualizarTotal() {
        DefaultTableModel model = (DefaultTableModel) view.getTablaDetalleVenta().getModel();
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            int cantidad = (int) model.getValueAt(i, 1);
            double precio = (double) model.getValueAt(i, 2);
            total += cantidad * precio;
        }
        view.getTablaDetalleVenta().repaint();
        view.getTablaDetalleVenta().updateUI();
        view.getTablaDetalleVenta().revalidate();
        view.getTablaDetalleVenta().requestFocus();
        
        // Se actualiza el campo total directamente
        view.getTablaDetalleVenta().getParent().repaint();
        view.getTablaDetalleVenta().getParent().revalidate();
        view.getTablaDetalleVenta().getParent().requestFocus();

        // Actualiza el campo total
        ((JTextField) Arrays.stream(view.getContentPane().getComponents())
                .filter(c -> c instanceof JPanel)
                .flatMap(p -> Arrays.stream(((JPanel) p).getComponents()))
                .filter(c -> c instanceof JTextField)
                .toArray()[4])
                .setText(String.valueOf(total)); // Actualizamos el txtTotal
    }

    private void registrarVenta() {
    String nombreCliente = view.getClienteSeleccionado();
    String metodoPago = view.getMetodoPago();
    String fecha = view.getFechaVenta(); 
    JTable tabla = view.getTablaDetalleVenta();
    
    if (nombreCliente == null || metodoPago.isEmpty() || fecha.isEmpty() || tabla.getRowCount() == 0) {
        JOptionPane.showMessageDialog(view, "Completa todos los campos antes de registrar la venta.");
        return;
    }

    // Obtener el código del cliente usando el nombre
    String codCliente = clienteDAO.obtenerCodigoPorNombre(nombreCliente);
    if (codCliente == null) {
        JOptionPane.showMessageDialog(view, "No se pudo encontrar el código del cliente.");
        return;
    }

    Venta venta = new Venta();
    venta.setCodCliente(codCliente);
    venta.setMetPago(metodoPago);

    try {
        LocalDateTime fechaVenta = LocalDateTime.parse(fecha);
        venta.setFecha(fechaVenta);
    } catch (DateTimeParseException e) {
        JOptionPane.showMessageDialog(view, "Fecha inválida.");
        return;
    }

    //venta.setTotal(view.getTotalVenta());

    List<Object[]> detalles = new ArrayList<>();
    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
        String producto = (String) model.getValueAt(i, 0);
        int cantidad = (int) model.getValueAt(i, 1);
        double precio = (double) model.getValueAt(i, 2);
        detalles.add(new Object[]{producto, cantidad, precio});
    }

    boolean exito = ventaDAO.insertarVentaConDetalles(venta, detalles);
    if (exito) {
        JOptionPane.showMessageDialog(view, "Venta registrada exitosamente.");
        ((DefaultTableModel) tabla.getModel()).setRowCount(0); // limpiar tabla
    } else {
        JOptionPane.showMessageDialog(view, "Error al registrar la venta.");
    }
}
}

