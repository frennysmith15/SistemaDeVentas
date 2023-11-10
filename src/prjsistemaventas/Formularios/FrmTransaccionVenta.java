/*
 * Frenny Smith De La Cruz All Rights Reserved <Propiedad Intelectual> *Solo personal autorizado*.
 * Matricula -> 100510483
 * UNIVERSIDAD AUTONOMA DE SANTO DOMINGO RECINTO UASD SAN FRANCISCO DE MACORIS (CURNE).
 */
package prjsistemaventas.Formularios;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import prjsistemaventas.Implementaciones.ClientesCRUDImp;
import prjsistemaventas.Implementaciones.ProductosCRUDImp;
import prjsistemaventas.Implementaciones.VentasCRUDImp;
import prjsistemaventas.dao.Cliente;
import prjsistemaventas.dao.DetalleVentas;
import prjsistemaventas.dao.Empleado;
import Factura.Factura;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import prjsistemaventas.dao.Producto;
import prjsistemaventas.dao.Venta;

     

public class FrmTransaccionVenta extends javax.swing.JFrame {

    
    private FrmMantenimientoCliente mantCliente;
    private FrmBuscarCliente buscarCliente;
    private FrmBuscarProducto buscarProducto;
    private Empleado empleado;
    DefaultTableModel modelo = new DefaultTableModel();
    private double productoPrecio;
    int codigoVenta;    
    
    public FrmTransaccionVenta() {
        this.mantCliente = new FrmMantenimientoCliente();
        this.buscarCliente = new FrmBuscarCliente();
        this.buscarProducto = new FrmBuscarProducto();
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Cruzrojasinfondos.png")).getImage());
  
        this.setLocationRelativeTo(null);
        codigoVenta = new VentasCRUDImp().getCodigo();
        txtNoFactura.setText(codigoVenta+"");
        
        fecha();
        
    }

    private void fecha()
    {
        Timer actualiza = new Timer();
     
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        TimerTask fecha = new TimerTask()
        {
        
            @Override
            public void run()
            {
                txtFecha.setText(dtf.format(LocalDateTime.now())+ "");
            }
    
        };


        actualiza.schedule(fecha, 0, 1000);
    }
    
    public Boolean validaExistenciaCliente(int codigo)
    {
        ArrayList<Cliente> clientes = new ClientesCRUDImp().mostrarTodos();
        
        for(Cliente c : clientes)
        {
            if(c.getCodigo() == codigo)
            {
                return true;
            }
        }
        return false;
        
    }
    
    public Boolean validaExistenciaProducto(int codigo)
    {
        ArrayList<Producto> p = new ProductosCRUDImp().mostrarTodos();
        
        for(Producto producto : p)
        {
            if(producto.getCodigo() == codigo)
            {
                return true;
            }
        }
        return false;
        
    }
    
    
    public void setTxtCliente(Cliente c)
    {
        txtCodigoCliente.setText(c.getCodigo()+"");
        txtClienteNombre.setText(c.getNombres());
    }
    
    public void desactivaBotones()
    {
        txtCodigoCliente.setEnabled(false);
        txtProductoCodigo.setEnabled(false);
        spnCantidad.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnNuevoCliente.setEnabled(false);
        btnAniadirVenta.setEnabled(false);
        btnGenerarVenta.setEnabled(false);
        
    }

    public void limpiarCampos()
    {
        txtClienteNombre.setText("");
        txtCodigoCliente.setText("");
        txtProductoCodigo.setText("");
        txtProductoNombre.setText("");
        txtProductoPrecio.setText("");
        txtProductoStock.setText("");
        txtProductoLab.setText("");
        spnCantidad.setValue(0);
        txtVentaTotalGeneral.setText("");
        txtVentaTotal.setText("");
        txtVentaImpuestos.setText("");
        
        
        codigoVenta = new VentasCRUDImp().getCodigo();
        
        
        DefaultTableModel modelo = (DefaultTableModel)tblVenta.getModel();
       
       for(int i = 0; i < modelo.getRowCount(); i++)
       {
           modelo.removeRow(i);
           i=i-1;
       }
       
        txtCodigoCliente.setEnabled(true);
        txtProductoCodigo.setEnabled(true);
        spnCantidad.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnNuevoCliente.setEnabled(true);
        btnAniadirVenta.setEnabled(true);
        btnGenerarVenta.setEnabled(true);
    }
    
