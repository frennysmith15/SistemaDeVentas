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
import prjsistemaventas.dao.Usuario;
import prjsistemaventas.interfaces.ICRUD;

/**
 *
 * @author Frensth
 */
public class UsuariosCRUDImp implements ICRUD{
    
    private Usuario usuario;
    private Connection bd;
    
    public UsuariosCRUDImp(){
        this.bd = ConexionBD.getConexion();
        
    }
    
    public UsuariosCRUDImp(Usuario usuario){
        this.bd = ConexionBD.getConexion();
        this.usuario = usuario;
        
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    @Override
    public Boolean insertar() {
      String sql = "insert into usuarios values(?,?,?)" ;
      
        try 
        {
            PreparedStatement ps= bd.prepareStatement(sql);
            ps.setString(1, "0");
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getContrasenia());
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }

    @Override
    public Boolean eliminar() {
        String sql = "delete from usuarios WHERE codigo = " + usuario.getId() ;
      
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
    public ArrayList<Usuario> mostrarTodos() {     
        
    try 
    {
        ArrayList<Usuario> datos = new ArrayList();
        String sql = "SELECT * FROM usuarios";
        PreparedStatement ps = bd.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Usuario u = new Usuario();
                
                u.setId(rs.getInt("codigo"));
                u.setUsuario(rs.getString("usuario"));
                u.setContrasenia(rs.getString("contrasenia"));
                
                
                datos.add(u);
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
        String sql = "update usuarios SET usuario = ?, contrasenia = ? WHERE codigo = " + usuario.getId() ;
      
        try 
        {
            PreparedStatement ps= bd.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasenia());
            
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
            ArrayList<Usuario> datos = new ArrayList();
            
            String sql = "SELECT * FROM usuarios WHERE codigo=" + codigo;
            PreparedStatement ps = bd.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Usuario u = new Usuario();
            
            while(rs.next())
            {
                u.setId(rs.getInt("codigo"));
                u.setUsuario(rs.getString("usuario"));
                u.setContrasenia(rs.getString("contrasenia"));

                datos.add(u);
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
    
}
