/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Javier
 */
public class Conexion {
    
    Connection con;
    
    /**
     * metodo que nos permite realizar la conexion con la base de datos
     * @return nos devuelve un objeto conection que representa la conexion exitosa
     */
    public Connection getConection(){
        try {
            String mydb = "jdbc:mysql://localhost:3306/tfg?serverTimezone=UTC";
            con = DriverManager.getConnection(mydb, "javi", "javi");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
