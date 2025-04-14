/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Controller;

import com.mycompany.app_controlventas_msantosq.DAO.ClienteDAO;
import com.mycompany.app_controlventas_msantosq.Model.Cliente;
import com.mycompany.app_controlventas_msantosq.view.NuevoClienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Milagritos Quintana
 */
public class NuevoClienteController {
    
    private NuevoClienteView vista;
    private ClienteDAO clienteDAO;

    public NuevoClienteController(NuevoClienteView vista) {
        this.vista = vista;
        this.clienteDAO = new ClienteDAO();
        iniciarEventos();
    }

    private void iniciarEventos() {
        vista.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCliente();
            }
        });
    }

    private void guardarCliente() {
        String cod = vista.getTxtCodCliente().getText().trim();
        String nombre = vista.getTxtNombre().getText().trim();
        String dniTexto = vista.getTxtDni().getText().trim();
        String telefonoTexto = vista.getTxtTelefono().getText().trim();

        if (cod.isEmpty() || nombre.isEmpty() || dniTexto.isEmpty() || telefonoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int dni = Integer.parseInt(dniTexto);
            int telefono = Integer.parseInt(telefonoTexto);

            Cliente cliente = new Cliente();
            cliente.setCodCliente(cod);
            cliente.setNombre(nombre);
            cliente.setDni(dni);
            cliente.setTelefono(telefono);

            boolean exito = clienteDAO.insertarCliente(cliente, vista);
            if (exito) {
                JOptionPane.showMessageDialog(vista, "✅ Cliente guardado exitosamente.");
                vista.limpiarCampos();
            } else {
                // El mensaje de error ya se muestra desde ClienteDAO si falla
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "DNI y Teléfono deben ser valores numéricos.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}
