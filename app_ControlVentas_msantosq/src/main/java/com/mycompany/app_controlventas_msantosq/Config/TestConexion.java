/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.Config;

/**
 *
 * @author Milagritos Quintana
 */
public class TestConexion {
    public static void main(String[] args) {
        if (ConexionDB.conectar() != null) {
            System.out.println(" Conexión correcta (desde TestConexion).");
        } else {
            System.out.println("Conexión fallida (desde TestConexion).");
        }
    }
}
