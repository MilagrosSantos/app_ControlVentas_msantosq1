/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.DAO;

import com.mycompany.app_controlventas_msantosq.Config.ConexionDB;
import com.mycompany.app_controlventas_msantosq.Model.Categoria;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Milagritos Quintana
 */
public class CategoriaDAO {
    public boolean insertarCategoria(String nombre) {
        try (Connection conn = ConexionDB.conectar();
             CallableStatement stmt = conn.prepareCall("{CALL InsertarCategoria(?)}")) {
            stmt.setString(1, nombre);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("❌ Error al insertar categoría: " + e.getMessage());
            return false;
        }
    }

    public List<Categoria> obtenerCategorias() {
        List<Categoria> lista = new ArrayList<>();
        try (Connection conn = ConexionDB.conectar();
             CallableStatement stmt = conn.prepareCall("{CALL ListarCategorias()}");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("idCategoria"));
                c.setNombre(rs.getString("Nombre"));
                c.setEstado(rs.getBoolean("Estado"));
                lista.add(c);
            }

        } catch (Exception e) {
            System.out.println("❌ Error al obtener categorías: " + e.getMessage());
        }
        return lista;
    }

    public boolean eliminarCategoria(int idCategoria) {
        String sql = "DELETE FROM Categorias WHERE idCategoria = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCategoria);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar categoría: " + e.getMessage());
            return false;
        }
    }

    public boolean editarCategoria(int id, String nuevoNombre, boolean estado) {
        try (Connection conn = ConexionDB.conectar();
             CallableStatement stmt = conn.prepareCall("{CALL EditarCategoria(?, ?, ?)}")) {
            stmt.setInt(1, id);
            stmt.setString(2, nuevoNombre);
            stmt.setBoolean(3, estado);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("❌ Error al editar categoría: " + e.getMessage());
            return false;
        }
    }
    
    public Categoria buscarPorId(int idCategoria) {
        Categoria categoria = null;
        String sql = "SELECT * FROM Categorias WHERE idCategoria = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCategoria);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNombre(rs.getString("Nombre"));
                categoria.setEstado(rs.getBoolean("Estado"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar categoría por ID: " + e.getMessage());
        }
        return categoria;
    }

    // ✅ NUEVO MÉTODO: Cargar categorías al ComboBox
    public void cargarCategoriasEnCombo(JComboBox<Object> combo) {
        combo.removeAllItems(); // Limpiar por si ya hay datos
        combo.addItem("Seleccione una categoría"); // Placeholder

        for (Categoria c : obtenerCategorias()) {
            combo.addItem(c); // Se mostrará el toString()
        }
    
    }
 

}
