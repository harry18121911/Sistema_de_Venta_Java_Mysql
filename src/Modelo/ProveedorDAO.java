/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.lang.reflect.Array;
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
public class ProveedorDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProveedor(Proveedor pr){
        String sql = "insert into proveedor(dni, nombre, telefono, direccion, razon) values(?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getDni());
            ps.setString(2, pr.getNombre());
            ps.setInt(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getRazon());
            ps.execute();
            return true;
            
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    
    }

    public List ListarProveedor(){
        List<Proveedor> Listapr = new ArrayList();
        String sql = "select * from proveedor";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor pr = new Proveedor();
                pr.setId(rs.getInt("id"));
                pr.setDni(rs.getInt("dni"));
                pr.setNombre(rs.getString("nombre"));
                pr.setTelefono(rs.getInt("telefono"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setRazon(rs.getString("razon"));
                Listapr.add(pr);
            
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        return Listapr;
    }

    public boolean EliminarProveedor(int id){
        String sql = "delete from proveedor where id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return  true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
            System.out.println(e.toString());
            }
        }
    
    }
    
    public boolean ModificarProveedor(Proveedor pr){
        String sql = "update proveedor set dni=?, nombre=?, telefono=?, direccion=?, razon=? where id=?";
        try {          
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getDni());
            ps.setString(2,pr.getNombre());
            ps.setInt(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getRazon());
            ps.setInt(6, pr.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
            System.out.println(e.toString());
            }
        }
    
    }
    
}
