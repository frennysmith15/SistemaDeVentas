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
import prjsistemaventas.dao.Producto;
import prjsistemaventas.interfaces.ICRUD;

/**
 *
 * @author Frensth
 */
public class ProductosCRUDImp implements ICRUD {
    Producto producto;
    Connection bd = ConexionBD.getConexion();
    
    public ProductosCRUDImp()    
    {
        
    }
    
    public ProductosCRUDImp(Producto p)    
    {
        this.producto = p;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto p) {
        this.producto = p;
    }
    
    public void actualizarStock(int codigo, int stock)
    {
        String sql = "UPDATE producto SET stock = ? where codigo=" + codigo;
        
        try {
            
            PreparedStatement ps = bd.prepareStatement(sql);
            
            ps.setInt(1, stock);
            
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
     @Override
    public Boolean insertar() {
        
        String sql = "select count(*) from producto";
        String sql1 = "insert into producto values(?,?,?,?,?,?)";
      
        try 
        {
            PreparedStatement psc= bd.prepareStatement(sql);
            
            ResultSet rs = psc.executeQuery();
            
            rs.first();
            int codigo = rs.getInt(1) + 1;
            
            PreparedStatement ps= bd.prepareStatement(sql1);
            
            ps.setInt(1, codigo);
            ps.setString(2, producto.getNombres());
            ps.setString(3, producto.getLaboratorio());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getStock());
            ps.setString(6, producto.getEstado() + "");
            
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Boolean eliminar() {
        String sql = "delete from producto WHERE codigo = " + producto.getCodigo() ;
      
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
            ArrayList<Producto> datos = new ArrayList();
            String sql = "SELECT * FROM producto where codigo = " + codigo;
            PreparedStatement ps = bd.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                Producto p = new Producto();

                p.setCodigo(rs.getInt("codigo"));
                p.setNombres(rs.getString("nombres"));
                p.setLaboratorio(rs.getString("laboratorio"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setEstado(rs.getString("estado").charAt(0));


                datos.add(p);
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
            ArrayList<Producto> datos = new ArrayList();
            String sql = "SELECT * FROM producto";
            PreparedStatement ps = bd.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

                while(rs.next())
                {
                    Producto p = new Producto();

                    p.setCodigo(rs.getInt("codigo"));
                    p.setNombres(rs.getString("nombres"));
                    p.setLaboratorio(rs.getString("laboratorio"));
                    p.setPrecio(rs.getDouble("precio"));
                    p.setStock(rs.getInt("stock"));
                    p.setEstado(rs.getString("estado").charAt(0));
                    
                    
                    datos.add(p);
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
        String sql = "UPDATE producto SET nombres = ?, laboratorio = ?, precio = ?, stock = ?, estado = ? WHERE codigo = " + producto.getCodigo() ;
      
        try 
        {
            PreparedStatement ps= bd.prepareStatement(sql);
            ps.setString(1, producto.getNombres());
            ps.setString(2, producto.getLaboratorio());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getEstado()+"");
            
            
            ps.executeUpdate(); 
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    
}
