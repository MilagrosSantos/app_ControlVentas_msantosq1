/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Controller;

import com.mycompany.app_controlventas_msantosq.Config.ConexionDB;
import com.mycompany.app_controlventas_msantosq.DAO.VentaDAO;
import com.mycompany.app_controlventas_msantosq.Model.Venta;
import com.mycompany.app_controlventas_msantosq.view.GestionarVentaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milagritos Quintana
 */
public class GestionarVentaController implements ActionListener {
   
  private GestionarVentaView vista;
    private VentaDAO ventaDAO;

   

    private void cargarTablaVentas() {
        DefaultTableModel modelo = vista.getModelo();
        modelo.setRowCount(0);
        List<Venta> ventas = ventaDAO.listarVentas();
        for (Venta v : ventas) {
            modelo.addRow(new Object[]{
                v.getCodVenta(),
                v.getCodCliente(),
                v.getFecha(),
                v.getTotal()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnActualizar()) {
            cargarTablaVentas();
        }
    }
}