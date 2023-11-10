/*
 * Frenny Smith De La Cruz All Rights Reserved <Propiedad Intelectual> *Solo personal autorizado*.
 * Matricula -> 100510483
 * UNIVERSIDAD AUTONOMA DE SANTO DOMINGO RECINTO UASD SAN FRANCISCO DE MACORIS (CURNE).
 */
package prjsistemaventas.Implementaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import prjsistemaventas.ConexionBD;
import prjsistemaventas.dao.Cliente;
import prjsistemaventas.interfaces.ICRUD;

/**
 *
 * @author Frensth
 */
public class ClientesCRUDImp implements ICRUD {
    Cliente cliente;
    Connection bd = ConexionBD.getConexion();
    
    public ClientesCRUDImp()    
    {
        
    }
    
    public ClientesCRUDImp(Cliente c)    
    {
        this.cliente = c;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
     @Override
    public Boolean insertar() {
        String sql = "insert into cliente values(?,?,?,?)";
      
        try 
        {
            PreparedStatement ps= bd.prepareStatement(sql);
            
            ps.setInt(1, 0);
            ps.setString(2, cliente.getCedula());
            ps.setString(3, cliente.getNombres());
            ps.setString(4, cliente.getDireccion());
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Boolean eliminar() {
        String sql = "delete from cliente WHERE codigo = " + cliente.getCodigo() ;
      
        try 
        {
            PreparedStatement ps= bd.prepareStatement(sql);
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }

    @Override
    public ArrayList mostrar(int codigo) {
        
        try 
        {
            ArrayList<Cliente> datos = new ArrayList();
            String sql = "SELECT * FROM cliente where codigo = " + codigo;
            PreparedStatement ps = bd.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

                while(rs.next())
                {
                    Cliente c = new Cliente();

                    c.setCodigo(rs.getInt("codigo"));
                    c.setCedula(rs.getString("cedula"));
                    c.setNombres(rs.getString("nombres"));
                    c.setDireccion(rs.getString("direccion"));
                    
                    
                    datos.add(c);
                }

            ps.close();
            rs.close();
            ps = null;
            rs = null;

            return datos;
            
            } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(new JFrame(),"Error en la base de datos" + ex.getMessage(), "Error en la base de datos",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList mostrarTodos() {
        
        try 
        {
            ArrayList<Cliente> datos = new ArrayList();
            String sql = "SELECT * FROM cliente";
            PreparedStatement ps = bd.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

                while(rs.next())
                {
                    Cliente c = new Cliente();

                    c.setCodigo(rs.getInt("codigo"));
                    c.setCedula(rs.getString("cedula"));
                    c.setNombres(rs.getString("nombres"));
                    c.setDireccion(rs.getString("direccion"));
                    
                    
                    datos.add(c);
                }

            ps.close();
            rs.close();
            ps = null;
            rs = null;

            return datos;
            
            } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(new JFrame(),"Error en la base de datos" + ex.getMessage(), "Error en la base de datos",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Boolean actualizar() {
        String sql = "UPDATE cliente SET cedula = ?, nombres = ?, direccion = ? WHERE codigo = " + cliente.getCodigo() ;
      
        try 
        {
            PreparedStatement ps= bd.prepareStatement(sql);
            ps.setString(1, cliente.getCedula());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getDireccion());
            
            
            
            ps.executeUpdate(); 
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    
}
