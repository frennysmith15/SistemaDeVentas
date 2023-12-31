/*
 * Frenny Smith De La Cruz All Rights Reserved <Propiedad Intelectual> *Solo personal autorizado*.
 * Matricula -> 100510483
 * UNIVERSIDAD AUTONOMA DE SANTO DOMINGO RECINTO UASD SAN FRANCISCO DE MACORIS (CURNE).
 */
package prjsistemaventas.Formularios;

import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import prjsistemaventas.ConexionBD;
import prjsistemaventas.Implementaciones.EmpleadosCRUDImp;
import prjsistemaventas.Implementaciones.ProductosCRUDImp;
import prjsistemaventas.Implementaciones.VentasCRUDImp;
import prjsistemaventas.dao.Empleado;
import prjsistemaventas.dao.Producto;
import prjsistemaventas.dao.Usuario;
import prjsistemaventas.dao.Venta;

/**
 *
 * @author Frensth
 */
public class FrmFormularioPrincipal extends javax.swing.JFrame implements Runnable{
    
    private Empleado e;
    long ahora;
    private Thread hilo;
    EmpleadosCRUDImp empleadobd;
    FrmConsultarEmpleados consultarEmpleado;
    FrmConsultarUsuarios consultarUsuarios;
    
    public static FrmMantenimimientoUsuario mantUsuario = new FrmMantenimimientoUsuario();
    public static FrmMantenimimientoEmpleado mantEmpleado = new FrmMantenimimientoEmpleado();
    public static FrmMantenimientoCliente mantCliente = new FrmMantenimientoCliente();
    public static FrmMantenimimientoProducto mantProducto = new FrmMantenimimientoProducto();
    public static FrmTransaccionVenta transVenta = new FrmTransaccionVenta();
    
    public FrmFormularioPrincipal(Usuario user) {
        initComponents();
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState()/*this.MAXIMIZED_BOTH*/);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Cruzrojasinfondos.png")).getImage());
        ArrayList<Empleado> empleado = new EmpleadosCRUDImp().mostrar(user.getId());
        this.e = empleado.get(0);
        consultarEmpleado = new FrmConsultarEmpleados();
        consultarUsuarios = new FrmConsultarUsuarios();
        
        empleadobd = new EmpleadosCRUDImp(e);
        registrarInicio();
        lblBienvenida.setText("Bienvenido: " + e.getNombre());
        
