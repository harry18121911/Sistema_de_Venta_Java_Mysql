/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author harry
 */
public class VentaDAO {
        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        int r;
    public int RegistrarVenta(Venta v) {
        
        String sql = "insert into ventas (cliente, vendedor, total) values (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getCliente());
            ps.setString(2, v.getVendedor());
            ps.setDouble(3, v.getTotal());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return r;
    }

}