    public void setTxtProducto(Producto p)
    {
        txtProductoCodigo.setText(p.getCodigo()+"");
        txtProductoNombre.setText(p.getNombres());
        txtProductoLab.setText(p.getLaboratorio());
        txtProductoPrecio.setText(p.getPrecio()+"");
        txtProductoStock.setText(p.getStock()+"");
        
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
    
    private void buscar()
    {
        spnCantidad.setValue(0);
        
        if((txtProductoCodigo.getText().isEmpty()))
        {
            buscarProducto.actualizarTabla();
            buscarProducto.setVisible(true);
        }
        else
        {
            int codigo = Integer.parseInt(txtProductoCodigo.getText());
            
            if(validaExistenciaProducto(codigo))
            {
                Producto producto;
                producto = (Producto) new ProductosCRUDImp().mostrar(codigo).get(0);

                codigo = producto.getCodigo();
                String nombre = producto.getNombres();
                String laboratorio = producto.getLaboratorio();
                productoPrecio = producto.getPrecio();
                int stock = producto.getStock();

                txtProductoCodigo.setText(codigo +"");
                txtProductoNombre.setText(nombre);
                txtProductoLab.setText(laboratorio);
                txtProductoPrecio.setText(productoPrecio+"");
                txtProductoStock.setText(stock + "");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Este producto no existe.");
            }
        }
        
        if((txtCodigoCliente.getText().isEmpty()))
        {
            buscarCliente.actualizarTabla();
            buscarCliente.setVisible(true);   
        }
        else
        {
            int codigo = Integer.parseInt(txtCodigoCliente.getText());
            if(validaExistenciaCliente(codigo))
            {
                Cliente cliente;

                cliente = (Cliente) new ClientesCRUDImp().mostrar(codigo).get(0);
                codigo = cliente.getCodigo();
                String nombre = cliente.getNombres();

                txtCodigoCliente.setText(codigo +"");
                txtClienteNombre.setText(nombre);
            }
            else
            {
                txtCodigoCliente.setText("");
                int resp = JOptionPane.showConfirmDialog(this, "Este cliente no existe desea añadirlo");

                Cliente cliente = new Cliente();
                cliente.setCodigo(codigo);

                if(resp == 0)
                {
                    mantCliente.setVisible(true);
                }
            }
            
        }
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtProductoCodigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtClienteNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtProductoNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        txtProductoStock = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnVaciarCampos = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAniadirVenta = new javax.swing.JButton();
        btnGenerarVenta = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        txtProductoPrecio = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtProductoLab = new javax.swing.JTextField();
        txtNoFactura = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtVentaTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtVentaTotalGeneral = new javax.swing.JTextField();
        txtVentaImpuestos = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mLimpiar = new javax.swing.JMenuItem();
        mNuevo = new javax.swing.JMenuItem();
        mBuscar = new javax.swing.JMenuItem();
        mAgregarProducto = new javax.swing.JMenuItem();
        mGenerarVenta = new javax.swing.JMenuItem();
        mSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mEliminar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transaccion Venta");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(14, 13, 13));
        jLabel2.setText("No. Factura");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 80, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(14, 13, 13));
        jLabel3.setText("Cod. Cliente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 100, -1));

        txtCodigoCliente.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 60, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(14, 13, 13));
        jLabel4.setText("Cantidad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 60, -1));

        txtProductoCodigo.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtProductoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 60, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 10, 180));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(14, 13, 13));
        jLabel5.setText("Fecha");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 50, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(14, 13, 13));
        jLabel6.setText("Cliente");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 100, -1));

        txtClienteNombre.setEditable(false);
        txtClienteNombre.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtClienteNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 190, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(14, 13, 13));
        jLabel7.setText("Producto");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 100, -1));

        txtProductoNombre.setEditable(false);
        txtProductoNombre.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtProductoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 190, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(14, 13, 13));
        jLabel8.setText("Precio");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 40, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(14, 13, 13));
        jLabel9.setText("Cod. Producto");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 100, -1));

        spnCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCantidadStateChanged(evt);
            }
        });
        jPanel1.add(spnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 60, -1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(14, 13, 13));
        jLabel10.setText("Stock");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 50, -1));

        txtProductoStock.setEditable(false);
        txtProductoStock.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtProductoStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 60, -1));

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnVaciarCampos.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        btnVaciarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-nueva-tienda-80.png"))); // NOI18N
        btnVaciarCampos.setFocusable(false);
        btnVaciarCampos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVaciarCampos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVaciarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarCamposActionPerformed(evt);
            }
        });
        jToolBar1.add(btnVaciarCampos);

        btnNuevoCliente.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        btnNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnNuevoCliente.setFocusable(false);
        btnNuevoCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevoCliente);

        btnBuscar.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnBuscar.setFocusable(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscar);

        btnAniadirVenta.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        btnAniadirVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-add-basket-48.png"))); // NOI18N
        btnAniadirVenta.setFocusable(false);
        btnAniadirVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAniadirVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAniadirVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirVentaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAniadirVenta);

        btnGenerarVenta.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pngwing.com.png"))); // NOI18N
        btnGenerarVenta.setFocusable(false);
        btnGenerarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGenerarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGenerarVenta);

        btnEliminar.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        btnSalir.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        btnSalir.setFocusable(false);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalir);

        jPanel1.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 40));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 570, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 660, -1));

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NRO", "codProducto", "Producto", "Laboratorio", "Cantidad", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVenta);
        if (tblVenta.getColumnModel().getColumnCount() > 0) {
            tblVenta.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblVenta.getColumnModel().getColumn(1).setPreferredWidth(35);
            tblVenta.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 820, 320));

        txtProductoPrecio.setEditable(false);
        txtProductoPrecio.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtProductoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 90, -1));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(14, 13, 13));
        jLabel14.setText("Laboratorio");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 80, -1));

        txtProductoLab.setEditable(false);
        txtProductoLab.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtProductoLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 190, -1));

        txtNoFactura.setEditable(false);
        txtNoFactura.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtNoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 60, -1));

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(14, 13, 13));
        jLabel11.setText("Itbis");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 40, 20));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(14, 13, 13));
        jLabel12.setText("Sub Total");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 20));

        txtVentaTotal.setEditable(false);
        txtVentaTotal.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        txtVentaTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel2.add(txtVentaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 130, 20));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(14, 13, 13));
        jLabel13.setText("Total");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 40, 20));

        txtVentaTotalGeneral.setEditable(false);
        txtVentaTotalGeneral.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        txtVentaTotalGeneral.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel2.add(txtVentaTotalGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 130, 20));

        txtVentaImpuestos.setEditable(false);
        txtVentaImpuestos.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        txtVentaImpuestos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel2.add(txtVentaImpuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 130, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 540, 220, 110));

        jMenu1.setText("Archivo");

        mLimpiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/icons8-nueva-tienda-80.png"))); // NOI18N
        mLimpiar.setText("Nueva Venta");
        mLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLimpiarActionPerformed(evt);
            }
        });
        jMenu1.add(mLimpiar);

        mNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/agregar.png"))); // NOI18N
        mNuevo.setText("Agregar Cliente");
        mNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(mNuevo);

        mBuscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/buscar.png"))); // NOI18N
        mBuscar.setText("Buscar");
        mBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mBuscarActionPerformed(evt);
            }
        });
        jMenu1.add(mBuscar);

        mAgregarProducto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/icons8-add-basket-48.png"))); // NOI18N
        mAgregarProducto.setText("Agregar a Venta");
        mAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAgregarProductoActionPerformed(evt);
            }
        });
        jMenu1.add(mAgregarProducto);

        mGenerarVenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/pngwing.com.png"))); // NOI18N
        mGenerarVenta.setText("Generar Venta");
        mGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGenerarVentaActionPerformed(evt);
            }
        });
        jMenu1.add(mGenerarVenta);

        mSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        mSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/salir.png"))); // NOI18N
        mSalir.setText("Salir");
        mSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edicción");

        mEliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/eliminar.png"))); // NOI18N
        mEliminar.setText("Eliminar");
        mEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEliminarActionPerformed(evt);
            }
        });
        jMenu2.add(mEliminar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void mNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNuevoActionPerformed
        mantCliente.setVisible(true);
    }//GEN-LAST:event_mNuevoActionPerformed

    private void mBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_mBuscarActionPerformed

    private void mAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAgregarProductoActionPerformed
        aniadirVenta();
    }//GEN-LAST:event_mAgregarProductoActionPerformed

    private void mEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_mEliminarActionPerformed

    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_mSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
            
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        mantCliente.setVisible(true);
        
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnAniadirVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirVentaActionPerformed
        aniadirVenta();
    }//GEN-LAST:event_btnAniadirVentaActionPerformed

    private void aniadirVenta()
    {
        if(!(txtProductoCodigo.getText().isEmpty()) && !(txtCodigoCliente.getText().isEmpty()))
        {
            int codigoProducto, cantidad, stock; 
            double precioTotal, precio;
            String productoNombre, productoLaboratorio;

            stock = Integer.parseInt(txtProductoStock.getText());
            cantidad = (int) spnCantidad.getValue();
            
            if(stock>0 && cantidad != 0 && ((stock - cantidad) >= 0))
            {

                modelo = (DefaultTableModel) tblVenta.getModel();


                codigoProducto = Integer.parseInt(txtProductoCodigo.getText());
                productoNombre = txtProductoNombre.getText();
                productoLaboratorio = txtProductoLab.getText();

                precio = productoPrecio;
                precioTotal = precio * cantidad;

                Object[] celdas = {codigoVenta, codigoProducto, productoNombre, productoLaboratorio, cantidad, precio, precioTotal};

                modelo.addRow(celdas);
                calcularTotal();
            }
            else
            {
                if(stock<=0)
                    JOptionPane.showMessageDialog(this, "No hay existencia de este producto", "Producto", JOptionPane.INFORMATION_MESSAGE);
                if(cantidad==0)
                    JOptionPane.showMessageDialog(this, "La cantidad esta colocada en 0", "Producto", JOptionPane.INFORMATION_MESSAGE);
                if((stock - cantidad) < 0)
                    JOptionPane.showMessageDialog(this, "Cantidad no valida para la venta, elija una cantidad menor.", "Producto", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Primero seleccione un cliente y un producto. ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void calcularTotal()
    {
        double precioTotal = 0, impuestos = 0;
        
        for (int i = 0; i < tblVenta.getRowCount(); i++) 
        {
            precioTotal += Double.parseDouble(tblVenta.getValueAt(i, 6).toString());
            impuestos += precioTotal * 0.18;
            
        }
        
        txtVentaTotal.setText(precioTotal - impuestos +"");
        txtVentaImpuestos.setText(impuestos + "");
        txtVentaTotalGeneral.setText(precioTotal+"");
    }
    
    private void btnVaciarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarCamposActionPerformed
       limpiarCampos();
       
       
    }//GEN-LAST:event_btnVaciarCamposActionPerformed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        generarVenta();
        
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void generarVenta()
    {
        int resp = JOptionPane.showConfirmDialog(this, "¿Está seguro?");
        if(resp == 0)
        {
            if(tblVenta.getRowCount() != 0)
            {
                int  codigoEmpleado, codigoCliente, codigoProducto, codVenta, cantidad;
                String numeroSerie, estado;
                double total, precioVenta;

                numeroSerie = "FD12";
                codigoEmpleado = empleado.getCodigo();
                codigoCliente = Integer.parseInt(txtCodigoCliente.getText());
                estado = "Completado";
                total = Double.parseDouble(txtVentaTotalGeneral.getText());

                Venta venta = new Venta(0, numeroSerie, codigoCliente, codigoEmpleado, "", total, estado);

                VentasCRUDImp ventas = new VentasCRUDImp();
                ventas.setVenta(venta);
                ventas.insertar();

                /* Pasando datos de detalle Venta */
                DetalleVentas detalleVenta = new DetalleVentas();

                for(int i = 0; i<tblVenta.getRowCount(); i++)
                {
                    cantidad = Integer.parseInt(tblVenta.getValueAt(i, 4).toString());
                    precioVenta = Double.parseDouble(tblVenta.getValueAt(i, 5).toString());
                    codigoProducto = Integer.parseInt(tblVenta.getValueAt(i, 1).toString());

                    detalleVenta.setCantidad(cantidad);
                    detalleVenta.setCodigoProducto(codigoProducto);
                    detalleVenta.setCodigoVenta(codigoVenta);
                    detalleVenta.setPrecioVenta(precioVenta);

                    ventas.setDetalleVentas(detalleVenta);
                    ventas.insertarDetalleVentas();


                }

                generarFactura();
                desactivaBotones();
                JOptionPane.showMessageDialog(null, "Compra realizada");
                tblVenta.setOpaque(true);

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Debe de agregar al menos un producto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    } 
    
    private void generarFactura()
    {
        
        ArrayList<Factura> facturasLista = new ArrayList();
        
        String producto, laboratorio, empleadoNombre;
        int cantidad, numeroFactura;
        double precio, precioTotal, impuestos, subTotal;
        
        
        for(int i = 0; i<tblVenta.getRowCount(); i++)
        {
            Factura factura = new Factura();
         
            producto = tblVenta.getValueAt(i, 2).toString();
            laboratorio = tblVenta.getValueAt(i, 3).toString();
            cantidad = Integer.parseInt(tblVenta.getValueAt(i, 4).toString());
            precio = Double.parseDouble(tblVenta.getValueAt(i, 5).toString());
            
            factura.setProductoNombre(producto);
            factura.setProductoLaboratorio(laboratorio);
            factura.setProductoCantidad(cantidad);
            factura.setProductoPrecio(precio);
            
            facturasLista.add(factura);
        }
        
        subTotal = Double.parseDouble(txtVentaTotal.getText());
        impuestos = Double.parseDouble(txtVentaImpuestos.getText());
        precioTotal = Double.parseDouble(txtVentaTotalGeneral.getText());
        
        
        empleadoNombre = empleado.getNombre();
        numeroFactura = codigoVenta;
        
        new Factura().generarFactura(precioTotal, impuestos, subTotal, empleadoNombre, numeroFactura, facturasLista);
        actualizarStock();
        
    }
           
    
    private void actualizarStock()
    {
        int cantidad, codigoProducto, stock, nuevoStock;
        Producto producto;
        
        
        for (int i = 0; i < tblVenta.getRowCount(); i++) {
            codigoProducto = Integer.parseInt(tblVenta.getValueAt(i,1).toString());
            cantidad = Integer.parseInt(tblVenta.getValueAt(i, 4).toString());
            
            producto = (Producto) new ProductosCRUDImp().mostrar(codigoProducto).get(0);
            stock = producto.getStock();
            
            nuevoStock = stock - cantidad;
            new ProductosCRUDImp().actualizarStock(codigoProducto, nuevoStock);
        }
        
        
        
    }
    
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void eliminar(){
        int fila = tblVenta.getSelectedRow();
        DefaultTableModel modeloModificar;
        
        if(fila != -1)
        {
            modeloModificar = (DefaultTableModel) tblVenta.getModel();
            
            modeloModificar.removeRow(fila);
            calcularTotal();
            
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Seleccione un articulo a eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    private void spnCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCantidadStateChanged
           
        if(!(txtProductoPrecio.getText().isEmpty()))
        {
            int productoCodigo = Integer.parseInt(txtProductoCodigo.getText());
            Producto producto =  (Producto) new ProductosCRUDImp().mostrar(productoCodigo).get(0);
            productoPrecio = producto.getPrecio();
            
            if(Integer.parseInt(spnCantidad.getValue().toString()) < 0 )
            {
                spnCantidad.setValue(0);
            }
            else
                if(Integer.parseInt(spnCantidad.getValue().toString()) == 0 )
                {

                }
            else
            {
                txtProductoPrecio.setText(productoPrecio * Integer.parseInt((spnCantidad.getValue().toString()))+"");
                
            }
        }
    }//GEN-LAST:event_spnCantidadStateChanged

    private void mLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_mLimpiarActionPerformed

    private void mGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGenerarVentaActionPerformed
        generarVenta();
    }//GEN-LAST:event_mGenerarVentaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadirVenta;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVaciarCampos;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mAgregarProducto;
    private javax.swing.JMenuItem mBuscar;
    private javax.swing.JMenuItem mEliminar;
    private javax.swing.JMenuItem mGenerarVenta;
    private javax.swing.JMenuItem mLimpiar;
    private javax.swing.JMenuItem mNuevo;
    private javax.swing.JMenuItem mSalir;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblVenta;
    private javax.swing.JTextField txtClienteNombre;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNoFactura;
    private javax.swing.JTextField txtProductoCodigo;
    private javax.swing.JTextField txtProductoLab;
    private javax.swing.JTextField txtProductoNombre;
    private javax.swing.JTextField txtProductoPrecio;
    private javax.swing.JTextField txtProductoStock;
    private javax.swing.JTextField txtVentaImpuestos;
    private javax.swing.JTextField txtVentaTotal;
    private javax.swing.JTextField txtVentaTotalGeneral;
    // End of variables declaration//GEN-END:variables
}
