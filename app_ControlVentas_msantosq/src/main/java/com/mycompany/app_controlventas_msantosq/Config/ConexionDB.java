/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Milagritos Quintana
 */
public class ConexionDB {

    
    private static final String URL = "jdbc:mysql://localhost:3306/App_ControlVentas_msantosq";
    private static final String USER = "root";
    private static final String PASSWORD = "MySecurePass123!";

    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Conexión exitosa a la base de datos MySQL.");
        } catch (SQLException e) {
            System.out.println(" Error al conectar con MySQL: " + e.getMessage());
        }
        return conn;
    }
}