        hilo = new Thread(this);
        hilo.start();
        cerrar();
    }
    
    
    private void cerrar()
    {
        try{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() 
            {
                @Override
                public void windowClosing(WindowEvent e)
                {
                    confirmarSalida();
                }
                
            });
            
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());;
        }
    }
     
    private void registrarInicio()
    {
        empleadobd.fechadeInicio();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        mantenimientoEmpleado = new javax.swing.JMenuItem();
        mantenimientoUsuario = new javax.swing.JMenuItem();
        mClientes = new javax.swing.JMenuItem();
        mProducto = new javax.swing.JMenuItem();
        mAopcSalir = new javax.swing.JMenuItem();
        menuTrans = new javax.swing.JMenu();
        mVetas = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        mReporteProductos = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mEmpleado = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        mConsultarEmpleados = new javax.swing.JMenuItem();
        mConsultarUsuarios = new javax.swing.JMenuItem();
        menuUtil = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de venta");
        setExtendedState(6);

        jPanel1.setBackground(new java.awt.Color(205, 205, 205));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cruzroja.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(28, 26, 26));
        jLabel3.setText("Por: Frenny Smith De La Cruz Burgos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 650, -1, -1));

        lblBienvenida.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        lblBienvenida.setText("Bienvenido: ");
        jPanel1.add(lblBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/3.jpg"))); // NOI18N
        jLabel4.setText("Bienvenido: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 0, 1770, 670));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        menuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/archivo.png"))); // NOI18N
        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        mantenimientoEmpleado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mantenimientoEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/empleado.png"))); // NOI18N
        mantenimientoEmpleado.setText("Empleados");
        mantenimientoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantenimientoEmpleadoActionPerformed(evt);
            }
        });
        menuArchivo.add(mantenimientoEmpleado);

        mantenimientoUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mantenimientoUsuario.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        mantenimientoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/User_Folder_23371.png"))); // NOI18N
        mantenimientoUsuario.setText("Usuarios");
        mantenimientoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantenimientoUsuarioActionPerformed(evt);
            }
        });
        menuArchivo.add(mantenimientoUsuario);

        mClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/clientes.png"))); // NOI18N
        mClientes.setText("Clientes");
        mClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mClientesActionPerformed(evt);
            }
        });
        menuArchivo.add(mClientes);

        mProducto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/icons8-producto-16.png"))); // NOI18N
        mProducto.setText("Productos");
        mProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mProductoActionPerformed(evt);
            }
        });
        menuArchivo.add(mProducto);

        mAopcSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        mAopcSalir.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        mAopcSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/salir.png"))); // NOI18N
        mAopcSalir.setText("Salir");
        mAopcSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAopcSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(mAopcSalir);

        jMenuBar1.add(menuArchivo);

        menuTrans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/transacciones.png"))); // NOI18N
        menuTrans.setText("Transacciones");
        menuTrans.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        mVetas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mVetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/ventas.png"))); // NOI18N
        mVetas.setText("Ventas");
        mVetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mVetasActionPerformed(evt);
            }
        });
        menuTrans.add(mVetas);

        jMenuBar1.add(menuTrans);

        menuReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reportes.png"))); // NOI18N
        menuReportes.setText("Reportes");
        menuReportes.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        mReporteProductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mReporteProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/box.png"))); // NOI18N
        mReporteProductos.setText("Productos");
        mReporteProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mReporteProductosActionPerformed(evt);
            }
        });
        menuReportes.add(mReporteProductos);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/productoReport.png"))); // NOI18N
        jMenuItem2.setText("Ventas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuReportes.add(jMenuItem2);

        mEmpleado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/evaluacion.png"))); // NOI18N
        mEmpleado.setText("Empleados");
        mEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEmpleadoActionPerformed(evt);
            }
        });
        menuReportes.add(mEmpleado);

        jMenuBar1.add(menuReportes);

        menuConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consultar.png"))); // NOI18N
        menuConsultas.setText("Consultas");
        menuConsultas.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        mConsultarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/consultarempleado.png"))); // NOI18N
        mConsultarEmpleados.setText("Empleados");
        mConsultarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConsultarEmpleadosActionPerformed(evt);
            }
        });
        menuConsultas.add(mConsultarEmpleados);

        mConsultarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/user-manage_114453.png"))); // NOI18N
        mConsultarUsuarios.setText("Usuarios");
        mConsultarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConsultarUsuariosActionPerformed(evt);
            }
        });
        menuConsultas.add(mConsultarUsuarios);

        jMenuBar1.add(menuConsultas);

        menuUtil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/utilidades.png"))); // NOI18N
        menuUtil.setText("Utilidades");
        menuUtil.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/business-color_calculator_icon-icons.com_53466.png"))); // NOI18N
        jMenuItem5.setText("Calculadora");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuUtil.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peques/notepad_25496.png"))); // NOI18N
        jMenuItem6.setText("Bloc de Notas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuUtil.add(jMenuItem6);

        jMenuBar1.add(menuUtil);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarSalida()
    {
        
        JFrame form;
        form = this;
        form.setAlwaysOnTop(true);
        int valor = JOptionPane.showConfirmDialog(form, "¿Desea salir del sistema?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(valor == JOptionPane.YES_OPTION)
        {
            empleadobd.fechadeSalida();
            ConexionBD.instancia.desconectar();
            System.exit(0);
            
        }
        else
        {
            form.setAlwaysOnTop(false);
        }
    }
    
    private void mantenimientoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantenimientoUsuarioActionPerformed
        
        mantUsuario.setVisible(true);
        
    }//GEN-LAST:event_mantenimientoUsuarioActionPerformed

    private void mAopcSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAopcSalirActionPerformed
        confirmarSalida();
    }//GEN-LAST:event_mAopcSalirActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Runtime ejecuta = Runtime.getRuntime(); 
        
        try{
            ejecuta.exec("C:/Windows/System32/NOTEPAD.EXE"); 
        }
        catch(Exception e){}

	
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void mantenimientoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantenimientoEmpleadoActionPerformed
        mantEmpleado.setVisible(true);
    }//GEN-LAST:event_mantenimientoEmpleadoActionPerformed

    private void mClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mClientesActionPerformed
        mantCliente.setVisible(true);
    }//GEN-LAST:event_mClientesActionPerformed

    private void mProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mProductoActionPerformed
        mantProducto.setVisible(true);
    }//GEN-LAST:event_mProductoActionPerformed

    private void mVetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mVetasActionPerformed
        transVenta.setEmpleado(e); 
        transVenta.setVisible(true);
        transVenta.limpiarCampos();


    }//GEN-LAST:event_mVetasActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Runtime ejecuta = Runtime.getRuntime();; 
       
        try {
            ejecuta.exec("calc");
        } catch (IOException ex) {
            Logger.getLogger(FrmFormularioPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void mConsultarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConsultarEmpleadosActionPerformed
        consultarEmpleado.setVisible(true);
        consultarEmpleado.actualizarTabla();
    }//GEN-LAST:event_mConsultarEmpleadosActionPerformed

    private void mConsultarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConsultarUsuariosActionPerformed
        consultarUsuarios.setVisible(true);
        consultarUsuarios.actualizarTabla();
    }//GEN-LAST:event_mConsultarUsuariosActionPerformed

    private void mEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEmpleadoActionPerformed
        new Empleado().reporte(new EmpleadosCRUDImp().mostrarTodos());
    }//GEN-LAST:event_mEmpleadoActionPerformed

    private void mReporteProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mReporteProductosActionPerformed
        new Producto().reporte(new ProductosCRUDImp().mostrarTodos());
    }//GEN-LAST:event_mReporteProductosActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new Venta().reporte(new VentasCRUDImp().mostrarTodos());
    }//GEN-LAST:event_jMenuItem2ActionPerformed
   
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JMenuItem mAopcSalir;
    private javax.swing.JMenuItem mClientes;
    private javax.swing.JMenuItem mConsultarEmpleados;
    private javax.swing.JMenuItem mConsultarUsuarios;
    private javax.swing.JMenuItem mEmpleado;
    private javax.swing.JMenuItem mProducto;
    private javax.swing.JMenuItem mReporteProductos;
    private javax.swing.JMenuItem mVetas;
    private javax.swing.JMenuItem mantenimientoEmpleado;
    private javax.swing.JMenuItem mantenimientoUsuario;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenu menuTrans;
    private javax.swing.JMenu menuUtil;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
        try {
         
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FrmFormularioPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
       lblBienvenida.setVisible(false);
    }

  
   
    
}
