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
import prjsistemaventas.dao.DetalleVentas;
import prjsistemaventas.dao.Venta;
import prjsistemaventas.interfaces.ICRUD;

/**
 *
 * @author Frensth
 */
public class VentasCRUDImp implements ICRUD {
    Venta venta;
    DetalleVentas detalleVentas;
    Connection bd = ConexionBD.getConexion();
    
    public VentasCRUDImp()    
    {
        
    }

    public VentasCRUDImp(Venta venta) {
        this.venta = venta;
    }

    public Venta getVenta() {
        return venta;
    }

    public DetalleVentas getDetalleVentas() {
        return detalleVentas;
    }

    public void setDetalleVentas(DetalleVentas detalleVentas) {
        this.detalleVentas = detalleVentas;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    
   

    public int getCodigo()
    {
        String sql = "SELECT `AUTO_INCREMENT` " +
            "FROM  INFORMATION_SCHEMA.TABLES " +
            "WHERE TABLE_SCHEMA = 'sipbv' " +
            "AND   TABLE_NAME   = 'ventas' ";
        int codigo = -1;
         
        try 
        {
            PreparedStatement ps = bd.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                codigo = rs.getInt(1);
            }
            
            return codigo;
                    
        } catch (SQLException ex) {
            Logger.getLogger(VentasCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return codigo;
        }
        
        
    }
    public Boolean insertarDetalleVentas() {
        
        String sql = "insert into detalle_ventas values(?,?,?,?,?)";
      
        try 
        {   
            
            PreparedStatement ps= bd.prepareStatement(sql);
                  
            ps.setString(1, "0");
            ps.setInt(2, detalleVentas.getCodigoVenta());
            ps.setInt(3, detalleVentas.getCodigoProducto());
            ps.setInt(4, detalleVentas.getCantidad());
            ps.setDouble(5, detalleVentas.getPrecioVenta());
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
     @Override
    public Boolean insertar() {
        
        String sql1 = "insert into ventas values(?,?,?,?,current_timestamp(),?,?)";
      
        try 
        {   
            
            
            PreparedStatement ps= bd.prepareStatement(sql1);
           
            
            ps.setString(1, "0");
            ps.setString(2, venta.getNumeroSerie());
            ps.setInt(3, venta.getCodigoCliente());
            ps.setInt(4, venta.getCodigoEmpleado());
            
            ps.setDouble(5, venta.getMonto());
            ps.setString(6, venta.getEstado());
            
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Boolean eliminar() {
        String sql = "delete from ventas WHERE codigo = " + venta.getCodigo() ;
      
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
            ArrayList<Venta> datos = new ArrayList();
            String sql = "SELECT * FROM ventas where codigo = " + codigo;
            PreparedStatement ps = bd.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                Venta v = new Venta();

                
                v.setCodigo(rs.getInt(1));
                v.setNumeroSerie(rs.getString(2));
                v.setCodigoCliente(rs.getInt(3));
                v.setCodigoEmpleado(rs.getInt(4));
                v.setFechaVenta(rs.getString(5));
                v.setMonto(rs.getDouble(6));
                v.setEstado(rs.getString(7));


                datos.add(v);
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
            ArrayList<Venta> datos = new ArrayList();
            String sql = "SELECT * FROM ventas";
            PreparedStatement ps = bd.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                Venta v = new Venta();

                
                v.setCodigo(rs.getInt(1));
                v.setNumeroSerie(rs.getString(2));
                v.setCodigoCliente(rs.getInt(3));
                v.setCodigoEmpleado(rs.getInt(4));
                v.setFechaVenta(rs.getString(5));
                v.setMonto(rs.getDouble(6));
                v.setEstado(rs.getString(7));


                datos.add(v);
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
        String sql = "UPDATE ventas SET numeroserie = ?, codigocliente = ?, codigoempleado = ?, fechaventa = ?, monto = ?, estado = ? WHERE codigo = " + venta.getCodigo();
      
        try 
        {
            PreparedStatement ps= bd.prepareStatement(sql);
            ps.setString(1, venta.getNumeroSerie());
            ps.setInt(2, venta.getCodigoCliente());
            ps.setInt(3, venta.getCodigoEmpleado());
            ps.setString(4, venta.getFechaVenta());
            ps.setDouble(5, venta.getMonto());
            ps.setString(6, venta.getEstado());
            
            
            ps.executeUpdate(); 
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    
}
