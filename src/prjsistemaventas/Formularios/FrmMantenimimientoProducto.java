/*
 * Frenny Smith De La Cruz All Rights Reserved <Propiedad Intelectual> *Solo personal autorizado*.
 * Matricula -> 100510483
 * UNIVERSIDAD AUTONOMA DE SANTO DOMINGO RECINTO UASD SAN FRANCISCO DE MACORIS (CURNE).
 */
package prjsistemaventas.Formularios;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import prjsistemaventas.Implementaciones.ProductosCRUDImp;
import prjsistemaventas.dao.Producto;

/**
 *
 * @author Frensth
 */
public class FrmMantenimimientoProducto extends javax.swing.JFrame {

    FrmBuscarProducto frmBuscarP = new FrmBuscarProducto();
    
     public FrmMantenimimientoProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Cruzrojasinfondos.png")).getImage());
    }

    private void guardar() {

        int codigo, stock;
        double precio;
        char estado;
        String nombre, laboratorio;

        if (estaVacio()) {

            nombre = txtNombre.getText();
            laboratorio = txtLab.getText();
            stock = Integer.parseInt(txtStock.getText());
            precio = Double.parseDouble(txPrecio.getText());
            estado = txtEstado.getText().charAt(0);


            if (txtCodigo.getText().isEmpty()) {
                
                Producto producto = new Producto(0, nombre, laboratorio, precio, stock, estado);

                if (insertar(producto)) {
                    JOptionPane.showMessageDialog(this, "El registro se inserto correctamente", "Registro insertado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al momento de guardar", "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
                }

                
            } else {

                codigo = Integer.parseInt(txtCodigo.getText());

                Producto producto = new Producto(codigo, nombre, laboratorio, precio, stock, estado);

                if (actualizar(producto)) 
                {
                    JOptionPane.showMessageDialog(this, "El registro se actualizo correctamente", "Registro insertado", JOptionPane.INFORMATION_MESSAGE);
                } else 
                {
                    JOptionPane.showMessageDialog(this, "Error al momento de editar", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        
        
        }
        else
            JOptionPane.showMessageDialog(this, "Los campos estan vacios", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void limpiarCampos(){
        txtCodigo.setText("");
        txtStock.setText("");
        txPrecio.setText("");
        txtNombre.setText("");
        txtLab.setText("");
        txtEstado.setText("");
    }
    
    public void setTxt(Producto producto)
    {
        txtCodigo.setText(producto.getCodigo()+"");
        txtStock.setText(producto.getStock()+"");
        txPrecio.setText(producto.getPrecio()+"");
        txtNombre.setText(producto.getNombres());
        txtLab.setText(producto.getLaboratorio());
        txtEstado.setText((producto.getEstado() == 'n' || producto.getEstado() =='N')? "Nuevo" : "Usado");
        
    }
    
    
    private boolean insertar(Producto producto) {
        ProductosCRUDImp productobd = new ProductosCRUDImp();
        productobd.setProducto(producto);
        
        return productobd.insertar();
        
    }
    
     private Boolean actualizar(Producto producto)
    {
        ProductosCRUDImp productobd = new ProductosCRUDImp();
         productobd.setProducto(producto);
        
        return productobd.actualizar();
        
    }
     
     private Boolean eliminar(Producto producto)
    {
        ProductosCRUDImp productobd = new ProductosCRUDImp();
        limpiarCampos();
         productobd.setProducto(producto);
        
        return productobd.eliminar();
    }
    
    public boolean estaVacio()
    {
        if(txtStock.getText().isEmpty() && txPrecio.getText().isEmpty() && txtLab.getText().isEmpty() && txtNombre.getText().isEmpty() && txtEstado.getText().isEmpty())
            return false;
        else
            return true;
                   
    }
    private void eliminar()
    {

        int codigo;

        if(!(txtCodigo.getText().isEmpty()))
        {
            codigo = Integer.parseInt(txtCodigo.getText());

            int resp = JOptionPane.showConfirmDialog(this, "¿Está seguro?", "Eliminar registro", JOptionPane.WARNING_MESSAGE);;

            Producto producto = new Producto();
            producto.setCodigo(codigo);

            if(resp == 0)
            {
                if(eliminar(producto))
                JOptionPane.showMessageDialog(this,"El registro se elimino correctamente", "Registro insertado",JOptionPane.INFORMATION_MESSAGE);
                else
                JOptionPane.showMessageDialog(this,"Error al momento de eliminar", "Error",JOptionPane.ERROR_MESSAGE);
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
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtLab = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mNuevo = new javax.swing.JMenuItem();
        mBuscar = new javax.swing.JMenuItem();
        mGuardar = new javax.swing.JMenuItem();
        mSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mEliminar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenimiento Productos");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(190, 190, 190));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 60, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(14, 13, 13));
        jLabel2.setText("Codigo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(14, 13, 13));
        jLabel5.setText("Nombres");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 60, -1));

        txtNombre.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 260, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(14, 13, 13));
        jLabel6.setText("Stock");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 70, -1));

        txtStock.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 70, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(14, 13, 13));
        jLabel4.setText("Precio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 60, -1));

        txPrecio.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 70, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(14, 13, 13));
        jLabel7.setText("Estado");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 70, -1));

        txtEstado.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 70, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(14, 13, 13));
        jLabel8.setText("Laboratorio");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, -1));

        txtLab.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 260, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 400, 170));

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnNuevo.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnNuevo.setFocusable(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnBuscar.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuscar);

        btnGuardar.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardar.setFocusable(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnEliminar.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setFocusable(false);
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

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 40));

        jMenu1.setText("Archivo");

        mNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/agregar.png"))); // NOI18N
        mNuevo.setText("Nuevo");
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

        mGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/guardar.png"))); // NOI18N
        mGuardar.setText("Guardar");
        mGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(mGuardar);

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

        getAccessibleContext().setAccessibleName("MantenimientoCliente");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        frmBuscarP.actualizarTabla();
        frmBuscarP.setVisible(true);

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void mBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mBuscarActionPerformed
        frmBuscarP.actualizarTabla();
        frmBuscarP.setVisible(true);
    }//GEN-LAST:event_mBuscarActionPerformed

    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_mSalirActionPerformed

    private void mNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNuevoActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_mNuevoActionPerformed

    private void mGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_mGuardarActionPerformed

    private void mEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mEliminarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mBuscar;
    private javax.swing.JMenuItem mEliminar;
    private javax.swing.JMenuItem mGuardar;
    private javax.swing.JMenuItem mNuevo;
    private javax.swing.JMenuItem mSalir;
    private javax.swing.JTextField txPrecio;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtLab;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

    
}
