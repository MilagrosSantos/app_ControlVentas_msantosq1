/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Controller;

import com.mycompany.app_controlventas_msantosq.DAO.ReporteDAO;
import com.mycompany.app_controlventas_msantosq.DAO.VentaDAO;
import com.mycompany.app_controlventas_msantosq.Model.Reporte;
import com.mycompany.app_controlventas_msantosq.Model.Venta;
import com.mycompany.app_controlventas_msantosq.view.ReporteDiarioView;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Milagritos Quintana
 */
public class ReporteDiarioController {
    
    
   private ReporteDiarioView vista;
    private VentaDAO ventaDAO;

    public ReporteDiarioController(ReporteDiarioView vista, VentaDAO ventaDAO) {
        this.vista = vista;
        this.ventaDAO = ventaDAO;
        this.vista.btnGenerarReporte.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGenerarReporte) {
            generarReporte();
        }
    }

    private void generarReporte() {
        // Obtener fecha desde el JSpinner
        java.util.Date fechaUtil = (java.util.Date) vista.spinnerFecha.getValue();
        java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());

        // Obtener lista de ventas del DAO
        List<Venta> ventas = ventaDAO.obtenerVentasPorFecha(fechaSQL);

        // Limpiar la tabla antes de llenarla
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.tablaReporte.getModel();
        modeloTabla.setRowCount(0);

        // Llenar la tabla con las ventas del día
        if (ventas != null && !ventas.isEmpty()) {
            for (Venta venta : ventas) {
                Object[] fila = new Object[]{
                    venta.getCodVenta(),
                    venta.getCodCliente(),
                    venta.getCodProducto(),
                    venta.getTotal(),
                    venta.getFecha(),
                    venta.getDescuento(),
                    venta.getMetPago()
                };
                modeloTabla.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "No hay ventas registradas para la fecha seleccionada.");
        }
    }
   
}
