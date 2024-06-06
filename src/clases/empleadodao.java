/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import vista.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author Javier
 */
public class empleadodao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    /**
     * metodo que nos permite buscar un empleado en nuestra base de datos atraves de unicamente su dni
     * @param dni dni del empleado que deseamos localizar
     * @return nos decuelce todos los datos del empleado con el dni mandado al metodo
     */
    public empleado buscarempleadopordni (int dni){
        empleado emp = new empleado();
        String sql = "SELECT * FROM empleados WHERE dni=?";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                emp.setDni(rs.getString("dni"));
                emp.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return emp;
    }
    
    /**
     * metodo que nos permite registrar un nuevo empleado en nuestra base de datos
     * @param emp objeto empleado que enviamos al metodo, este contendra los datos del nuevo empleado
     * @return  nos devuelve un true si se ha completado con exito y un flase si no se ha podido completar
     */
    public boolean registroempleado (empleado emp) {
        String sql = "INSERT INTO empleados (dni, nombre, apellido1, apellido2, telefono, direccion, sueldo, contraseña, rango) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getDni());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellido1());
            ps.setString(4, emp.getApellido2());
            ps.setInt(5, emp.getTelefono());
            ps.setString(6, emp.getDireccion());
            ps.setInt(7, emp.getSueldo());
            ps.setString(8, emp.getContraseña());
            ps.setString(9, emp.getRango());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    /**
     * metodo que nos permite listar nuestros empleados en cualquiera de nuestras tablas
     * en nuestro interface grafico
     * @return un array list de empleados
     */
    public List listarempleados(){
        List<empleado> listaempleados = new ArrayList();
        String sql = "SELECT * FROM empleados";
        
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado emp = new empleado();
                emp.setDni(rs.getString("dni"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido1(rs.getString("apellido1"));
                emp.setApellido2(rs.getString("apellido2"));
                emp.setTelefono(rs.getInt("telefono"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setSueldo(rs.getInt("sueldo"));
                emp.setRango(rs.getString("rango"));
                listaempleados.add(emp);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listaempleados;
    }
    
    /**
     * metodo que borra un empleado atraves de su dni
     * ¡ATENCION! se borrara al empleado aunque tenga ventas a su dni
     * para esto se desactivan las claves foraneas
     * @param dni es el dni del empleado que se desea borrar
     * @return 
     */
    public boolean borrarempleado(String dni){
        String sqldesactivar = "SET FOREIGN_KEY_CHECKS = 0";
        String sqlactivar = "SET FOREIGN_KEY_CHECKS = 1";
        String sql = "DELETE FROM empleados WHERE dni LIKE ?";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sqldesactivar);
            ps.execute();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.execute();
            ps = con.prepareStatement(sqlactivar);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    /**
     * metodo que nos permite modificar todos los datos de un empleado
     * a excepcion del dni ya que este es el campo que se utilizara para 
     * buscar al empleado y es la primary key en nuestra base de datos
     * @param emp le pasamos los nuevos datos del empleado (el dni ya se debe de ecnontrar en la base de datos)
     * @return nos devuelve un true si se ha completado con exito y un flase si no se ha podido completar
     */
    public boolean modificarempleado (empleado emp) {
        String sql = "UPDATE empleados SET nombre=?, apellido1=?, apellido2=?, telefono=?, direccion=?, sueldo=?, rango=?, contraseña=? WHERE dni LIKE ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellido1());
            ps.setString(3, emp.getApellido2());
            ps.setInt(4, emp.getTelefono());
            ps.setString(5, emp.getDireccion());
            ps.setInt(6, emp.getSueldo());
            ps.setString(7, emp.getRango());
            ps.setString(8, emp.getContraseña());
            ps.setString(9, emp.getDni());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return  false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    /**
     * metodo que nos permite vaciar por completo la tabla de empleados
     * en nuestra base de datos, se recomienda usarlo con precaucion ya que borrara
     * todos independientemente de si tienen o no tienen ventas
     */
    public void vaciarempleaados (){
        String sqldesactivar = "SET FOREIGN_KEY_CHECKS = 0";
        String sqlactivar = "SET FOREIGN_KEY_CHECKS = 1";
        String sql ="DELETE FROM empleados";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sqldesactivar);
            ps.execute();
            ps = con.prepareStatement(sql);
            ps.execute();
            ps = con.prepareStatement(sqlactivar);
            ps.execute();
        } catch (SQLException e) {
        }
    }
    
    /**
     * metodo utilizado ara encriptar la contraseña que vamos a guardar en nuestra base de datos
     * en mi caso tambien le utilizo para comprobar la conraseña en el login 
     * @param password contraseña a encriptar
     * @return contraseña ecnriptada
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
