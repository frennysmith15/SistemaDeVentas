/*
 * Frenny Smith De La Cruz All Rights Reserved <Propiedad Intelectual> *Solo personal autorizado*.
 * Matricula -> 100510483
 * UNIVERSIDAD AUTONOMA DE SANTO DOMINGO RECINTO UASD SAN FRANCISCO DE MACORIS (CURNE).
 */
package prjsistemaventas.Formularios;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import prjsistemaventas.Implementaciones.EmpleadosCRUDImp;
import prjsistemaventas.dao.Empleado;

/**
 *
 * @author Frensth
 */
public class FrmBuscarEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form FrmBuscarEmpleado
     */
    Empleado empleado;
    
    
    
    public FrmBuscarEmpleado() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Cruzrojasinfondos.png")).getImage());
    }

     public void ActualizarTabla()
    {
       DefaultTableModel modelo = new DefaultTableModel();
       
        String[] columnas = new String[]{"Codigo", "Nombre", "Cedula", "Telefono", "Sexo", "Usuario"};
        
        for (int i = 0; i < columnas.length; i++) {
            modelo.addColumn(columnas[i]);
            
        }
       
        ArrayList<Empleado> empleadoList = new EmpleadosCRUDImp().mostrarTodos();
        int contador = 0;
     
        for(Empleado e : empleadoList)
        {
            
            Object celdas[] = new Object[6];
            celdas[0] = e.getCodigo();
            celdas[1] = e.getNombre();
            celdas[2] = e.getCedula();
            celdas[3] = e.getTelefono();
            celdas[4] = e.getSexo();
            celdas[5] = e.getUsuario();
            
                    
            modelo.addRow(celdas);
        }
        tblEmpleados.setModel(modelo);
        
        if (tblEmpleados.getColumnModel().getColumnCount() > 0) {
            tblEmpleados.getColumnModel().getColumn(0).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblEmpleados.getColumnModel().getColumn(1).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblEmpleados.getColumnModel().getColumn(2).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblEmpleados.getColumnModel().getColumn(3).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(4).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(4).setPreferredWidth(25);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnSeleccionar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mSeleccionar = new javax.swing.JMenuItem();
        mSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar empleado");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 40));

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Cedula", "Telefono", "Sexo", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEmpleados);
        if (tblEmpleados.getColumnModel().getColumnCount() > 0) {
            tblEmpleados.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblEmpleados.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblEmpleados.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblEmpleados.getColumnModel().getColumn(4).setPreferredWidth(25);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 580, 240));

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

    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
        this.dispose();

    }//GEN-LAST:event_mSalirActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if(empleado != null)
        {
            FrmFormularioPrincipal.mantEmpleado.setTxt(empleado);
        }
        this.dispose();
            
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int seleccionar = tblEmpleados.rowAtPoint(evt.getPoint());
        
        if(seleccionar != -1)
        {
            //"Codigo", "Nombre", "Cedula", "Telefono", "Sexo", "Usuario" 
            int codigo = Integer.valueOf(String.valueOf(tblEmpleados.getValueAt(seleccionar, 0)));
            String nombre = String.valueOf(tblEmpleados.getValueAt(seleccionar, 1));
            String cedula = String.valueOf(tblEmpleados.getValueAt(seleccionar, 2));
            String telefono = String.valueOf(tblEmpleados.getValueAt(seleccionar, 3));
            String sexo = String.valueOf(tblEmpleados.getValueAt(seleccionar, 4));
            String usuario = String.valueOf(tblEmpleados.getValueAt(seleccionar, 5));


            empleado = new Empleado(codigo, cedula, nombre, telefono, sexo, usuario);

        }
        else
        {
            JOptionPane.showMessageDialog(null,"Debe seleccionar una opcion", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void mSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSeleccionarActionPerformed
        if(empleado != null)
        {
            FrmFormularioPrincipal.mantEmpleado.setTxt(empleado);
        }
        this.dispose();
    }//GEN-LAST:event_mSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mSalir;
    private javax.swing.JMenuItem mSeleccionar;
    private javax.swing.JTable tblEmpleados;
    // End of variables declaration//GEN-END:variables
}
