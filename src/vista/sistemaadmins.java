/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;
import clases.*;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Image;
/**
 *
 * @author Javier
 */
public class sistemaadmins extends javax.swing.JFrame {

    /**
     * Creates new form sistema
     */
    
    //declaramos un objeto producto y un objeto productodao
    productos product = new productos();
    productosdao productdao = new productosdao();
    
    //declaramos un onjeto venta y un objeto ventadao
    venta vt = new venta();
    ventadao vtdao = new ventadao();
    
    //declaramos un objeto lineasfactura
    lineasfactura lf = new lineasfactura();
    
    //declaramos a un objeto cliente y un clientedao
    cliente cl = new cliente();
    clientedao cldao = new clientedao();
    
    //declaramos un objeto proovedor y un objeto proovedordao
    proovedor pro = new proovedor();
    proovedordao prodao = new proovedordao();
    
    //declaramos un empleado y un empleaadodao
    empleado emp = new empleado();
    empleadodao empdao = new empleadodao();
    
    //Declaramos un defaulttablemodel llamado tabla
    DefaultTableModel tabla = new DefaultTableModel();
    
    //declaramos una variable para llevar la cuenta de los productos que agregamos a cada venta
    int item;
    //declaramos una variable para llevar la cuenta del total de cada venta
    double totalpagar = 0.0;
    /**
     * iniciamos los componentes y centramos la pantalla en el centro
     */
    public sistemaadmins() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/fruteria (1).png")).getImage());
        this.setLocationRelativeTo(null);
        productdao.consultar_proovedor(listaprovedores);
        productdao.consultar_categorias(listaidcatproducto);
    }
    
    /**
     * metodo que nos permite listar los clientes en una tabla dentro de nuestro interface grafico
     */
    public void listarclientes(){
        List<cliente> listarcl = cldao.listaclientes();
        tabla = (DefaultTableModel) tablacliente.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < listarcl.size(); i++) {
            ob[0] = listarcl.get(i).getDni();
            ob[1] = listarcl.get(i).getNombre();
            ob[2] = listarcl.get(i).getApellido1();
            ob[3] = listarcl.get(i).getApellido2();
            ob[4] = listarcl.get(i).getTelefono();
            ob[5] = listarcl.get(i).getDireccion();
            tabla.addRow(ob);
        }
        tablacliente.setModel(tabla);
    }
    
    /**
     * metodo similar a listarclientes nos permite mostrar nuestro proovedores dentro de una tabla en nuestro interface grafico
     */
    public void listarproovedores(){
        List<proovedor> listarpro = prodao.listarproovedores();
        tabla = (DefaultTableModel) tablaproovedores.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < listarpro.size(); i++) {
            ob[0] = listarpro.get(i).getNif();
            ob[1] = listarpro.get(i).getNombre();
            ob[2] = listarpro.get(i).getTelefono();
            ob[3] = listarpro.get(i).getEmail();
            ob[4] = listarpro.get(i).getDireccion();
            tabla.addRow(ob);
        }
        tablaproovedores.setModel(tabla);
    }
    
    /**
     * metodo similar a listarclientes que nos permite listar los productos dentro de una tabla en nuestro interface grafico
     */
    public void listarproductos(){
        List<productos> listaproduct = productdao.listaproductos();
        tabla = (DefaultTableModel) tablaproductos.getModel();
        Object[] ob = new Object[7];
        for (int i= 0; i < listaproduct.size(); i++) {
            ob[0] = listaproduct.get(i).getIDProducto();
            ob[1] = listaproduct.get(i).getNombre();
            ob[2] = listaproduct.get(i).getDescripcion();
            ob[3] = listaproduct.get(i).getPrecio();
            ob[4] = listaproduct.get(i).getStock();
            ob[5] = listaproduct.get(i).getNif();
            ob[6] = listaproduct.get(i).getIdcat();
            tabla.addRow(ob);
        }
        tablaproductos.setModel(tabla);
    }
    
    /**
     * metodo que nos permite listar los empleadosa en su tabla en nuestro interface grafico
     */
    public void listarempleados(){
         List<empleado> listaempleados = empdao.listarempleados();
         tabla = (DefaultTableModel) tablaempleados.getModel();
         Object[] ob = new Object[8];
         for (int i = 0; i < listaempleados.size(); i++) {
            ob[0] = listaempleados.get(i).getDni();
            ob[1] = listaempleados.get(i).getNombre();
            ob[2] = listaempleados.get(i).getApellido1();
            ob[3] = listaempleados.get(i).getApellido1();
            ob[4] = listaempleados.get(i).getTelefono();
            ob[5] = listaempleados.get(i).getDireccion();
            ob[6] = listaempleados.get(i).getSueldo();
            ob[7] = listaempleados.get(i).getRango();
            tabla.addRow(ob);
        }
         tablaempleados.setModel(tabla);
    }
    
   
    
    /**
     * metodo que nos permite limpiar las tablas de nuestro interface grafico,
     * para, esto nos permite 
     */
    public void limpiartabla(){
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.removeRow(i);
            i = i - 1;
        }
    }
    
    /**
     * metodo que nos permite limpiar los campos de texto del interface grafico del apartado de clientes
     */
    public void limpiarcliente(){
        txtdnicliente.setText("");
        txtnombecliente.setText("");
        txtapellido1.setText("");
        txtapellido2.setText("");
        inttelefonocliente.setText("");
        txtdireccioncliente.setText("");
    }
     /**
      * metodo que nos permite limpiar los campos de texto del interface grafico del apartado de proovedores
      */
    public void limpiarproovedor(){
        txtnifproovedor.setText("");
        txtnombreproovedor.setText("");
        txttelefonoproovedor.setText("");
        txtemailproovedor.setText("");
        txtdireccionproovedor.setText("");
    }
    
    /**
    * metodo que nos permite limpiar los campos de texto del interface grafico del apartado de productos
    */
    public void limpiarproducto(){
        tctidproduct.setText("");
        txtnombreproduct.setText("");
        txtdescripcionpro.setText("");
        txtprecioproduct.setText("");
        txtcantidadproduct.setText("");
    }
    
    /**
     * metodo que nos permite limpiar los datos de los parametros de una venta
     */
    public void limpiarventa(){
        codigoventatxt.setText("");
        nombreproductoventatxt.setText("");
        precioventatxt.setText("");
        descripcionventatxt.setText("");
        cantidadventatxt.setText("");
        stocktxt.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtidventas = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        productosç = new javax.swing.JButton();
        botonclientes = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        gestion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botoneliminarventa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventa = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        botongenerarventa = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        totalventa = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        dniventatxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        nombreventatxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        telefonoclienteventa = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        direccionclienteventa = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtdniempleadoo = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtnombrempleadoventa = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        codigoventatxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nombreproductoventatxt = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        descripcionventatxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cantidadventatxt = new javax.swing.JTextField();
        precioventatxt = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        stocktxt = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaproductos = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        tctidproduct = new javax.swing.JTextField();
        txtnombreproduct = new javax.swing.JTextField();
        txtdescripcionpro = new javax.swing.JTextField();
        txtcantidadproduct = new javax.swing.JTextField();
        txtprecioproduct = new javax.swing.JTextField();
        listaprovedores = new javax.swing.JComboBox<>();
        listaidcatproducto = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        btnguardarproduct = new javax.swing.JButton();
        btnactualizarproduct = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        btneliminarproduct = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablacliente = new javax.swing.JTable();
        btneliminarcliente = new javax.swing.JButton();
        btnguardarcliente = new javax.swing.JButton();
        btnnuevocliente = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtdnicliente = new javax.swing.JTextField();
        txtnombecliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtapellido1 = new javax.swing.JTextField();
        txtapellido2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        inttelefonocliente = new javax.swing.JTextField();
        txtdireccioncliente = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        btnguardarcliente2 = new javax.swing.JButton();
        btneditarcliente2 = new javax.swing.JButton();
        btneliminarcliente2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaproovedores = new javax.swing.JTable();
        btnguardarproovedor = new javax.swing.JButton();
        btnactualizarproovedor = new javax.swing.JButton();
        btneliminarproovedor = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtnifproovedor = new javax.swing.JTextField();
        txtnombreproovedor = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txttelefonoproovedor = new javax.swing.JTextField();
        txtemailproovedor = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtdireccionproovedor = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaempleados = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        txtcontraseñaempleado = new javax.swing.JPasswordField();
        contraseñaempleado = new javax.swing.JLabel();
        rangoempleado = new javax.swing.JLabel();
        txtrangoempleado = new javax.swing.JTextField();
        txtsueldoempleado = new javax.swing.JTextField();
        sueldoempleado = new javax.swing.JLabel();
        direccionempleado = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        txttelefonoempleado = new javax.swing.JTextField();
        telefonoempleado = new javax.swing.JLabel();
        apellido2empleado = new javax.swing.JLabel();
        txtapellidoempleado2 = new javax.swing.JTextField();
        txtapellidoempleado = new javax.swing.JTextField();
        apellido1empleado = new javax.swing.JLabel();
        nombreempleado = new javax.swing.JLabel();
        txtnombreempleado = new javax.swing.JTextField();
        txtdniempleado = new javax.swing.JTextField();
        dniempleado = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btneliminarempleado = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fruteria (1).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel27.setText("sistema de gestion de ventas");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, -1, -1));

        jLabel29.setText("trabajo final programacion ");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, -1, -1));

        jLabel44.setText("Javier Rodrioguez Garrido");
        jPanel2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 670));

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(204, 255, 204));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productosç.setBackground(new java.awt.Color(0, 153, 0));
        productosç.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/frutas.png"))); // NOI18N
        productosç.setBorder(null);
        productosç.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosçActionPerformed(evt);
            }
        });
        jPanel13.add(productosç, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 120, 90));

        botonclientes.setBackground(new java.awt.Color(0, 153, 0));
        botonclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/usuario (1).png"))); // NOI18N
        botonclientes.setBorder(null);
        botonclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonclientesActionPerformed(evt);
            }
        });
        jPanel13.add(botonclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 120, 90));

        jButton3.setBackground(new java.awt.Color(0, 153, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/suministrar.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 110, 90));

        gestion.setBackground(new java.awt.Color(0, 153, 0));
        gestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/configuraciones.png"))); // NOI18N
        gestion.setBorder(null);
        gestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionActionPerformed(evt);
            }
        });
        jPanel13.add(gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 120, 90));

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/carro.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 130, 90));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(974, 0, 50, 40));

        jPanel8.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1020, 90));

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("precio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1243, 6, 41, -1));

        jLabel5.setText("cantidad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1317, 6, -1, -1));

        botoneliminarventa.setBackground(new java.awt.Color(0, 0, 0));
        botoneliminarventa.setForeground(new java.awt.Color(255, 255, 255));
        botoneliminarventa.setText("BORRAR PRODUCTO");
        botoneliminarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneliminarventaActionPerformed(evt);
            }
        });
        jPanel1.add(botoneliminarventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, -1, -1));

        tablaventa.setBackground(new java.awt.Color(153, 153, 153));
        tablaventa.setForeground(new java.awt.Color(51, 51, 51));
        tablaventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo linea", "codigo producto", "nombre", "descripcion", "precio", "cantidad", "total"
            }
        ));
        tablaventa.setOpaque(false);
        tablaventa.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tablaventa.setSelectionForeground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(tablaventa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 99, -1, 380));

        jLabel6.setText("stock disponible");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1401, 6, -1, -1));

        botongenerarventa.setBackground(new java.awt.Color(0, 0, 0));
        botongenerarventa.setForeground(new java.awt.Color(255, 255, 255));
        botongenerarventa.setText("GUARDAR VENTA");
        botongenerarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botongenerarventaActionPerformed(evt);
            }
        });
        jPanel1.add(botongenerarventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));

        jLabel9.setText("TOTAL A PAGAR");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        totalventa.setEditable(false);
        totalventa.setBackground(new java.awt.Color(153, 153, 153));
        totalventa.setText("0");
        totalventa.setBorder(null);
        totalventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalventaActionPerformed(evt);
            }
        });
        jPanel1.add(totalventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 160, 20));

        jPanel14.setBackground(new java.awt.Color(92, 92, 92));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dniventatxt.setBackground(new java.awt.Color(153, 153, 153));
        dniventatxt.setBorder(null);
        dniventatxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dniventatxtKeyPressed(evt);
            }
        });
        jPanel14.add(dniventatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, 20));

        jLabel7.setText("DNI");
        jPanel14.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel36.setText("datos cliente");
        jPanel14.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        nombreventatxt.setEditable(false);
        nombreventatxt.setBackground(new java.awt.Color(153, 153, 153));
        nombreventatxt.setBorder(null);
        jPanel14.add(nombreventatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 90, 20));

        jLabel8.setText("nombre");
        jPanel14.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        telefonoclienteventa.setEditable(false);
        telefonoclienteventa.setBackground(new java.awt.Color(153, 153, 153));
        telefonoclienteventa.setBorder(null);
        jPanel14.add(telefonoclienteventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 80, 20));

        jLabel34.setText("telefono");
        jPanel14.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        direccionclienteventa.setEditable(false);
        direccionclienteventa.setBackground(new java.awt.Color(153, 153, 153));
        direccionclienteventa.setBorder(null);
        jPanel14.add(direccionclienteventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 90, 20));

        jLabel35.setText("direccion ");
        jPanel14.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 400, 100));

        jPanel15.setBackground(new java.awt.Color(92, 92, 92));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setText("DATOS EMPLEADO");
        jPanel15.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel38.setText("DNI");
        jPanel15.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtdniempleadoo.setBackground(new java.awt.Color(153, 153, 153));
        txtdniempleadoo.setBorder(null);
        txtdniempleadoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniempleadooActionPerformed(evt);
            }
        });
        txtdniempleadoo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdniempleadooKeyPressed(evt);
            }
        });
        jPanel15.add(txtdniempleadoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 20));

        jLabel39.setText("NOMBRE");
        jPanel15.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        txtnombrempleadoventa.setBackground(new java.awt.Color(153, 153, 153));
        txtnombrempleadoventa.setBorder(null);
        jPanel15.add(txtnombrempleadoventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 110, 20));

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 260, 100));

        jPanel16.setBackground(new java.awt.Color(92, 92, 92));

        codigoventatxt.setBackground(new java.awt.Color(153, 153, 153));
        codigoventatxt.setBorder(null);
        codigoventatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoventatxtActionPerformed(evt);
            }
        });
        codigoventatxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoventatxtKeyPressed(evt);
            }
        });

        jLabel2.setText("CODIGO");

        nombreproductoventatxt.setEditable(false);
        nombreproductoventatxt.setBackground(new java.awt.Color(153, 153, 153));
        nombreproductoventatxt.setBorder(null);

        jLabel33.setText("NOMBRE PRODUCTO");

        descripcionventatxt.setEditable(false);
        descripcionventatxt.setBackground(new java.awt.Color(153, 153, 153));
        descripcionventatxt.setBorder(null);

        jLabel3.setText("DESCRIPCION");

        jLabel28.setText("CANTIDAD");

        cantidadventatxt.setBackground(new java.awt.Color(153, 153, 153));
        cantidadventatxt.setBorder(null);
        cantidadventatxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadventatxtKeyPressed(evt);
            }
        });

        precioventatxt.setEditable(false);
        precioventatxt.setBackground(new java.awt.Color(153, 153, 153));
        precioventatxt.setBorder(null);

        jLabel30.setText("PRECIO");

        jLabel43.setText("STOCK DISPONIBLE");

        stocktxt.setEditable(false);
        stocktxt.setBackground(new java.awt.Color(153, 153, 153));
        stocktxt.setBorder(null);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel33)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)
                        .addGap(196, 196, 196)
                        .addComponent(jLabel28)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel30)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel43))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(codigoventatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(nombreproductoventatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(descripcionventatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cantidadventatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(precioventatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(stocktxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel33)
                    .addComponent(jLabel3)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigoventatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreproductoventatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcionventatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadventatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioventatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stocktxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 860, 70));

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaproductos.setBackground(new java.awt.Color(153, 153, 153));
        tablaproductos.setForeground(new java.awt.Color(51, 51, 51));
        tablaproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idproducto", "nombre", "descripcion", "cantidad", "precio", "proovedor", "idCat"
            }
        ));
        tablaproductos.setOpaque(false);
        tablaproductos.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tablaproductos.setSelectionForeground(new java.awt.Color(102, 102, 102));
        tablaproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaproductosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaproductos);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 900, 240));

        jPanel18.setBackground(new java.awt.Color(92, 92, 92));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tctidproduct.setEditable(false);
        tctidproduct.setBackground(new java.awt.Color(153, 153, 153));
        tctidproduct.setBorder(null);
        jPanel18.add(tctidproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 170, 20));

        txtnombreproduct.setBackground(new java.awt.Color(153, 153, 153));
        txtnombreproduct.setBorder(null);
        jPanel18.add(txtnombreproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 170, 20));

        txtdescripcionpro.setBackground(new java.awt.Color(153, 153, 153));
        txtdescripcionpro.setBorder(null);
        jPanel18.add(txtdescripcionpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 530, 20));

        txtcantidadproduct.setBackground(new java.awt.Color(153, 153, 153));
        txtcantidadproduct.setBorder(null);
        jPanel18.add(txtcantidadproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 170, 20));

        txtprecioproduct.setBackground(new java.awt.Color(153, 153, 153));
        txtprecioproduct.setBorder(null);
        jPanel18.add(txtprecioproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 170, 20));

        listaprovedores.setBackground(new java.awt.Color(153, 153, 153));
        listaprovedores.setEditable(true);
        listaprovedores.setForeground(new java.awt.Color(153, 153, 153));
        listaprovedores.setBorder(null);
        jPanel18.add(listaprovedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 170, -1));

        listaidcatproducto.setEditable(true);
        listaidcatproducto.setBorder(null);
        listaidcatproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaidcatproductoActionPerformed(evt);
            }
        });
        jPanel18.add(listaidcatproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 170, -1));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel21.setText("IDPRODUCTO");
        jPanel18.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel10.setText("NOMBRE");
        jPanel18.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel22.setText("DESCRIPCION");
        jPanel18.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel23.setText("STOCK");
        jPanel18.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel24.setText("PRECIO");
        jPanel18.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel25.setText("PROOVEDOR");
        jPanel18.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel32.setText("IDCAT");
        jPanel18.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 58, -1));

        jPanel5.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 670, 230));

        jPanel19.setBackground(new java.awt.Color(92, 92, 92));

        btnguardarproduct.setBackground(new java.awt.Color(0, 0, 0));
        btnguardarproduct.setForeground(new java.awt.Color(255, 255, 255));
        btnguardarproduct.setText("guardar");
        btnguardarproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarproductActionPerformed(evt);
            }
        });

        btnactualizarproduct.setBackground(new java.awt.Color(0, 0, 0));
        btnactualizarproduct.setForeground(new java.awt.Color(255, 255, 255));
        btnactualizarproduct.setText("actualizar");
        btnactualizarproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarproductActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(0, 0, 0));
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("excel productos");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        btneliminarproduct.setBackground(new java.awt.Color(0, 0, 0));
        btneliminarproduct.setForeground(new java.awt.Color(255, 255, 255));
        btneliminarproduct.setText("eliminar");
        btneliminarproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarproductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(btnactualizarproduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminarproduct))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(btnguardarproduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton21)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardarproduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnactualizarproduct)
                    .addComponent(btneliminarproduct))
                .addGap(47, 47, 47))
        );

        jPanel5.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, 190, 120));

        jTabbedPane1.addTab("tab4", jPanel5);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablacliente.setBackground(new java.awt.Color(153, 153, 153));
        tablacliente.setForeground(new java.awt.Color(51, 51, 51));
        tablacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "dni", "nombre", "apellido1", "apellido2", "telefono", "direccion"
            }
        ));
        tablacliente.setOpaque(false);
        tablacliente.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tablacliente.setSelectionForeground(new java.awt.Color(102, 102, 102));
        tablacliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaclienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablacliente);
        if (tablacliente.getColumnModel().getColumnCount() > 0) {
            tablacliente.getColumnModel().getColumn(0).setPreferredWidth(20);
            tablacliente.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 850, 241));

        btneliminarcliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btneliminarcliente.setText("eliminar");
        btneliminarcliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneliminarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarclienteActionPerformed(evt);
            }
        });
        jPanel3.add(btneliminarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1221, 184, -1, -1));

        btnguardarcliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnguardarcliente.setText("guardar");
        btnguardarcliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarclienteActionPerformed(evt);
            }
        });
        jPanel3.add(btnguardarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1221, 26, -1, -1));

        btnnuevocliente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnnuevocliente.setText("nuevo");
        btnnuevocliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnnuevocliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1221, 133, -1, -1));

        jPanel17.setBackground(new java.awt.Color(92, 92, 92));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("DNI");
        jPanel17.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtdnicliente.setBackground(new java.awt.Color(153, 153, 153));
        txtdnicliente.setBorder(null);
        jPanel17.add(txtdnicliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 160, 20));

        txtnombecliente.setBackground(new java.awt.Color(153, 153, 153));
        txtnombecliente.setBorder(null);
        jPanel17.add(txtnombecliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 270, 20));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setText("NOMBRE");
        jPanel17.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel15.setText("APELLIDO 1");
        jPanel17.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtapellido1.setBackground(new java.awt.Color(153, 153, 153));
        txtapellido1.setBorder(null);
        jPanel17.add(txtapellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 160, 20));

        txtapellido2.setBackground(new java.awt.Color(153, 153, 153));
        txtapellido2.setBorder(null);
        txtapellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellido2ActionPerformed(evt);
            }
        });
        jPanel17.add(txtapellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 160, 20));

        jLabel31.setText("APELLIDO 2");
        jPanel17.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setText("TELEFONO");
        jPanel17.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        inttelefonocliente.setBackground(new java.awt.Color(153, 153, 153));
        inttelefonocliente.setBorder(null);
        jPanel17.add(inttelefonocliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 160, 20));

        txtdireccioncliente.setBackground(new java.awt.Color(153, 153, 153));
        txtdireccioncliente.setBorder(null);
        jPanel17.add(txtdireccioncliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 280, 20));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setText("DIRECCION");
        jPanel17.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jPanel3.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 400, 200));

        jPanel20.setBackground(new java.awt.Color(92, 92, 92));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnguardarcliente2.setBackground(new java.awt.Color(0, 0, 0));
        btnguardarcliente2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnguardarcliente2.setForeground(new java.awt.Color(255, 255, 255));
        btnguardarcliente2.setText("guardar");
        btnguardarcliente2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardarcliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarcliente2ActionPerformed(evt);
            }
        });
        jPanel20.add(btnguardarcliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        btneditarcliente2.setBackground(new java.awt.Color(0, 0, 0));
        btneditarcliente2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btneditarcliente2.setForeground(new java.awt.Color(255, 255, 255));
        btneditarcliente2.setText("actualizar");
        btneditarcliente2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneditarcliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarcliente2ActionPerformed(evt);
            }
        });
        jPanel20.add(btneditarcliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btneliminarcliente2.setBackground(new java.awt.Color(0, 0, 0));
        btneliminarcliente2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btneliminarcliente2.setForeground(new java.awt.Color(255, 255, 255));
        btneliminarcliente2.setText("eliminar");
        btneliminarcliente2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneliminarcliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarcliente2ActionPerformed(evt);
            }
        });
        jPanel20.add(btneliminarcliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jPanel3.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 100, 150));

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaproovedores.setBackground(new java.awt.Color(153, 153, 153));
        tablaproovedores.setForeground(new java.awt.Color(51, 51, 51));
        tablaproovedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nif", "nombre", "telefono", "email", "direccion"
            }
        ));
        tablaproovedores.setOpaque(false);
        tablaproovedores.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tablaproovedores.setSelectionForeground(new java.awt.Color(102, 102, 102));
        tablaproovedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaproovedoresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaproovedores);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 487, 391));

        btnguardarproovedor.setBackground(new java.awt.Color(0, 0, 0));
        btnguardarproovedor.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnguardarproovedor.setForeground(new java.awt.Color(255, 255, 255));
        btnguardarproovedor.setText("guardar");
        btnguardarproovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarproovedorActionPerformed(evt);
            }
        });
        jPanel4.add(btnguardarproovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 287, -1, -1));

        btnactualizarproovedor.setBackground(new java.awt.Color(0, 0, 0));
        btnactualizarproovedor.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnactualizarproovedor.setForeground(new java.awt.Color(255, 255, 255));
        btnactualizarproovedor.setText("actualizar");
        btnactualizarproovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarproovedorActionPerformed(evt);
            }
        });
        jPanel4.add(btnactualizarproovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 287, -1, -1));

        btneliminarproovedor.setBackground(new java.awt.Color(0, 0, 0));
        btneliminarproovedor.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btneliminarproovedor.setForeground(new java.awt.Color(255, 255, 255));
        btneliminarproovedor.setText("eliminar");
        btneliminarproovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarproovedorActionPerformed(evt);
            }
        });
        jPanel4.add(btneliminarproovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 329, -1, -1));

        jPanel21.setBackground(new java.awt.Color(92, 92, 92));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel16.setText("nif");
        jPanel21.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        txtnifproovedor.setBackground(new java.awt.Color(153, 153, 153));
        txtnifproovedor.setBorder(null);
        jPanel21.add(txtnifproovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 220, 20));

        txtnombreproovedor.setBackground(new java.awt.Color(153, 153, 153));
        txtnombreproovedor.setBorder(null);
        jPanel21.add(txtnombreproovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 220, 20));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel17.setText("nombre");
        jPanel21.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel18.setText("telefono");
        jPanel21.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txttelefonoproovedor.setBackground(new java.awt.Color(153, 153, 153));
        txttelefonoproovedor.setBorder(null);
        jPanel21.add(txttelefonoproovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 220, 20));

        txtemailproovedor.setBackground(new java.awt.Color(153, 153, 153));
        txtemailproovedor.setBorder(null);
        jPanel21.add(txtemailproovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 220, 20));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel19.setText("email");
        jPanel21.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel20.setText("direccion");
        jPanel21.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        txtdireccionproovedor.setBackground(new java.awt.Color(153, 153, 153));
        txtdireccionproovedor.setBorder(null);
        jPanel21.add(txtdireccionproovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 220, 20));

        jPanel4.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 350, 210));

        jTabbedPane1.addTab("tab3", jPanel4);

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel40.setText("GESTION DEL SISTEMA DE VENTAS");
        jPanel9.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BORRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 141, 102, 67));

        jLabel41.setText("VACIAR CLIENTES");
        jPanel9.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 119, -1, -1));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("BORRAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 102, 67));

        jLabel42.setText("VACIAR EMPLEADOS");
        jPanel9.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 119, -1, -1));

        jLabel26.setText("GESTION DE EMPLEADOS");
        jPanel9.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("OPCIONES");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 101, 67));

        jTabbedPane1.addTab("tab6", jPanel9);

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaempleados.setBackground(new java.awt.Color(153, 153, 153));
        tablaempleados.setForeground(new java.awt.Color(51, 51, 51));
        tablaempleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "NOMBRE", "APELLIDO1", "APELLIDO2", "TELEFONO", "DIRECCION", "SUELDO", "RANGO"
            }
        ));
        tablaempleados.setOpaque(false);
        tablaempleados.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tablaempleados.setSelectionForeground(new java.awt.Color(102, 102, 102));
        tablaempleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaempleadosMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablaempleados);
        if (tablaempleados.getColumnModel().getColumnCount() > 0) {
            tablaempleados.getColumnModel().getColumn(0).setPreferredWidth(20);
            tablaempleados.getColumnModel().getColumn(1).setPreferredWidth(40);
            tablaempleados.getColumnModel().getColumn(2).setPreferredWidth(40);
            tablaempleados.getColumnModel().getColumn(3).setPreferredWidth(40);
            tablaempleados.getColumnModel().getColumn(6).setPreferredWidth(20);
        }

        jPanel10.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 870, 270));

        jPanel22.setBackground(new java.awt.Color(92, 92, 92));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcontraseñaempleado.setBackground(new java.awt.Color(153, 153, 153));
        txtcontraseñaempleado.setBorder(null);
        jPanel22.add(txtcontraseñaempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, 30));

        contraseñaempleado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        contraseñaempleado.setText("CONTRASEÑA");
        jPanel22.add(contraseñaempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        rangoempleado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        rangoempleado.setText("RANGO");
        jPanel22.add(rangoempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, -1));

        txtrangoempleado.setBackground(new java.awt.Color(153, 153, 153));
        txtrangoempleado.setBorder(null);
        jPanel22.add(txtrangoempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 150, 20));

        txtsueldoempleado.setBackground(new java.awt.Color(153, 153, 153));
        txtsueldoempleado.setBorder(null);
        jPanel22.add(txtsueldoempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 150, 20));

        sueldoempleado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        sueldoempleado.setText("SUELDO");
        jPanel22.add(sueldoempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        direccionempleado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        direccionempleado.setText("DIRECCION");
        jPanel22.add(direccionempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        txtdireccion.setBackground(new java.awt.Color(153, 153, 153));
        txtdireccion.setBorder(null);
        jPanel22.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 150, 20));

        txttelefonoempleado.setBackground(new java.awt.Color(153, 153, 153));
        txttelefonoempleado.setBorder(null);
        jPanel22.add(txttelefonoempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 153, 20));

        telefonoempleado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        telefonoempleado.setText("TELEFONO");
        jPanel22.add(telefonoempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        apellido2empleado.setText("APELLIDO2");
        jPanel22.add(apellido2empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        txtapellidoempleado2.setBackground(new java.awt.Color(153, 153, 153));
        txtapellidoempleado2.setBorder(null);
        txtapellidoempleado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoempleado2ActionPerformed(evt);
            }
        });
        jPanel22.add(txtapellidoempleado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 153, 20));

        txtapellidoempleado.setBackground(new java.awt.Color(153, 153, 153));
        txtapellidoempleado.setBorder(null);
        jPanel22.add(txtapellidoempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 154, 20));

        apellido1empleado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        apellido1empleado.setText("APELLIDO1");
        jPanel22.add(apellido1empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        nombreempleado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nombreempleado.setText("NOMBRE");
        jPanel22.add(nombreempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        txtnombreempleado.setBackground(new java.awt.Color(153, 153, 153));
        txtnombreempleado.setBorder(null);
        jPanel22.add(txtnombreempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 155, 20));

        txtdniempleado.setBackground(new java.awt.Color(153, 153, 153));
        txtdniempleado.setBorder(null);
        jPanel22.add(txtdniempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 155, 20));

        dniempleado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        dniempleado.setText("DNI");
        jPanel22.add(dniempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("NUEVO");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("ACTUALIZAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, -1, -1));

        btneliminarempleado.setBackground(new java.awt.Color(0, 0, 0));
        btneliminarempleado.setForeground(new java.awt.Color(255, 255, 255));
        btneliminarempleado.setText("ELIMINAR");
        btneliminarempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarempleadoActionPerformed(evt);
            }
        });
        jPanel22.add(btneliminarempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, -1, -1));

        jPanel10.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 700, 200));

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("VOLVER");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 530, -1, -1));

        jTabbedPane1.addTab("tab7", jPanel10);

        jPanel8.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 970, 620));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1323, 6, -1, -1));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 670));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel12.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, -30, 950, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * boton que nos permite mostrar el interface de ventas
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
        tablaventa.setOpaque(false);
        jTabbedPane1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void codigoventatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoventatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoventatxtActionPerformed
       /**
        * metodo que se ejecuta cunado pulsamos le boton guardar cliente, este nos pelrmite ejecutar las
        * consultas necesarias para que se guarde el cliente en nuestra base de datos, para esto utilizamos nuestro
        * objeto cliente cl y cuestro objeto clientedao cldao, ademas de emplear metodos para limpiar los datos de texto
        * del cliente y para refrescar la tabla
        * @param evt 
        */
    private void btnguardarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarclienteActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtdnicliente.getText()) || !"".equals(txtnombecliente.getText()) || !"".equals(txtapellido1.getText()) || !"".equals(txtapellido2.getText()) || !"".equals(inttelefonocliente.getText())) {
            cl.setDni(txtdnicliente.getText());
            cl.setNombre(txtnombecliente.getText());
            cl.setApellido1(txtapellido1.getText());
            cl.setApellido2(txtapellido2.getText());
            cl.setTelefono(Integer.parseInt(inttelefonocliente.getText()));
            cl.setDireccion(txtdireccioncliente.getText());
            cldao.registroCliente(cl);
            limpiartabla();
            listarclientes();
            limpiarcliente();
            JOptionPane.showMessageDialog(null, "cliente registrado con exiteo");  
        } else  {
             JOptionPane.showMessageDialog(null, "alguno de los campos requeridos estan vacios");  
        }
    }//GEN-LAST:event_btnguardarclienteActionPerformed

    private void txtapellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellido2ActionPerformed

    /**
     * metodo qque hace que al clicar el boton cliente de nuestro interface grafico
     * se muestre el menu de gestion de clientes de nuestro interface
     * @param evt 
     */
    private void botonclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonclientesActionPerformed
        // TODO add your handling code here:
        limpiartabla();
        listarclientes();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_botonclientesActionPerformed

    /**
     * hacemos que la clicar sobre un fila de nuestra tabla de clientes se muestren los datos de ese cliente
     * en nuestro interface grafico
     * @param evt 
     */
    private void tablaclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaclienteMouseClicked
        // TODO add your handling code here:
        int fila = tablacliente.rowAtPoint(evt.getPoint());
        txtdnicliente.setText(tablacliente.getValueAt(fila, 0).toString());
        txtnombecliente.setText(tablacliente.getValueAt(fila, 1).toString());
        txtapellido1.setText(tablacliente.getValueAt(fila, 2).toString());
        txtapellido2.setText(tablacliente.getValueAt(fila, 3).toString());
        inttelefonocliente.setText(tablacliente.getValueAt(fila, 4).toString());
        txtdireccioncliente.setText(tablacliente.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_tablaclienteMouseClicked

    /**
     * boton que nos permite eliminar el cliente cusllo dni este en el campo txtdnicliente,
     * para esto recurrimos al metodo borrarcliente mediante nuestro objeto cldao
     * @param evt 
     */
    private void btneliminarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarclienteActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtdnicliente.getText())) {
            int seguridad = JOptionPane.showConfirmDialog(null, "desea elminar");
            if (seguridad == 0) {
                String dni = txtdnicliente.getText();
                cldao.borrarcliente(dni);
                limpiartabla();
                listarclientes();
                limpiarcliente();
            }
        }
    }//GEN-LAST:event_btneliminarclienteActionPerformed

   
    /**
     * este metodo nos permite registrar un nuevo proveedor en nuestra base de datos,
     * para esto requerimos nuestro objetos proveedor (pro) y proovedordao (prodao)
     * @param evt 
     */
    private void btnguardarproovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarproovedorActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtnifproovedor.getText()) || !"".equals(txtnombreproovedor.getText()) || !"".equals(txttelefonoproovedor.getText()) || !"".equals(txtdireccionproovedor.getText())) {
            pro.setNif(txtnifproovedor.getText());
            pro.setNombre(txtnombreproovedor.getText());
            pro.setTelefono(Integer.parseInt(txttelefonoproovedor.getText()));
            pro.setEmail(txtemailproovedor.getText());
            pro.setDireccion(txtdireccionproovedor.getText());
            prodao.registrarproovedor(pro);
            JOptionPane.showMessageDialog(null, "proovedor registrado con exiteo");
            limpiartabla();
            listarproovedores();
            limpiarproovedor();
        } else  {
             JOptionPane.showMessageDialog(null, "alguno de los campos requeridos estan vacios");  
        }
    }//GEN-LAST:event_btnguardarproovedorActionPerformed
    
    /**
     * boton de apertura de menu de gestion de proovedores
     * @param evt 
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        limpiartabla();
        limpiarproovedor();
        listarproovedores();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * boton que nos permite mostrar el interface de productos
     * @param evt 
     */
    private void productosçActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosçActionPerformed
        // TODO add your handling code here:
        limpiartabla();
        listarproductos();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_productosçActionPerformed

    /**
     * hacemos que al cliquear sobre una fila de nuestra tabla se muestren los datos de ese proovedor 
     * en los campos de nuestro interface grafico
     * @param evt 
     */
    private void tablaproovedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaproovedoresMouseClicked
        // TODO add your handling code here:
        int fila = tablaproovedores.rowAtPoint(evt.getPoint());
        txtnifproovedor.setText(tablaproovedores.getValueAt(fila, 0).toString());
        txtnombreproovedor.setText(tablaproovedores.getValueAt(fila, 1).toString());
        txttelefonoproovedor.setText(tablaproovedores.getValueAt(fila, 2).toString());
        txtemailproovedor.setText(tablaproovedores.getValueAt(fila, 3).toString());
        txtdireccionproovedor.setText(tablaproovedores.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tablaproovedoresMouseClicked

    /**
     * actualiza los datos de un proovedor seleccionado
     * @param evt 
     */
    private void btnactualizarproovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarproovedorActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtnifproovedor.getText())) {
            pro.setNif(txtnifproovedor.getText());
            pro.setNombre(txtnombreproovedor.getText());
            pro.setTelefono(Integer.parseInt(txttelefonoproovedor.getText()));
            pro.setEmail(txtemailproovedor.getText());
            pro.setDireccion(txtdireccionproovedor.getText());
            prodao.actualizarproovedores(pro);
            limpiartabla();
            limpiarproovedor();
            listarproovedores();
        }
    }//GEN-LAST:event_btnactualizarproovedorActionPerformed

    /**
     * boton que nos permite eliminar un proovedor
     * @param evt 
     */
    private void btneliminarproovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarproovedorActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtnifproovedor.getText())) {
            int seguridad = JOptionPane.showConfirmDialog(null, "desea elminar");
            if (seguridad == 0) {
                String nif = txtnifproovedor.getText();
                prodao.borrarproovedores(nif);
                limpiartabla();
                listarproovedores();
                limpiarproovedor();
            }
        }
    }//GEN-LAST:event_btneliminarproovedorActionPerformed

    /**
     * boton para guardar un producto (falta terminar comprovacion de vacios)
     * @param evt 
     */
    private void btnguardarproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarproductActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtnombreproduct.getText()) && !"".equals(txtdescripcionpro.getText())) {
            product.setNombre(txtnombreproduct.getText());
            product.setDescripcion(txtdescripcionpro.getText());
            product.setStock(Integer.parseInt(txtcantidadproduct.getText()));
            product.setPrecio(Double.parseDouble(txtprecioproduct.getText()));
            product.setNif(Integer.parseInt(listaprovedores.getSelectedItem().toString()));
            product.setIdcat(Integer.parseInt(listaidcatproducto.getSelectedItem().toString()));
            productdao.registrarproductos(product);
            limpiarproducto();
            limpiartabla();
            listarproductos();
        } else {
            JOptionPane.showMessageDialog(null, "alguno de los campos requeridos estan vacios");  
        }
    }//GEN-LAST:event_btnguardarproductActionPerformed

    private void listaidcatproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaidcatproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaidcatproductoActionPerformed

    /**
     * evento que ocurre al pulsar una linea de la tabla productos
     * gracias a el escribimos en los campos de texto los datos del producto pulsado
     * @param evt 
     */
    private void tablaproductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaproductosMouseClicked
        // TODO add your handling code here:
        int fila = tablaproductos.rowAtPoint(evt.getPoint());
        tctidproduct.setText(tablaproductos.getValueAt(fila, 0).toString());
        txtnombreproduct.setText(tablaproductos.getValueAt(fila, 1).toString());
        txtdescripcionpro.setText(tablaproductos.getValueAt(fila, 2).toString());
        txtprecioproduct.setText(tablaproductos.getValueAt(fila, 3).toString());
        txtcantidadproduct.setText(tablaproductos.getValueAt(fila, 4).toString());
        listaprovedores.setSelectedItem(tablaproductos.getValueAt(fila, 5).toString());
        listaidcatproducto.setSelectedItem(tablaproductos.getValueAt(fila, 6).toString());
    }//GEN-LAST:event_tablaproductosMouseClicked

    /**
     * boton que llama a la clase excel para generar el excel de productos
     * @param evt 
     */
    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        Excel.reporte();
    }//GEN-LAST:event_jButton21ActionPerformed

    /**
     * boton que nos permite modificar un producto
     * @param evt 
     */
    private void btnactualizarproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarproductActionPerformed
        // TODO add your handling code here:
        if (!"".equals(tctidproduct.getText())) {
            product.setIDProducto(Integer.parseInt(tctidproduct.getText()));
            product.setNombre(txtnombreproduct.getText());
            product.setDescripcion(txtdescripcionpro.getText());
            product.setPrecio(Double.parseDouble(txtprecioproduct.getText()));
            product.setStock(Integer.parseInt(txtcantidadproduct.getText()));
            product.setNif(Integer.parseInt(listaprovedores.getSelectedItem().toString()));
            product.setIdcat(Integer.parseInt(listaidcatproducto.getSelectedItem().toString()));
            productdao.modifacarpproducto(product);
            limpiartabla();
            listarproductos();
            limpiarproducto();
        }
    }//GEN-LAST:event_btnactualizarproductActionPerformed

    /**
     * metodo que hace que al dar enter teniendo el puntero sobre el campo de texto de id de producto se cagen 
     * los datos de id producto en los campos de texto correspondientes y se centre el puntero sobre el campo de cantidad
     * @param evt 
     */
    private void codigoventatxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoventatxtKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(codigoventatxt.getText())) {
                int id = Integer.parseInt(codigoventatxt.getText());
                product = productdao.busacarproductoporid(id);
                if (product.getNombre() != null) {
                    nombreproductoventatxt.setText(product.getNombre());
                    descripcionventatxt.setText(product.getDescripcion());
                    precioventatxt.setText(""+product.getPrecio());
                    stocktxt.setText(""+product.getStock());
                    
                    cantidadventatxt.requestFocus();
                } else {
                    nombreproductoventatxt.setText("");
                    descripcionventatxt.setText("");
                    precioventatxt.setText("");
                    stocktxt.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "introduzca un id");
            }
        }
    }//GEN-LAST:event_codigoventatxtKeyPressed

    private void totalventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalventaActionPerformed

    /**
     * nos permite borrar la linea de la tabla que se encuentre seleccionada, en esta ocasion no se muestran los datos en los campos
     * de texo. Ademas actualiza el precio total de la venta mediante el metodo calcular precio y vuelve a centrar el cursor sobre el 
     * campo de codigo de producto
     * @param evt 
     */
    private void botoneliminarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarventaActionPerformed
        // TODO add your handling code here:
        recuperarStock();
        tabla = (DefaultTableModel) tablaventa.getModel();
        tabla.removeRow(tablaventa.getSelectedRow());
        totalventa.setText(Double.toString(calcularprecio()));
        codigoventatxt.requestFocus();
    }//GEN-LAST:event_botoneliminarventaActionPerformed

    /**
     * al dar enter mientras estamos en el campo txt dni cliente en el interface de ventas
     * nos permite que se escriba el nombre del cliente ademas de que realiza una comprovacion de que 
     * exista el cliente
     * @param evt 
     */
    private void dniventatxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniventatxtKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(dniventatxt.getText())) {
                int dni = Integer.parseInt(dniventatxt.getText());
                cl = cldao.buscarclientepordni(dni);
                if (cl.getNombre() != null) {
                    nombreventatxt.setText(""+cl.getNombre());
                    telefonoclienteventa.setText(""+cl.getTelefono());
                    direccionclienteventa.setText(""+cl.getDireccion());
                } else {
                    dniventatxt.setText("");
                    nombreventatxt.setText("");
                    telefonoclienteventa.setText("");
                    direccionclienteventa.setText("");
                    JOptionPane.showMessageDialog(null, "no existe ningun cliente con este dni");
                }
            } else {
                JOptionPane.showMessageDialog(null, "introduzca un dni");
            }
        }
    }//GEN-LAST:event_dniventatxtKeyPressed

    private void txtdniempleadooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniempleadooActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniempleadooActionPerformed

    /**
     * boton para guardar una venta en nuestra base de datos
     * @param evt 
     */
    private void botongenerarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botongenerarventaActionPerformed
        // TODO add your handling code here:
        guardarventa();
        registrarlineasventa();
    }//GEN-LAST:event_botongenerarventaActionPerformed

    /**
     * al dar enter mientras estamos en el campo txt dni empleado en el interface de ventas
     * nos permite que se escriba el nombre del empleado ademas de que realiza una comprovacion de que 
     * exista el empleado
     * @param evt 
     */
    private void txtdniempleadooKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniempleadooKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtdniempleadoo.getText())) {
                int dni=Integer.parseInt(txtdniempleadoo.getText());
                emp = empdao.buscarempleadopordni(dni);
                if (emp.getNombre()!= null) {
                    txtnombrempleadoventa.setText(""+emp.getNombre());
                } else {
                    txtnombrempleadoventa.setText("");
                    JOptionPane.showMessageDialog(null, "no existe ningun empleado con este dni");
                }
            } else {
                JOptionPane.showMessageDialog(null, "introduzca un dni");
            }
        }
    }//GEN-LAST:event_txtdniempleadooKeyPressed

    /**
     * al ser pulsado muestra el interface de gestion del sistema
     * @param evt 
     */
    private void gestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionActionPerformed
        // TODO add your handling code here:
        limpiartabla();
        listarempleados();
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_gestionActionPerformed

    /**
     * boton que vacia por completo la tabla empleados
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       
        int seguridad = JOptionPane.showConfirmDialog(null, "desea elminar");
            if (seguridad == 0) {
                empdao.vaciarempleaados();
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * boton que vacia por completo la tabla clientes
     * @param evt 
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int seguridad = JOptionPane.showConfirmDialog(null, "desea elminar");
            if (seguridad == 0) {
                 cldao.vaciarclientes();
            }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtapellidoempleado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoempleado2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoempleado2ActionPerformed

    /**
     * guarda un nuevo empleado
     * @param evt 
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtnombreempleado.getText())) {
            emp.setDni(txtdniempleado.getText());
            emp.setNombre(txtnombreempleado.getText());
            emp.setApellido1(txtapellidoempleado.getText());
            emp.setApellido2(txtapellidoempleado2.getText());
            emp.setTelefono(txttelefonoempleado.getSelectionEnd());
            emp.setDireccion(txtdireccion.getText());
            emp.setSueldo(Integer.parseInt(txtsueldoempleado.getText()));
            emp.setContraseña(empdao.Encriptar(String.valueOf(txtcontraseñaempleado.getPassword())));
            emp.setRango(txtrangoempleado.getText());
            empdao.registroempleado(emp);
            limpiartabla();
            listarempleados();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * acceso a la gestion de empleadso, solo disponible para los administradores
     * @param evt 
     */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        limpiartabla();
        listarempleados();
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton10ActionPerformed

    /**
     * boton para salir de la gestion de empleados
     * @param evt 
     */
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * boton que nos permite borrar un empleado
     * @param evt 
     */
    private void btneliminarempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarempleadoActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtdniempleado.getText())) {
            int seguridad = JOptionPane.showConfirmDialog(null, "desea elminar");
            if (seguridad == 0) {
                String dni = txtdniempleado.getText();
                empdao.borrarempleado(dni);
                limpiartabla();
                listarempleados();
            }
        }
    }//GEN-LAST:event_btneliminarempleadoActionPerformed

    /**
     * evento que ocurre al pulsar una linea de la tabla epleado
     * gracia as el escribimos en los campos de texto los datos del empleado pulsado
     * @param evt 
     */
    private void tablaempleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaempleadosMouseClicked
        // TODO add your handling code here:
        int fila = tablaempleados.rowAtPoint(evt.getPoint());
        txtdniempleado.setText(tablaempleados.getValueAt(fila, 0).toString());
        txtnombreempleado.setText(tablaempleados.getValueAt(fila, 1).toString());
        txtapellidoempleado.setText(tablaempleados.getValueAt(fila, 2).toString());
        txtapellidoempleado2.setText(tablaempleados.getValueAt(fila, 3).toString());
        txttelefonoempleado.setText(tablaempleados.getValueAt(fila, 4).toString());
        txtdireccion.setText(tablaempleados.getValueAt(fila, 5).toString());
        txtsueldoempleado.setText(tablaempleados.getValueAt(fila, 6).toString());
        txtrangoempleado.setText(tablaempleados.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_tablaempleadosMouseClicked

    /**
     * boton que nos permite modificar un empleado
     * @param evt 
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtdniempleado.getText()) && !"".equals(String.valueOf(txtcontraseñaempleado.getPassword()))) {
            emp.setDni(txtdniempleado.getText());
            emp.setNombre(txtnombreempleado.getText());
            emp.setApellido1(txtapellidoempleado.getText());
            emp.setApellido2(txtapellidoempleado2.getText());
            emp.setTelefono(Integer.parseInt(txttelefonoempleado.getText()));
            emp.setDireccion(txtdireccion.getText());
            emp.setSueldo(Integer.parseInt(txtsueldoempleado.getText()));
            emp.setRango(txtrangoempleado.getText());
            emp.setContraseña(empdao.Encriptar(String.valueOf(txtcontraseñaempleado.getPassword())));
            empdao.modificarempleado(emp);
            limpiartabla();
            listarempleados();
        } else {
            JOptionPane.showMessageDialog(null, "no se ha facilitado alguno de los datos requeridos");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * metodo que hace que al dar enter con el puntero sobre el campo de texto cantidad se añada la linea a la venta
     * @param evt 
     */
    private void cantidadventatxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadventatxtKeyPressed
        // TODO add your handling code here:
        //conprobamos que el boton que se ha presionado es el enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            /*
            comprobamos que se haya ingresado una cantidad en el campo
            cantidad, en caso de que no se haya ingresado salta un mensaje advirtiendolo y no se incgresa el producto
            */
            if (!"".equals(cantidadventatxt.getText())) {
                int cantidad = Integer.parseInt(cantidadventatxt.getText());
                double precio = Double.parseDouble(precioventatxt.getText());
                double totalproducto = cantidad * precio;
                int stock = Integer.parseInt(stocktxt.getText());
                /*
                comprobamos que la cantidad solicitada sea menor al stock
                */
                if (stock >= cantidad) {
                    item = item + 1;
                    DefaultTableModel tabla2 = (DefaultTableModel) tablaventa.getModel();
                    for (int i = 0; i < tablaventa.getRowCount(); i++) {
                        if (tablaventa.getValueAt(i, 1).equals(codigoventatxt.getText())) {
                            JOptionPane.showMessageDialog(null, "el producto ya existe en esta venta");
                            limpiarventa();
                            return;
                        }
                    }
                    ArrayList venta = new ArrayList();
                    venta.add(item);
                    venta.add(codigoventatxt.getText());
                    venta.add(nombreproductoventatxt.getText());
                    venta.add(descripcionventatxt.getText());
                    venta.add(precio);
                    venta.add(cantidad);
                    venta.add(totalproducto);
                    Object[] obj = new Object[7];
                    obj[0] = venta.get(0);
                    obj[1] = venta.get(1);
                    obj[2] = venta.get(2);
                    obj[3] = venta.get(3);
                    obj[4] = venta.get(4);
                    obj[5] = venta.get(5);
                    obj[6] = venta.get(6);
                    tabla2.addRow(obj);
                    tablaventa.setModel(tabla2);
                    totalventa.setText(Double.toString(calcularprecio()));
                    calcularstock();
                    limpiarventa();
                    codigoventatxt.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "la cantidad solicitada es superior al stock");
                }
            } else {
                JOptionPane.showMessageDialog(null, "introduzca un una cantidad");
            }
        }

    }//GEN-LAST:event_cantidadventatxtKeyPressed

    /**
     * boton que nos permite guardar un cliente
     * @param evt 
     */
    private void btnguardarcliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarcliente2ActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtdnicliente.getText()) || !"".equals(txtnombecliente.getText()) || !"".equals(txtapellido1.getText()) || !"".equals(txtapellido2.getText()) || !"".equals(inttelefonocliente.getText())) {
            cl.setDni(txtdnicliente.getText());
            cl.setNombre(txtnombecliente.getText());
            cl.setApellido1(txtapellido1.getText());
            cl.setApellido2(txtapellido2.getText());
            cl.setTelefono(Integer.parseInt(inttelefonocliente.getText()));
            cl.setDireccion(txtdireccioncliente.getText());
            cldao.registroCliente(cl);
            limpiartabla();
            listarclientes();
            limpiarcliente();
            JOptionPane.showMessageDialog(null, "cliente registrado con exiteo");  
        } else  {
             JOptionPane.showMessageDialog(null, "alguno de los campos requeridos estan vacios");  
        }
    }//GEN-LAST:event_btnguardarcliente2ActionPerformed

    /**
     * boton que nos permite editar un cliente
     * @param evt 
     */
    private void btneditarcliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarcliente2ActionPerformed
        // TODO add your handling code here:
         if (!"".equals(txtdnicliente.getText())) {
            cl.setDni(txtdnicliente.getText());
            cl.setNombre(txtnombecliente.getText());
            cl.setApellido1(txtapellido1.getText());
            cl.setApellido2(txtapellido2.getText());
            cl.setTelefono(Integer.parseInt(inttelefonocliente.getText()));
            cl.setDireccion(txtdireccioncliente.getText());
            cldao.modificarcliente(cl);
            limpiartabla();
            limpiarcliente();
            listarclientes();
        }else{
            JOptionPane.showMessageDialog(null, "debes de seleccionar un cliente que modificar");
        }
    }//GEN-LAST:event_btneditarcliente2ActionPerformed
    /**
     * boton que nos permite eliminar un cliente
     * @param evt 
     */
    private void btneliminarcliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarcliente2ActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtdnicliente.getText())) {
            int seguridad = JOptionPane.showConfirmDialog(null, "desea elminar");
            if (seguridad == 0) {
                String dni = txtdnicliente.getText();
                cldao.borrarcliente(dni);
                limpiartabla();
                limpiarcliente();
                listarclientes();
            }
        }
    }//GEN-LAST:event_btneliminarcliente2ActionPerformed
    /**
     * boton que nos permite eliminar un producto
     * @param evt 
     */
    private void btneliminarproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarproductActionPerformed
        // TODO add your handling code here:
        if (!"".equals(tctidproduct.getText())) {
            int seguridad = JOptionPane.showConfirmDialog(null, "desea elminar");
            if (seguridad == 0) {
                String idproducto = tctidproduct.getText();
                productdao.borrarproducto(idproducto);
                limpiartabla();
                listarproductos();
                limpiarproducto();
            }
        }
        
    }//GEN-LAST:event_btneliminarproductActionPerformed
    /**
     * boton que nos permite cerrar la aplicacion
     * @param evt 
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        login lg = new login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed
    /**
     * metodo empleado para calcular el precio total de la venta en tiempo real
     * @return 
     */
    private double calcularprecio(){
        totalpagar = 0.0; 
        for (int i = 0; i < tablaventa.getRowCount(); i++) {
            double calcular = Double.parseDouble(String.valueOf(tablaventa.getModel().getValueAt(i, 6)));
            totalpagar = totalpagar + calcular;
        }
        return Math.round(totalpagar * 100.0) / 100.0;
    }
    
    /**
     * metodo empleado para guardar los datos basicos de la venta
     */
    private void guardarventa(){
        String dnicliente = dniventatxt.getText();
        String dniempleado = txtdniempleadoo.getText();
        vt.setDnicliente(dnicliente);
        vt.setDniempleado(dniempleado);
        vtdao.registrarventa(vt);
    }
    
    /**
     * metodo empleado para guardar los datos de las lineas de una venta
     */
    private void registrarlineasventa(){
        int idventa = vtdao.maxidventa();
        for (int i = 0; i < tablaventa.getRowCount(); i++) {
            int idlinea = Integer.parseInt(tablaventa.getValueAt(i, 0).toString());
            int cantidad = Integer.parseInt(tablaventa.getValueAt(i, 5).toString());
            int idproducto = Integer.parseInt(tablaventa.getValueAt(i, 1).toString());
            lf.setIdlinea(idlinea);
            lf.setCantidad(cantidad);
            lf.setIdproducto(idproducto);
            lf.setIdventa(idventa);
            vtdao.registrarlineasfactura(lf);
        }
    }
     /**
      * metodo que nos permite calcular el stock (resta la cntidad solicitada en una venta)
      */
    public void calcularstock (){
        int cantidad = Integer.parseInt(cantidadventatxt.getText());
        int stock = Integer.parseInt(stocktxt.getText());
        int nuevostock = stock - cantidad;
        int idproducto = Integer.parseInt(codigoventatxt.getText());
        vtdao.refrescarstock(nuevostock, idproducto);
    }
    
    /**
     * metodo que nos permite recuperar el stock (suma la cantidad al stock restante, se emplea cuando quitamos una linea)
     */
    public void recuperarStock (){
        int cantidad = Integer.parseInt(tablaventa.getValueAt(tablaventa.getSelectedRow(), 5).toString());
        int idproducto = Integer.parseInt(tablaventa.getValueAt(tablaventa.getSelectedRow(), 1).toString());
        product = productdao.busacarproductoporid(idproducto);
        int stock = product.getStock();
        int nuevostock = cantidad + stock;
        vtdao.refrescarstock(nuevostock, idproducto);
        product = productdao.busacarproductoporid(idproducto);     
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sistemaadmins().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellido1empleado;
    private javax.swing.JLabel apellido2empleado;
    private javax.swing.JButton botonclientes;
    private javax.swing.JButton botoneliminarventa;
    private javax.swing.JButton botongenerarventa;
    private javax.swing.JButton btnactualizarproduct;
    private javax.swing.JButton btnactualizarproovedor;
    private javax.swing.JButton btneditarcliente2;
    private javax.swing.JButton btneliminarcliente;
    private javax.swing.JButton btneliminarcliente2;
    private javax.swing.JButton btneliminarempleado;
    private javax.swing.JButton btneliminarproduct;
    private javax.swing.JButton btneliminarproovedor;
    private javax.swing.JButton btnguardarcliente;
    private javax.swing.JButton btnguardarcliente2;
    private javax.swing.JButton btnguardarproduct;
    private javax.swing.JButton btnguardarproovedor;
    private javax.swing.JButton btnnuevocliente;
    private javax.swing.JTextField cantidadventatxt;
    private javax.swing.JTextField codigoventatxt;
    private javax.swing.JLabel contraseñaempleado;
    private javax.swing.JTextField descripcionventatxt;
    private javax.swing.JTextField direccionclienteventa;
    private javax.swing.JLabel direccionempleado;
    private javax.swing.JLabel dniempleado;
    private javax.swing.JTextField dniventatxt;
    private javax.swing.JButton gestion;
    private javax.swing.JTextField inttelefonocliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> listaidcatproducto;
    private javax.swing.JComboBox<String> listaprovedores;
    private javax.swing.JLabel nombreempleado;
    private javax.swing.JTextField nombreproductoventatxt;
    private javax.swing.JTextField nombreventatxt;
    private javax.swing.JTextField precioventatxt;
    private javax.swing.JButton productosç;
    private javax.swing.JLabel rangoempleado;
    private javax.swing.JTextField stocktxt;
    private javax.swing.JLabel sueldoempleado;
    private javax.swing.JTable tablacliente;
    private javax.swing.JTable tablaempleados;
    private javax.swing.JTable tablaproductos;
    private javax.swing.JTable tablaproovedores;
    private javax.swing.JTable tablaventa;
    private javax.swing.JTextField tctidproduct;
    private javax.swing.JTextField telefonoclienteventa;
    private javax.swing.JLabel telefonoempleado;
    private javax.swing.JTextField totalventa;
    private javax.swing.JTextField txtapellido1;
    private javax.swing.JTextField txtapellido2;
    private javax.swing.JTextField txtapellidoempleado;
    private javax.swing.JTextField txtapellidoempleado2;
    private javax.swing.JTextField txtcantidadproduct;
    private javax.swing.JPasswordField txtcontraseñaempleado;
    private javax.swing.JTextField txtdescripcionpro;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdireccioncliente;
    private javax.swing.JTextField txtdireccionproovedor;
    private javax.swing.JTextField txtdnicliente;
    private javax.swing.JTextField txtdniempleado;
    private javax.swing.JTextField txtdniempleadoo;
    private javax.swing.JTextField txtemailproovedor;
    private javax.swing.JTextField txtidventas;
    private javax.swing.JTextField txtnifproovedor;
    private javax.swing.JTextField txtnombecliente;
    private javax.swing.JTextField txtnombreempleado;
    private javax.swing.JTextField txtnombrempleadoventa;
    private javax.swing.JTextField txtnombreproduct;
    private javax.swing.JTextField txtnombreproovedor;
    private javax.swing.JTextField txtprecioproduct;
    private javax.swing.JTextField txtrangoempleado;
    private javax.swing.JTextField txtsueldoempleado;
    private javax.swing.JTextField txttelefonoempleado;
    private javax.swing.JTextField txttelefonoproovedor;
    // End of variables declaration//GEN-END:variables
}
