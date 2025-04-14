
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.DAO;

import com.mycompany.app_controlventas_msantosq.Config.ConexionDB;
import com.mycompany.app_controlventas_msantosq.Model.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Milagritos Quintana
 */
public class ClienteDAO {
    public boolean dniExiste(int dni) {
        String sql = "SELECT COUNT(*) FROM clientes WHERE dni = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, dni);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Cliente> listarClientes() {
    List<Cliente> lista = new ArrayList<>();
    try (Connection conn = ConexionDB.conectar();
         CallableStatement stmt = conn.prepareCall("{CALL sp_listarClientes()}");
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Cliente c = new Cliente();
            c.setCodCliente(rs.getString("codCliente"));
            c.setNombre(rs.getString("nombre"));
            c.setDni(rs.getInt("dni"));
            c.setTelefono(rs.getInt("telefono"));
            lista.add(c);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista;
}

    public boolean eliminarCliente(String codCliente) {
        try (Connection conn = ConexionDB.conectar();
             CallableStatement stmt = conn.prepareCall("{CALL sp_eliminarCliente(?)}")) {
            stmt.setString(1, codCliente);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean editarCliente(Cliente cliente) {
        try (Connection conn = ConexionDB.conectar();
             CallableStatement stmt = conn.prepareCall("{CALL sp_editarCliente(?, ?, ?, ?)}")) {
            stmt.setString(1, cliente.getCodCliente());
            stmt.setString(2, cliente.getNombre());
            stmt.setInt(3, cliente.getDni());
            stmt.setInt(4, cliente.getTelefono());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public String obtenerCodigoPorNombre(String nombre) {
    String sql = "SELECT codCliente FROM Clientes WHERE nombre = ?";
    try (Connection conn = ConexionDB.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nombre);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("codCliente");
        }
    } catch (SQLException e) {
        System.out.println("❌ Error al obtener codCliente por nombre: " + e.getMessage());
    }
    return null;
}

     public List<String> obtenerNombresClientes() {
        List<String> nombres = new ArrayList<>();
        // Lógica para obtener los nombres de los clientes desde la base de datos
        return nombres;
    }

    // Inserta el cliente, solo si el DNI no está repetido
    public boolean insertarCliente(Cliente cliente, javax.swing.JFrame vista) {
        if (dniExiste(cliente.getDni())) {
            JOptionPane.showMessageDialog(vista, "El DNI ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String sql = "{CALL sp_insertar_cliente(?, ?, ?, ?)}";
        try (Connection conn = ConexionDB.conectar();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, cliente.getCodCliente());
            stmt.setString(2, cliente.getNombre());
            stmt.setInt(3, cliente.getDni());
            stmt.setInt(4, cliente.getTelefono());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { // Código de error para clave duplicada en MySQL
                JOptionPane.showMessageDialog(vista, "DNI ya registrado (verificado desde la base de datos).", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                e.printStackTrace();
                JOptionPane.showMessageDialog(vista, "Error al guardar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
    }
    
}
