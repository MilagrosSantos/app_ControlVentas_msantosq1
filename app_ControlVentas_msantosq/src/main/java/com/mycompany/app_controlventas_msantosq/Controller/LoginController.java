/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Controller;

import com.mycompany.app_controlventas_msantosq.DAO.LoginDAO;
import com.mycompany.app_controlventas_msantosq.Model.Usuario;
import com.mycompany.app_controlventas_msantosq.view.LoginView;
import javax.swing.JOptionPane;
import com.mycompany.app_controlventas_msantosq.view.MainView;


/**
 *
 * @author Milagritos Quintana
 */
public class LoginController {
    private LoginView loginView;
    private LoginDAO loginDAO;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.loginDAO = new LoginDAO();

        this.loginView.addLoginListener(() -> validarUsuario());
    }

    private void validarUsuario() {
        String usuario = loginView.getUsername();
        String password = loginView.getPassword();

        Usuario user = loginDAO.validarLogin(usuario, password);

        if (user != null) {
        JOptionPane.showMessageDialog(loginView, "Inicio de sesión exitoso");

        // ABRIR LA VENTANA PRINCIPAL
        MainView mainView = new MainView();
        mainView.setVisible(true);

        // CERRAR la ventana de login
        loginView.dispose();

    } else {
        JOptionPane.showMessageDialog(loginView, "Usuario o contraseña incorrectos");
    }
    }

}