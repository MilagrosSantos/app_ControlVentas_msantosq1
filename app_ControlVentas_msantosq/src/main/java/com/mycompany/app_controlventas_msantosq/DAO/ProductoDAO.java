/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.DAO;

import com.mycompany.app_controlventas_msantosq.Config.ConexionDB;
import com.mycompany.app_controlventas_msantosq.Model.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milagritos Quintana
 */

public class ProductoDAO {
   // ✅ 1. Insertar producto
     public boolean insertarProducto(Producto p) {
        String sql = "CALL sp_insertar_producto(?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getCodProducto());
            stmt.setString(2, p.getNombre());
            stmt.setString(3, p.getCodigo());
            stmt.setDouble(4, p.getPrecio());
            stmt.setInt(5, p.getStock());
            stmt.setInt(6, p.getIdCategoria());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar producto: " + e.getMessage());
            return false;
        }
    }

    // ✅ 2. Listar productos
    public List<Producto> listarProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Productos";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setCodProducto(rs.getString("codProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setCodigo(rs.getString("codigo"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setIdCategoria(rs.getInt("idCategoria"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar productos: " + e.getMessage());
        }
        return lista;
    }

    // ✅ 3. Editar producto
    public boolean editarProducto(Producto p) {
        String sql = "UPDATE Productos SET nombre = ? WHERE codProducto = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getCodProducto());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al editar producto: " + e.getMessage());
            return false;
        }
    }

    // ✅ 4. Actualizar stock directamente
    public boolean actualizarStock(Producto producto) {
        String sql = "UPDATE productos SET stock = ? WHERE codProducto = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, producto.getStock());
            stmt.setString(2, producto.getCodProducto());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // ✅ 5. Eliminar producto
    public boolean eliminarProducto(String codProducto) {
        String sql = "DELETE FROM Productos WHERE codProducto = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codProducto);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }

    // ✅ 6. Buscar producto por nombre
    public Producto buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM Productos WHERE nombre = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Producto p = new Producto();
                    p.setCodProducto(rs.getString("codProducto"));
                    p.setNombre(rs.getString("nombre"));
                    p.setCodigo(rs.getString("codigo"));
                    p.setPrecio(rs.getDouble("precio"));
                    p.setStock(rs.getInt("stock"));
                    p.setIdCategoria(rs.getInt("idCategoria"));
                    return p;
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar producto por nombre: " + e.getMessage());
        }
        return null;
    }

    // ✅ 7. Reducir stock después de una venta
    public boolean reducirStock(String codProducto, int cantidadVendida) {
        String sql = "UPDATE Productos SET stock = stock - ? WHERE codProducto = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cantidadVendida);
            stmt.setString(2, codProducto);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al reducir stock: " + e.getMessage());
            return false;
        }
    }
    
    public double obtenerPrecioProducto(String nombreProducto) {
         double precio = 0.0;
         // Lógica para obtener el precio desde la base de datos, usando JDBC o JPA
         // Ejemplo con JDBC
         String sql = "SELECT precio FROM productos WHERE nombre = ?";
         try (Connection con = getConnection();
              PreparedStatement stmt = con.prepareStatement(sql)) {
             stmt.setString(1, nombreProducto);
             ResultSet rs = stmt.executeQuery();
             if (rs.next()) {
                 precio = rs.getDouble("precio");
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return precio;
     }
    public List<String> obtenerNombresProductos() {
        List<String> productos = new ArrayList<>();
        // Lógica para obtener los nombres de los productos desde la base de datos
        return productos;
    }

     // Método para obtener la conexión (ajústalo según tu implementación)
     private Connection getConnection() throws SQLException {
         return DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_de_datos", "usuario", "contraseña");
     }

}