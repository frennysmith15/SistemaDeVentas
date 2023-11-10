/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prjsistemaventas.Formularios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import prjsistemaventas.ConexionBD;

/**
 *
 * @author Frensth
 */
public class FrmAgregarServidor extends javax.swing.JFrame {

    String contenido;
    File archivo;
    
    public FrmAgregarServidor() {
        initComponents();
        archivo = new File("src/textos/basededatos.txt");
        this.setLocationRelativeTo(null);
        existencia();
          
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        agregarConexión = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtContrasenia = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPuerto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        txtBD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarConexión.setText("Agregar Conexión");
        agregarConexión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarConexiónActionPerformed(evt);
            }
        });
        jPanel1.add(agregarConexión, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jButton1.setText("Ayuda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 70, -1));
        jPanel1.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 120, -1));

        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel5.setText("Usuario");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 120, -1));
        jPanel1.add(txtPuerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 100, -1));

        jLabel4.setText("Puerto");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setText("IP");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 20, -1));
        jPanel1.add(txtIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 100, -1));
        jPanel1.add(txtBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 100, -1));

        jLabel1.setText("BD");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 20, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void existencia()
    {
        if(archivo.exists())
        {
            Connection conexion = ConexionBD.getConexion();
        }
        else
        {
            this.setVisible(true);
        }
        
        
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void agregarConexiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarConexiónActionPerformed
        contenido = txtBD.getText() + "||" + txtIP.getText() + "||" + txtPuerto.getText() + "||" + txtUsuario.getText() + "||" + ((String.valueOf((txtContrasenia.getPassword())).isEmpty())? "" : String.valueOf((txtContrasenia.getPassword())));
        
        try {
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            
            if(!ConexionBD.getConexion().isClosed())
            {
                this.dispose();
                JOptionPane.showMessageDialog(this, "Listo", "Conexion correcta", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FrmAgregarServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmAgregarServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_agregarConexiónActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarConexión;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBD;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtPuerto;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
