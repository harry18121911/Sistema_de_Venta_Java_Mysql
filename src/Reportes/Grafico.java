/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author harry
 */
public class Grafico {
    public static void Graficar (String fecha) {
        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            String sql = "select total from ventas where fecha =?";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha);
            rs = ps.executeQuery();
            DefaultPieDataset dataset = new DefaultPieDataset();
            while (rs.next()){
                dataset.setValue(rs.getString("total"), rs.getDouble("total"));
            }
            JFreeChart jf = ChartFactory.createPieChart("Reporte de ventas", dataset);
            ChartFrame f = new ChartFrame("Total de ventas por dia", jf);
            f.setSize(1000, 500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    
    }
    
}
