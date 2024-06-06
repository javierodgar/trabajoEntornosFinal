/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import vista.Conexion;

/**
 *
 * @author Javier
 */
public class productosdao {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    /**
     * metodo que nos permite registrar un neuvo producto en nuestra base de datos
     * @param product objeto producto con los datos de nuestro nuevo producto
     * @return  true si el producto se guarda con exito, false en caso contrario
     */
    public boolean registrarproductos (productos product){
        String sql = "INSERT productos(nombre,descripcion,precio,stock,nif,idcat) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getNombre());
            ps.setString(2, product.getDescripcion());
            ps.setDouble(3, product.getPrecio());
            ps.setInt(4, product.getStock());
            ps.setInt(5, product.getNif());
            ps.setInt(6, product.getIdcat());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    /**
     * metodoq que nos permite listar nuestros productos en cualquiera de nuestrar tablas 
     * dentro del interface grafico
     * @return una lista con todos nuestros productos
     */
    public List listaproductos(){
        List<productos> listaproductos = new ArrayList();
        String sql = "select * from productos";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                productos po = new productos();
                po.setIDProducto(rs.getInt("idproducto"));
                po.setNombre(rs.getString("nombre"));
                po.setDescripcion(rs.getString("descripcion"));
                po.setPrecio(rs.getDouble("precio"));
                po.setStock(rs.getInt("stock"));
                po.setNif(rs.getInt("nif"));
                po.setIdcat(rs.getInt("idcat"));
                listaproductos.add(po);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listaproductos;
    }
    
    /**
     * muestra los nuf de todos nuestros probedores en un jcombobox
     * esto nos permite registrar un producto de una forma mas sencilla
     * @param proovedor 
     */
    public void consultar_proovedor (JComboBox proovedor){
        String sql = "select nif from proovedor";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {            
                proovedor.addItem(rs.getString("nif"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    /**
     * similar al metodo consultar_proovedor pero para las categorias
     * @param categoriasBox 
     */
    public void consultar_categorias (JComboBox categoriasBox) {
        String sql ="select idcat from categorias";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                categoriasBox.addItem(rs.getInt("idcat"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString()); 
        }
    }
    
    /**
     * metodo que nos permite modificar los datos de un producto, para esto usamos
     * el id del producto para localizarle por lo que este no se puede cambiar
     * @param proc nueva informacion del producto y su id para localizarle
     * @return true en caso de que se realiza correctamente la modificacion, false en caso contrario
     */
    public boolean modifacarpproducto (productos proc) {
        String sql = "UPDATE productos set nombre=?, descripcion=?, precio=?, stock=?, nif=?, idcat=? WHERE idProducto=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, proc.getNombre());
            ps.setString(2, proc.getDescripcion());
            ps.setDouble(3, proc.getPrecio());
            ps.setInt(4, proc.getStock());
            ps.setInt(5, proc.getNif());
            ps.setInt(6, proc.getIdcat());
            ps.setInt(7, proc.getIDProducto());
            ps.executeUpdate();
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
     * metodo que nos permite buscar un producto por su id y obtener toda su informacion
     * @param idproducto id del producto que deseamos localicas
     * @return nos devulve un objeto producto con los datos del producto solicitado
     */
    public productos busacarproductoporid (int idproducto){
        productos product = new productos();
        
        String sql = "SELECT * FROM productos WHERE idproducto =?";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idproducto);
            rs = ps.executeQuery();
            if (rs.next()) {
                product.setNombre(rs.getString("nombre"));
                product.setDescripcion(rs.getString("descripcion"));
                product.setPrecio(rs.getDouble("precio"));
                product.setStock(rs.getInt("stock"));
                product.setNif(rs.getInt("nif"));
                product.setIdcat(rs.getInt("idcat"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return product;
    }
    
    /**
     * metodo que nos permite borrar un producto buscandolo por su id
     * @param idproducto id del producto el cual se va a borrar
     * @return nos devuelve un true si se ha completado con exito y un flase si no se ha podido completar
     */
    public boolean borrarproducto (String idproducto){
        String sql = "DELETE FROM productos WHERE idproducto LIKE ?";
        String sqldesactivar = "SET FOREIGN_KEY_CHECKS = 0";
        String sqlactivar = "SET FOREIGN_KEY_CHECKS = 1";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sqldesactivar);
            ps.execute();
            ps = con.prepareStatement(sql);
            ps.setString(1, idproducto);
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
    
}
