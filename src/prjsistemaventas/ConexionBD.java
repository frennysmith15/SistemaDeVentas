/*
 * Frenny Smith De La Cruz All Rights Reserved <Propiedad Intelectual> *Solo personal autorizado*.
 * Matricula -> 100510483
 * UNIVERSIDAD AUTONOMA DE SANTO DOMINGO RECINTO UASD SAN FRANCISCO DE MACORIS (CURNE).
 */

package prjsistemaventas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConexionBD {
    
    public static Connection conexionBD;
    public static ConexionBD instancia;
    
    
    //jdbc:mariadb://localhost:3306/SIPBV
    private final String bd = "SIPBV";
    //private String bd = "sitio_web";
    private final String url = "jdbc:mariadb://localhost:3306/" + bd;
    private final String user = "java";
    private final String pass = "";
    //jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword
    
    private ConexionBD(){
        
    }
    
                 
    
    private synchronized static void createInstancia() {
        if (instancia == null) { 
            instancia = new ConexionBD();
            conexionBD = instancia.conectar();
        }
    }
    
     public static Connection getConexion(){
         if (instancia == null) 
         { 
            createInstancia();
            return conexionBD;
         }
         return conexionBD;
     }
     
    
    
    public Connection conectar(){
        /**
         * intenta conectar la base de datos
         */
        Connection conexion;
        
        try 
        {   
            System.out.println("conexion exitosa");
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(url,user,pass);
            return conexion;
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Error en la conexion, " + ex.getMessage());
            System.exit(0);
            return null;
        }
    }
    
    public void desconectar(){
        /**
         * desconecta la base de datos
         */
        try 
        {
            conexionBD.close();
        } catch (SQLException ex) 
        {
            JFrame jFrame = new JFrame();
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(jFrame, "No pudo cerrar la conexion" + ex.getMessage());
        }
    }
    
    
    
    
}
