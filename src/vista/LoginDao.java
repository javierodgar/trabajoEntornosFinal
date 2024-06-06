/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
/**
 * clase logindao que nos permite gestionar los login
 * dentro de nuestra aplicacion
 * @author Javier
 */
public class LoginDao {
    /*
    preparamos lo necesario para lanzar las consultas a nuestra base de datos
    en este caso utilizaremos la clase connectio, preparedStatement y resutlset
    ademas de nuestra clase conexion
    */
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    /**
     * metodo encargado de lanzar el login contra la base de datos
     * @param nombre nombre del empleado que se esta intentando logear
     * @param contraseña contraseña del empleado que se esta intentando logear
     * @return 
     */
    public Login_1 log(String nombre, String contraseña){
    Login_1 l = new Login_1();
    String sql = "Select * from empleados where nombre = ? and contraseña = ?";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            if (rs.next()) {
                //recogemos los datos que van a ser necesarios dentro de un objeto login llamado l
                l.setDni(rs.getString("dni"));
                l.setNombre(rs.getString("nombre"));
                l.setContraseña(rs.getString("contraseña"));
                l.setRango(rs.getString("rango"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
    
    /**
     * metodo encargado de encriptar las contraseñas en nuestra base de dats
     * @param password
     * @return 
     */
    public String Encriptar(String password) {
        try {
            // Crear un objeto MessageDigest para SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
 
            // Aplicar el algoritmo de hash a la contraseña
            byte[] hash = digest.digest(password.getBytes());
 
            // Convertir el hash byte[] a una cadena hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
