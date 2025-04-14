/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.view;

import com.mycompany.app_controlventas_msantosq.Config.ConexionDB;
import com.mycompany.app_controlventas_msantosq.Controller.ActualizarStockController;
import com.mycompany.app_controlventas_msantosq.Controller.GestionarCategoriasController;
import com.mycompany.app_controlventas_msantosq.Controller.GestionarClientesController;
import com.mycompany.app_controlventas_msantosq.Controller.GestionarProductosController;
import com.mycompany.app_controlventas_msantosq.Controller.GestionarVentaController;
import com.mycompany.app_controlventas_msantosq.Controller.LoginController;
import com.mycompany.app_controlventas_msantosq.Controller.NuevaVentaController;
import com.mycompany.app_controlventas_msantosq.Controller.NuevoClienteController;
import com.mycompany.app_controlventas_msantosq.Controller.NuevoProductoController;
import com.mycompany.app_controlventas_msantosq.Controller.ReporteDiarioController;
import com.mycompany.app_controlventas_msantosq.DAO.ClienteDAO;
import com.mycompany.app_controlventas_msantosq.DAO.ProductoDAO;
import com.mycompany.app_controlventas_msantosq.DAO.VentaDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Milagritos Quintana
 */
public class MainView extends JFrame {
       public MainView() {
        setTitle("Sistema de Ventas");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(173, 216, 230));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new BorderLayout());
        setContentPane(panel);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuProducto = new JMenu("PRODUCTO");
        JMenuItem nuevoProducto = new JMenuItem("NUEVO PRODUCTO");
        JMenuItem gestionarProducto = new JMenuItem("GESTIONAR PRODUCTO");
        JMenuItem actualizarStock = new JMenuItem("ACTUALIZAR STOCK");
        menuProducto.add(nuevoProducto);
        menuProducto.add(gestionarProducto);
        menuProducto.add(actualizarStock);
        menuBar.add(menuProducto);

        JMenu menuCliente = new JMenu("CLIENTE");
        JMenuItem nuevoCliente = new JMenuItem("NUEVO CLIENTE");
        JMenuItem gestionarCliente = new JMenuItem("GESTIONAR CLIENTE");
        menuCliente.add(nuevoCliente);
        menuCliente.add(gestionarCliente);
        menuBar.add(menuCliente);

        JMenu menuCategoria = new JMenu("CATEGORIAS");
        JMenuItem nuevaCategoria = new JMenuItem("NUEVA CATEGORÍA");
        JMenuItem gestionarCategoria = new JMenuItem("GESTIONAR CATEGORIAS");
        menuCategoria.add(nuevaCategoria);
        menuCategoria.add(gestionarCategoria);
        menuBar.add(menuCategoria);

        JMenu menuPerfil = new JMenu("PERFIL");
        JMenuItem verPerfil = new JMenuItem("VER PERFIL");
        menuPerfil.add(verPerfil);
        menuBar.add(menuPerfil);

        JMenu menuFactura = new JMenu("FACTURA");
        JMenuItem nuevaVenta = new JMenuItem("NUEVA VENTA");
        JMenuItem gestionarVenta = new JMenuItem("GESTIONAR VENTA");
        menuFactura.add(nuevaVenta);
        menuFactura.add(gestionarVenta);
        menuBar.add(menuFactura);

        JMenu menuReporte = new JMenu("REPORTE");
        JMenuItem ingresosDiarios = new JMenuItem("REPORTE DE INGRESOS DIARIOS");
        menuReporte.add(ingresosDiarios);
        menuBar.add(menuReporte);

        JMenu menuSalir = new JMenu("CERRAR SESIÓN");
        JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesión");
        menuSalir.add(cerrarSesion);
        menuBar.add(menuSalir);

        setJMenuBar(menuBar);

        // Eventos
        nuevoProducto.addActionListener(e -> abrirNuevoProducto());
        gestionarProducto.addActionListener(e -> abrirGestionarProducto());
        actualizarStock.addActionListener(e -> abrirActualizarStock());
        nuevoCliente.addActionListener(e -> abrirNuevoCliente());
        gestionarCliente.addActionListener(e -> abrirGestionarCliente());
        nuevaCategoria.addActionListener(e -> abrirNuevaCategoria());
        gestionarCategoria.addActionListener(e -> abrirGestionarCategoria());
        nuevaVenta.addActionListener(e -> abrirNuevaVenta());
        gestionarVenta.addActionListener(e -> abrirGestionarVenta());
        ingresosDiarios.addActionListener(e -> abrirReporteDiario());
        cerrarSesion.addActionListener(e -> cerrarSesion());

        JLabel label = new JLabel("SISTEMA DE VENTAS", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.ITALIC, 24));
        panel.add(label, BorderLayout.CENTER);

        setVisible(true);
    }

    // Métodos para abrir vistas
    private void abrirGestionarProducto() {
        var view = new GestionarProductosView();
        new GestionarProductosController(view);
        view.setVisible(true);
    }

    private void abrirNuevoProducto() {
        var view = new NuevoProductoView();
        new NuevoProductoController(view);
        view.setVisible(true);
    }

    private void abrirActualizarStock() {
        var view = new ActualizarStockView();
        new ActualizarStockController(view);
        view.setVisible(true);
    }

    private void abrirNuevoCliente() {
        var view = new NuevoClienteView();
        new NuevoClienteController(view);
        view.setVisible(true);
    }

    private void abrirGestionarCliente() {
        var view = new GestionarClientesView();
        new GestionarClientesController(view);
        view.setVisible(true);
    }

    private void abrirNuevaCategoria() {
        var view = new NuevaCategoriaView(this);
        view.setVisible(true);
    }

    private void abrirGestionarCategoria() {
        var view = new GestionarCategoriasView();
        new GestionarCategoriasController(view);
        view.setVisible(true);
    }


    private void abrirNuevaVenta() {
        var view = new NuevaVentaView();
        var controller = new NuevaVentaController(view, new ClienteDAO(), new ProductoDAO(), new VentaDAO(ConexionDB.conectar()));
        view.setVisible(true);
    }

    private void abrirGestionarVenta() {
        var view = new GestionarVentaView();
        new GestionarVentaController(view);
        view.setVisible(true);
    }

/**
 *
    private void abrirReporteDiario() {
        ReporteDiarioView view = new ReporteDiarioView();
        new ReporteDiarioController(view);
        view.setVisible(true);
    }
 */
    private void cerrarSesion() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de cerrar sesión?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            dispose();
            mostrarLogin();
        }
    }

    private void mostrarLogin() {
        SwingUtilities.invokeLater(() -> {
            var view = new LoginView();
            new LoginController(view);
            view.setVisible(true);
        });
    }
     
}   
