/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.sql.*;
import java.time.LocalDate;
import vista.Conexion;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Javier
 */
public class ventadao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int num;
    
    /**
     * metodo que nos permite registrar los datos de una venta en nuestra tabla ventas
     * de la base de datot
     * @param vt datos de la venta a registrar
     * @return devuelve el numero de la venta
     */
    public int registrarventa (venta vt){
        String sql = "INSERT INTO ventas (dnicliente, dniempleado, fecha) VALUES (?, ?, ?)";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, vt.getDnicliente());
            ps.setString(2, vt.getDniempleado());
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return num;
    }
    
    /**
     * metodo que nos permite registar las lineas de una venta en nuestra base de datos
     * @param linea datos de la linea a guardar
     * @return numero de la linea
     */
    public int registrarlineasfactura (lineasfactura linea){
        String sql = "INSERT INTO lineasventas (idlinea, idventa, idproducto, cantidad) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, linea.getIdlinea());
            ps.setInt(2, linea.getIdventa());
            ps.setInt(3, linea.getIdproducto());
            ps.setInt(4, linea.getCantidad());
            ps.execute();
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return num;
    }
    
    /**
     * metodo que nos devuelve el id maximo de venta para evitar que estos se repitan
     * @return id de la venta con mayor id
     */
    public int maxidventa(){
        int idventa = 0;
        String sql = "SELECT MAX(idventa)from ventas";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                idventa = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return idventa;
    }
    
    /**
     * metodo que nos permite listar todas la ventas en cualquiera de nuestras tablas ennuestra interface grafico
     * @return array list de ventas
     */
    public List listarventas(){
        List<venta> listaventas = new ArrayList();
        String sql = "SELECT * FROM ventas";
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                venta vnt = new venta();
                vnt.setIdVenta(rs.getInt("idventa"));
                vnt.setDnicliente(rs.getString("dnicliente"));
                vnt.setDniempleado(rs.getString("dniempleado"));
                listaventas.add(vnt);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listaventas;
    }
    
    /**
     * metodo empleado para refrescar el stck de un producto cuando este se agrega a una venta
     * @param stk nuevo stock del producto
     * @param idproducto id del producto a actualizar
     * @return  nos devuelve un true si se ha completado con exito y un flase si no se ha podido completar
     */
    public boolean refrescarstock (int stk, int idproducto){
        String sql = "UPDATE productos SET stock = ? WHERE idproducto = ?";
        
        try {
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stk);
            ps.setInt(2, idproducto);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
