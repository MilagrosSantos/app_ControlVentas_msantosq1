/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Controller;

import com.mycompany.app_controlventas_msantosq.DAO.ClienteDAO;
import com.mycompany.app_controlventas_msantosq.Model.Cliente;
import com.mycompany.app_controlventas_msantosq.view.GestionarClientesView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milagritos Quintana
 */
public class GestionarClientesController {
    
    private GestionarClientesView vista;
    private ClienteDAO clienteDAO;

    public GestionarClientesController(GestionarClientesView vista) {
        this.vista = vista;
        this.clienteDAO = new ClienteDAO();
        cargarClientes();
        agregarEventos();
    }

    private void cargarClientes() {
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaClientes().getModel();
        modelo.setRowCount(0);
        for (Cliente c : clienteDAO.listarClientes()) {
            modelo.addRow(new Object[]{
                c.getCodCliente(), c.getNombre(), c.getDni(), c.getTelefono()
            });
        }
    }

    private void agregarEventos() {
        vista.getTablaClientes().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = vista.getTablaClientes().getSelectedRow();
                if (fila >= 0) {
                    vista.getTxtCodCliente().setText(vista.getTablaClientes().getValueAt(fila, 0).toString());
                    vista.getTxtNombre().setText(vista.getTablaClientes().getValueAt(fila, 1).toString());
                    vista.getTxtDni().setText(vista.getTablaClientes().getValueAt(fila, 2).toString());
                    vista.getTxtTelefono().setText(vista.getTablaClientes().getValueAt(fila, 3).toString());
                }
            }
        });

        vista.getBtnActualizar().addActionListener(e -> {
            Cliente c = new Cliente();
            c.setCodCliente(vista.getTxtCodCliente().getText());
            c.setNombre(vista.getTxtNombre().getText());
            c.setDni(Integer.parseInt(vista.getTxtDni().getText()));
            c.setTelefono(Integer.parseInt(vista.getTxtTelefono().getText()));
            if (clienteDAO.editarCliente(c)) {
                JOptionPane.showMessageDialog(vista, "Cliente actualizado");
                cargarClientes();
            }
        });

        vista.getBtnEliminar().addActionListener(e -> {
            String cod = vista.getTxtCodCliente().getText();
            if (clienteDAO.eliminarCliente(cod)) {
                JOptionPane.showMessageDialog(vista, "Cliente eliminado");
                cargarClientes();
                vista.limpiarCampos();
                
            }
        });
    }
}
