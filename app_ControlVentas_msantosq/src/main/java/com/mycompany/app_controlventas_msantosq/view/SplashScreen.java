/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.view;

import com.mycompany.app_controlventas_msantosq.Controller.LoginController;
import com.mycompany.app_controlventas_msantosq.DAO.LoginDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Milagritos Quintana
 */
public class SplashScreen extends JWindow {

  
   public SplashScreen() {
        // Crear panel con fondo y diseño gráfico
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(173, 216, 230));
                g.fillRect(0, 0, getWidth(), getHeight());

                // Líneas decorativas
                g.setColor(new Color(0, 102, 204, 100));
                for (int i = 20; i < getWidth(); i += 50) {
                    g.drawLine(i, 0, i - 30, getHeight());
                }

                // Círculos decorativos
                g.setColor(new Color(255, 255, 255, 100));
                for (int i = 50; i < getWidth(); i += 80) {
                    g.fillOval(i, getHeight() - 100, 40, 40);
                }
            }
        };
        panel.setLayout(new BorderLayout());

        // Título
        JLabel title = new JLabel("Sistema de Ventas", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.BLACK);

        // Subtítulo
        JLabel subtitle = new JLabel("PROYECTO FINAL DE CURSO - MILAGRITOS SANTOS", SwingConstants.CENTER);
        subtitle.setFont(new Font("Arial", Font.BOLD, 14));
        subtitle.setForeground(Color.WHITE);
        subtitle.setOpaque(true);
        subtitle.setBackground(new Color(0, 102, 204));

        // Texto de carga
        JLabel loadingLabel = new JLabel("Cargando sistema...", SwingConstants.CENTER);
        loadingLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        loadingLabel.setForeground(Color.BLACK);

        // Agregar elementos al panel
        panel.add(title, BorderLayout.CENTER);
        panel.add(subtitle, BorderLayout.SOUTH);
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(loadingLabel, BorderLayout.SOUTH);

        // Configuración de la ventana
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        // Temporizador para simular carga y abrir Login después de 3 segundos
        new Timer(3000, e -> {
            ((Timer) e.getSource()).stop();
            abrirLogin();
        }).start();
    }

    private void abrirLogin() {
        dispose(); // Cierra el SplashScreen

        LoginView loginView = new LoginView();
        new LoginController(loginView); // ✔ Esto es lo correcto
        loginView.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SplashScreen::new);
    }
}    

