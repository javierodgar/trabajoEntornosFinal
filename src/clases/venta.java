/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Javier
 */
public class venta {
    private int IdVenta;
    private String dnicliente;
    private String dniempleado;

    public venta() {
    }

  
    public venta(int IdVenta, String dnicliente, String dniempleado) {
        this.IdVenta = IdVenta;
        this.dnicliente = dnicliente;
        this.dniempleado = dniempleado;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public String getDnicliente() {
        return dnicliente;
    }

    public void setDnicliente(String dnicliente) {
        this.dnicliente = dnicliente;
    }

    public String getDniempleado() {
        return dniempleado;
    }

    public void setDniempleado(String dniempleado) {
        this.dniempleado = dniempleado;
    }
    
    
    
}
