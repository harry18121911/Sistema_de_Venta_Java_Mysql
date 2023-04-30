/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaConexion;
    import java.sql.*;  
    
    class MysqlCon{  
    public static void main(String args[]){  
    try{  
    Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection(  
    "jdbc:mysql://localhost:3306/sistemaVenta","root","");  
    //here sonoo is database name, root is username and password  
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select * from usuarios;");  
    while(rs.next())  
    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
    con.close();  
    }catch(Exception e){ System.out.println(e);}  
    }  
    }  

