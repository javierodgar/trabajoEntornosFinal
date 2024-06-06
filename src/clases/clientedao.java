/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
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
public class clientedao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    /**
     * metodo que nos permite realizar el registro de un nuevo cliente en nuestra base de datos
     * @param cl
     * @return 
     */
    public boolean registroCliente (cliente cl){
        String sql = "INSERT INTO clientes (dni, nombre, apellido1, apellido2, telefono, direccion) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getApellido1());
            ps.setString(4, cl.getApellido2());
            ps.setInt(5, cl.getTelefono());
            ps.setString(6, cl.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        
    }
    
    /**
     * metodo que nos permite listar todos nuestros clientes en las diferentes tablas de nuestra aplicacion
     * @return 
     */
    public List listaclientes(){
        List<cliente> listaclientes = new ArrayList();
        String sql = " SELECT * FROM CLIENTES";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                cliente cl = new cliente();
                cl.setDni(rs.getString("dni"));
                cl.setNombre(rs.getString("nombre"));
                cl.setApellido1(rs.getString("apellido1"));
                cl.setApellido2(rs.getString("apellido2"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                listaclientes.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listaclientes;
    }
    
    /**
     * metodo que nos permite borra clientes buscandoles mediante su dni
     * @param dni dni del cliente que deseamos borrar
     * @return devulve un true si se ha podido borrar y un false si no se ha podido
     */
    public boolean borrarcliente(String dni){
        String sql = "DELETE FROM clientes WHERE dni LIKE ?";
        String sqldesactivar = "SET FOREIGN_KEY_CHECKS = 0";
        String sqlactivar = "SET FOREIGN_KEY_CHECKS = 1";
        
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sqldesactivar);
            ps.execute();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.execute();
            con = cn.getConection();
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
     * metodo que nos permite relizar modificaciones sobre un determinado cliente buscandole
     * por su dni, devido a esto el dni es el unico valor que no podremos cambiar
     * @param cl los nuevos datos del cliente y el dni
     * @return  true en caso de que la modificacion sea correcta y false en caso de que no lo sea
     */
    public boolean modificarcliente(cliente cl){
        String sql = "UPDATE clientes set nombre=?, apellido1=?, apellido2=?, telefono=?, direccion=? WHERE dni=?";
        
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getApellido1());
            ps.setString(3, cl.getApellido2());
            ps.setInt(4, cl.getTelefono());
            ps.setString(5, cl.getDireccion());
            ps.setString(6, cl.getDni());
            ps.execute();
            return  true;
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
     * metodo que nos permite buscar un cliente por su dni
     * @param dni dni del cliente que deseamos buscar
     * @return nos devuelve un objeto cliente con los datos del cliente solicitado
     */
    public cliente buscarclientepordni(int dni){
        cliente cliente = new cliente();
        String sql = "SELECT * FROM clientes WHERE dni=?";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getInt("telefono"));
            }
        } catch (SQLException e) {
        }
        return cliente;
    }
    
    /**
     * metodoq ue vacia la tabla cliente por completo
     * ¡ATENCION! se borra al cliente aunque este haya realziado compras
     * para esto se desactivan las comprobaciones de las claves foraneas y luego se reactivan
     */
    public void vaciarclientes(){
        String sqldesactivar = "SET FOREIGN_KEY_CHECKS = 0";
        String sqlactivar = "SET FOREIGN_KEY_CHECKS = 1";
        String sql ="DELETE FROM clientes";
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
    
    
}
