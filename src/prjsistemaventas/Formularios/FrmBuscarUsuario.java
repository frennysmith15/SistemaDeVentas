/*
 * Frenny Smith De La Cruz All Rights Reserved <Propiedad Intelectual> *Solo personal autorizado*.
 * Matricula -> 100510483
 * UNIVERSIDAD AUTONOMA DE SANTO DOMINGO RECINTO UASD SAN FRANCISCO DE MACORIS (CURNE).
 */
package prjsistemaventas.Formularios;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import prjsistemaventas.Implementaciones.UsuariosCRUDImp;
import prjsistemaventas.dao.Usuario;

/**
 *
 * @author Frensth
 */
public class FrmBuscarUsuario extends javax.swing.JFrame {

    
    
    private int codigo;
    private String usuario, contrasenia;
    String[] contrasenias;
    
    public FrmBuscarUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Cruzrojasinfondos.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnSeleccionar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mSeleccionar = new javax.swing.JMenuItem();
        mSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Usuario");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Usuarios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblUsuarios);
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblUsuarios.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 240));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 42, 260, 240));

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnSeleccionar.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Inspection-80_icon-icons.com_57310.png"))); // NOI18N
        btnSeleccionar.setFocusable(false);
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSeleccionar);

        btnSalir.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalir);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 40));

        jMenu1.setText("Archivo");

        mSeleccionar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/Inspection-80_icon-icons.com_57310.png"))); // NOI18N
        mSeleccionar.setText("Seleccionar");
        mSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSeleccionarActionPerformed(evt);
            }
        });
        jMenu1.add(mSeleccionar);

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

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ActualizarTabla()
    {
      DefaultTableModel modelo = new DefaultTableModel();
        
        ArrayList<Usuario> usuariosList = new UsuariosCRUDImp().mostrarTodos();
        contrasenias = new String[usuariosList.size()];
        int contador = 0;
        
        
        modelo.addColumn("Código");
        modelo.addColumn("Usuario");

        for(Usuario u : usuariosList)
        {
            
            Object celdas[] = new Object[2];
            celdas[0] = u.getId();
            celdas[1] = u.getUsuario();
            contrasenias[contador] = u.getContrasenia();
                    
            modelo.addRow(celdas);
            contador++;
        }
        
        
        tblUsuarios.setModel(modelo);
        
        if(tblUsuarios.getColumnModel().getColumnCount() > 0) 
        {
            tblUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblUsuarios.getColumnModel().getColumn(1).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(1).setPreferredWidth(150);
        }
    }
    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_mSalirActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
       FrmFormularioPrincipal.mantUsuario.setTxt(codigo, usuario, contrasenia);
       this.dispose();
               
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    
    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        int seleccionar = tblUsuarios.rowAtPoint(evt.getPoint());
        
        codigo = Integer.valueOf(String.valueOf(tblUsuarios.getValueAt(seleccionar, 0)));
        usuario = String.valueOf(tblUsuarios.getValueAt(seleccionar, 1));
        contrasenia = contrasenias[codigo-1];
        
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void mSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSeleccionarActionPerformed
        FrmFormularioPrincipal.mantUsuario.setTxt(codigo, usuario, contrasenia);
        this.dispose();
    }//GEN-LAST:event_mSeleccionarActionPerformed
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mSalir;
    private javax.swing.JMenuItem mSeleccionar;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
