/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_controlventas_msantosq.DAO;

import com.mycompany.app_controlventas_msantosq.Config.ConexionDB;
import com.mycompany.app_controlventas_msantosq.Model.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milagritos Quintana
 */
public class VentaDAO {
    /**
 *
   // ✅ 1. Listar ventas por fecha
    public List<Venta> obtenerVentasPorFecha(LocalDate fecha) {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM ventas WHERE DATE(fecha) = ?";
        try (Connection connection = ConexionDB.conectar();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Venta v = new Venta();
                v.setCodVenta(rs.getInt("codVenta"));
                v.setCodCliente(rs.getInt("CodCliente"));
                v.setCodProducto(rs.getInt("codProducto"));
                v.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                v.setTotal(rs.getDouble("Total"));
                v.setDescuento(rs.getDouble("descuento"));
                v.setMetPago(rs.getString("metPago"));
                lista.add(v);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener ventas por fecha: " + e.getMessage());
        }
        return lista;
    }

    // ✅ 2. Listar todas las ventas
    public List<Venta> listarVentas() {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM ventas";
        try (Connection connection = ConexionDB.conectar();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setCodVenta(rs.getInt("codVenta"));
                venta.setCodCliente(rs.getInt("CodCliente"));
                venta.setCodProducto(rs.getInt("codProducto"));
                venta.setTotal(rs.getDouble("Total"));
                venta.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                venta.setDescuento(rs.getDouble("descuento"));
                venta.setMetPago(rs.getString("metPago"));
                ventas.add(venta);
            }
        } catch (SQLException e) {
            System.out.println(" Error al listar ventas: " + e.getMessage());
        }
        return ventas;
    }

    // ✅ 3. Insertar venta con detalles
    public boolean insertarVentaConDetalles(Venta venta, List<Object[]> detalles) {
        String sqlVenta = "INSERT INTO ventas (CodCliente, codProducto, metodo_pago, fecha, Total, descuento) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlDetalle = "INSERT INTO detalles_venta (venta_id, producto, cantidad, precio) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConexionDB.conectar();
             PreparedStatement psVenta = connection.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS)) {

            psVenta.setInt(1, venta.getCodCliente());
            psVenta.setInt(2, venta.getCodProducto());
            psVenta.setString(3, venta.getMetPago());
            psVenta.setTimestamp(4, Timestamp.valueOf(venta.getFecha()));
            psVenta.setDouble(5, venta.getTotal());
            psVenta.setDouble(6, venta.getDescuento());

            int filas = psVenta.executeUpdate();

            if (filas > 0) {
                ResultSet rs = psVenta.getGeneratedKeys();
                if (rs.next()) {
                    int ventaId = rs.getInt(1);
                    try (PreparedStatement psDetalle = connection.prepareStatement(sqlDetalle)) {
                        for (Object[] d : detalles) {
                            psDetalle.setInt(1, ventaId);
                            psDetalle.setString(2, (String) d[0]);
                            psDetalle.setInt(3, (Integer) d[1]);
                            psDetalle.setDouble(4, (Double) d[2]);
                            psDetalle.addBatch();
                        }
                        psDetalle.executeBatch();
                    }
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(" Error al insertar venta con detalles: " + e.getMessage());
        }
        return false;
        
    }
    
     */
}
