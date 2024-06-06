/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Javier
 */
public class lineasfactura {
    private int idlinea;
    private int idventa;
    private int idproducto;
    private int cantidad;

    public lineasfactura() {
    }

    public lineasfactura(int idlinea, int idventa, int idproducto, int cantidad) {
        this.idlinea = idlinea;
        this.idventa = idventa;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
    }

    public int getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(int idlinea) {
        this.idlinea = idlinea;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
