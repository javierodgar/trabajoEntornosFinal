/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import vista.Conexion;

/**
 *
 * @author Javier
 */
public class proovedordao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    /**
     * metodo que nos permite registrar un nuevo proovedor
     * @param pv datos del producto que deseamos guardar
     * @return  nos devuelve un true si se ha completado con exito y un flase si no se ha podido completar
     */
    public boolean registrarproovedor(proovedor pv){
        String sql = "INSERT INTO proovedor (nif, nombre, telefono, email, direccion) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pv.getNif());
            ps.setString(2, pv.getNombre());
            ps.setInt(3, pv.getTelefono());
            ps.setString(4, pv.getEmail());
            ps.setString(5, pv.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(proovedordao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    /**
     * metodo que nos permite listar nuestros proovedores en cualquiera de nuestrar tablas dentro del interface grafico
     * @return nos devuelve un array lis de proovedores
     */
    public List listarproovedores(){
        List<proovedor> listapro = new ArrayList();
        String sql = "SELECT * FROM proovedor";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                proovedor pro = new proovedor();
                pro.setNif(rs.getString("nif"));
                pro.setNombre(rs.getString("nombre"));
                pro.setTelefono(rs.getInt("telefono"));
                pro.setEmail(rs.getString("email"));
                pro.setDireccion(rs.getString("direccion"));
                listapro.add(pro);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listapro;
    }
    
    /**
     * metodo que nos permite borrar un proovedor buscandolo en la base de datos por su nif
    */
    public boolean borrarproovedores (String nif){
        String sql="DELETE FROM proovedor WHERE nif like ?";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nif);
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
     * metodo que nos permite modificar todos los datos de un determinado proovedor
     * menos el nif ya que la bsuqeuda se realiza mediante ese campo ademas de que este 
     * es la primary key de nuestra base de datos
     * @param pro datos del proovedor
     * @return nos devuelve un true si se ha completado con exito y un flase si no se ha podido completar
     */
    public boolean actualizarproovedores (proovedor pro){
        String sql = "UPDATE proovedor SET nombre=?, telefono=?, email=?, direccion=? WHERE nif=?";
        
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setInt(2, pro.getTelefono());
            ps.setString(3, pro.getEmail());
            ps.setString(4, pro.getDireccion());
            ps.setString(5, pro.getNif());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(proovedordao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
