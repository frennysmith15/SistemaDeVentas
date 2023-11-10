/*
 * Frenny Smith De La Cruz All Rights Reserved <Propiedad Intelectual> *Solo personal autorizado*.
 * Matricula -> 100510483
 * UNIVERSIDAD AUTONOMA DE SANTO DOMINGO RECINTO UASD SAN FRANCISCO DE MACORIS (CURNE).
 */
package prjsistemaventas.Formularios;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import prjsistemaventas.dao.Usuario;
import prjsistemaventas.Implementaciones.UsuariosCRUDImp;

/**
 *
 * @author Frensth
 */
public class FrmMantenimimientoUsuario extends javax.swing.JFrame {

    FrmBuscarUsuario frmBuscar = new FrmBuscarUsuario();
    
    public FrmMantenimimientoUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Cruzrojasinfondos.png")).getImage());

    }

    private void guardar(){
         
        String usuario, contrasenia, confirmacion;
        usuario = txtUsuario.getText();
        contrasenia = String.valueOf(txtPassword.getPassword());
        confirmacion = String.valueOf(txtPassword1.getPassword());
            
        if(txtCodigo.getText().isEmpty())
        {
            if(!(usuario.isEmpty()) && !(contrasenia.isEmpty()) && !(confirmacion.isEmpty()))
            {
                if(evaluaExistencia())
                {
                    if(contrasenia.contentEquals(confirmacion))
                    {
                        Usuario u = new Usuario(0, usuario, contrasenia);
                        if(insertar(u))
                        {
                            JOptionPane.showMessageDialog(this,"El registro se inserto correctamente", "Registro insertado",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(this,"Error al momento de guardar", "Error en la base de datos",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Las contraseñas no coinciden", "Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Usuario existente. Eliga otro nombre de usuario. ", "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Los campos estan vacios", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            int codigo;
            codigo = Integer.parseInt(txtCodigo.getText());
            
            Usuario u = new Usuario(codigo, usuario, contrasenia);
            if(evaluarExistencia(codigo))
            {
                if(contrasenia.contentEquals(confirmacion))
                {
                    if(actualizar(u))
                        JOptionPane.showMessageDialog(this,"El registro se actualizo correctamente", "Registro insertado",JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(this,"Error al momento de editar", "Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                     JOptionPane.showMessageDialog(this,"Contraseñas no coinciden", "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Usuario existente. Eliga otro nombre de usuario. ", "Error",JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    
    private void eliminar(){

        String usuario, contrasenia;
        int codigo;

       
        if(!(txtCodigo.getText().isEmpty()))
        {
            codigo = Integer.parseInt(txtCodigo.getText());
            usuario = txtUsuario.getText();
            contrasenia = String.valueOf(txtPassword.getPassword());
            
            int resp = JOptionPane.showConfirmDialog(this, "¿Está seguro?", "Eliminar registro", JOptionPane.WARNING_MESSAGE);

            Usuario u = new Usuario(codigo, usuario, contrasenia);

            
            if(resp == 0)
            {
                if(eliminar(u))
                    JOptionPane.showMessageDialog(this,"El registro se elimino correctamente", "Registro insertado",JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(this,"Error al momento de eliminar", "Error",JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    
    
    
   
    public void setTxt(int codigo, String usuario, String contrasenia)
    {
        txtCodigo.setText(codigo+"");
        txtUsuario.setText(usuario);
        txtPassword.setText(contrasenia);
        txtPassword1.setText(contrasenia);
        
    }
    
    private boolean evaluaExistencia()
    {
        ArrayList<Usuario> usuarios = new UsuariosCRUDImp().mostrarTodos();
        
        for(Usuario u : usuarios)
        {
            if(txtUsuario.getText().contentEquals(u.getUsuario()))
            {
                return false;
            }
        }
        return true;
    }
    
    private boolean evaluarExistencia(int codigo)
    {
        ArrayList<Usuario> usuario = new UsuariosCRUDImp().mostrar(codigo);
        
        
        if(txtUsuario.getText().contentEquals(usuario.get(0).getUsuario()))
        {
            return true;
        }
        else
        {
            return evaluaExistencia();
        }

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtPassword1 = new javax.swing.JPasswordField();
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
        setTitle("Mantenimiento Usuario");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(190, 190, 190));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 60, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(14, 13, 13));
        jLabel2.setText("Codigo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 9, 50, -1));

        txtUsuario.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 130, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(14, 13, 13));
        jLabel3.setText("Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 68, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(14, 13, 13));
        jLabel4.setText("Confirmación");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 98, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(14, 13, 13));
        jLabel5.setText("Usuario");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 39, 52, -1));

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 200, -1));
        jPanel1.add(txtPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 370, 140));

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

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 40));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarCampos(){
        txtCodigo.setText("");
        txtUsuario.setText("");
        txtPassword.setText("");
        txtPassword1.setText("");
    }
    
    private Boolean insertar(Usuario usuario)
    {
        UsuariosCRUDImp usuarioCRUD = new UsuariosCRUDImp(usuario);
        return usuarioCRUD.insertar();
        
    }
    
    private Boolean actualizar(Usuario usuario)
    {
        UsuariosCRUDImp usuarioCRUD = new UsuariosCRUDImp(usuario);
        return usuarioCRUD.actualizar();
        
    }
    
    private Boolean eliminar(Usuario usuario)
    {
        UsuariosCRUDImp usuarioCRUD = new UsuariosCRUDImp(usuario);
        limpiarCampos();
        return usuarioCRUD.eliminar();
        
    }
    
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();            
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       frmBuscar.ActualizarTabla();
       frmBuscar.setVisible(true);
       
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void mBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mBuscarActionPerformed
        frmBuscar.ActualizarTabla();
        frmBuscar.setVisible(true);
    }//GEN-LAST:event_mBuscarActionPerformed

    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_mSalirActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void mNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNuevoActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_mNuevoActionPerformed

    private void mEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_mEliminarActionPerformed

    private void mGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGuardarActionPerformed
       guardar();
    }//GEN-LAST:event_mGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(){
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
            java.util.logging.Logger.getLogger(FrmMantenimimientoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimimientoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimimientoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMantenimimientoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMantenimimientoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPassword1;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
