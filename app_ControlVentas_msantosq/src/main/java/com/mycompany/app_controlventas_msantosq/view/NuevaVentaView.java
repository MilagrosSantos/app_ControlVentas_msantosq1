/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
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
public class NuevaVentaView  extends JFrame{
    
   private JComboBox<String> comboCliente;
    private JComboBox<String> comboProducto;
    private JTextField txtCantidad;
    private JTable tablaDetalleVenta;
    private JTextField txtTotal;
    private JTextField txtMetodoPago;
    private JTextField txtFechaVenta;
    
    
    
    // Constructor
    public NuevaVentaView() {
        setTitle("Registrar Venta");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel para los campos de venta
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Cliente:"));
        comboCliente = new JComboBox<>();
        panel.add(comboCliente);

        panel.add(new JLabel("Producto:"));
        comboProducto = new JComboBox<>();
        panel.add(comboProducto);

        panel.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        panel.add(txtCantidad);

        panel.add(new JLabel("Método de Pago:"));
        txtMetodoPago = new JTextField();
        panel.add(txtMetodoPago);

        panel.add(new JLabel("Fecha de Venta:"));
        txtFechaVenta = new JTextField();
        panel.add(txtFechaVenta);

        add(panel, BorderLayout.NORTH);

        // Tabla de detalles de venta
        tablaDetalleVenta = new JTable(new DefaultTableModel(new Object[]{"Producto", "Cantidad", "Precio"}, 0));
        add(new JScrollPane(tablaDetalleVenta), BorderLayout.CENTER);

        // Total de la venta
        JPanel panelTotal = new JPanel();
        panelTotal.add(new JLabel("Total:"));
        txtTotal = new JTextField(10);
        txtTotal.setEditable(false);
        panelTotal.add(txtTotal);
        add(panelTotal, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Métodos de acceso para obtener datos de la vista
    public String getClienteSeleccionado() {
        return (String) comboCliente.getSelectedItem();
    }

    public String getProductoSeleccionado() {
        return (String) comboProducto.getSelectedItem();
    }

    public int getCantidad() {
        return Integer.parseInt(txtCantidad.getText());
    }

    public String getMetodoPago() {
        return txtMetodoPago.getText();
    }

    public String getFechaVenta() {
        return txtFechaVenta.getText(); // Retorna la fecha como String
    }

    public double getTotalVenta() {
        return Double.parseDouble(txtTotal.getText());
    }

    public JTable getTablaDetalleVenta() {
        return tablaDetalleVenta;
    }

    public void cargarClientes(List<String> clientes) {
        comboCliente.removeAllItems();
        for (String cliente : clientes) {
            comboCliente.addItem(cliente);
        }
    }

    public void cargarProductos(List<String> productos) {
        comboProducto.removeAllItems();
        for (String producto : productos) {
            comboProducto.addItem(producto);
        }
    }

    public void agregarProductoALaTabla(String producto, int cantidad, double precio) {
        DefaultTableModel model = (DefaultTableModel) tablaDetalleVenta.getModel();
        model.addRow(new Object[]{producto, cantidad, precio});
    }

    // Métodos para agregar listeners a los botones
    public void addAgregarProductoListener(ActionListener listener) {
        // Aquí deberías asociar el listener al botón correspondiente
    }

    public void addRegistrarVentaListener(ActionListener listener) {
        // Aquí deberías asociar el listener al botón correspondiente
    }

    public void addCancelarListener(ActionListener listener) {
        // Aquí deberías asociar el listener al botón correspondiente
    }
}

