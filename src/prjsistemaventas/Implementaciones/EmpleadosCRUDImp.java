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
import prjsistemaventas.dao.Empleado;
import prjsistemaventas.interfaces.ICRUD;

/**
 *
 * @author Frensth
 */
public class EmpleadosCRUDImp implements ICRUD{
    private Empleado empleado;
    private Connection bd;
    private int ultimaInsercion;

    public EmpleadosCRUDImp() {
        bd = ConexionBD.getConexion();
    }

    
    public EmpleadosCRUDImp(Empleado empleado) {
        this.empleado = empleado;
        bd = ConexionBD.getConexion();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Boolean fechadeInicio()
    {
        String sql = "insert into logger_usuarios(codigoempleado, iniciosesion) values(?,current_timestamp())";
        String sql2 = "select last_insert_id()";
        
        try 
        {
            PreparedStatement ps= bd.prepareStatement(sql);
            
            ps.setInt(1, empleado.getCodigo());
            
            ps.executeUpdate(); 
            
            ResultSet rs = ps.executeQuery(sql2);
            
            rs.first();
            
            ultimaInsercion = rs.getInt(1);
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Boolean fechadeSalida()
    {
        String sql = "update logger_usuarios set cerrosesion = current_timestamp() where codigo =" + ultimaInsercion;
      
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
    public Boolean insertar() {
        String sql = "insert into empleados values(?,?,?,?,?,?)";
        String sql2 = "insert into usuarios values(?,?,?)" ; ;
      
        try 
        {
            PreparedStatement ps= bd.prepareStatement(sql);
            PreparedStatement ps2= bd.prepareStatement(sql2);
            ps.setInt(1, 0);
            ps.setString(2, empleado.getCedula());
            ps.setString(3, empleado.getNombre());
            ps.setString(4, empleado.getTelefono());
            ps.setString(5, empleado.getSexo());
            ps.setString(6, empleado.getUsuario());
            
            ps2.setString(1, "0");
            ps2.setString(2, empleado.getUsuario());
            ps2.setString(3, null);
            
            
            ps.executeUpdate();
            ps2.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Boolean eliminar() {
        String sql = "delete from empleados WHERE codigo = " + empleado.getCodigo() ;
      
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
            ArrayList<Empleado> datos = new ArrayList();
            
            String sql = "SELECT * FROM empleados WHERE codigo=" + codigo;
            PreparedStatement ps = bd.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Empleado e = new Empleado();
            
            while(rs.next())
            {
                e.setCodigo(rs.getInt("codigo"));
                e.setCedula(rs.getString("cedula"));
                e.setNombre(rs.getString("nombre"));
                e.setTelefono(rs.getString("telefono"));
                e.setSexo(rs.getString("sexo"));
                e.setUsuario(rs.getString("usuario"));

                datos.add(e);
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
            ArrayList<Empleado> datos = new ArrayList();
            String sql = "SELECT * FROM empleados";
            PreparedStatement ps = bd.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

                while(rs.next())
                {
                    Empleado e = new Empleado();

                    e.setCodigo(rs.getInt("codigo"));
                    e.setCedula(rs.getString("cedula"));
                    e.setNombre(rs.getString("nombre"));
                    e.setTelefono(rs.getString("telefono"));
                    e.setSexo(rs.getString("sexo"));
                    e.setUsuario(rs.getString("usuario"));
                    
                    datos.add(e);
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
        String sql = "UPDATE empleados SET cedula = ?, nombre = ?, Telefono = ?, sexo = ?, usuario = ? WHERE codigo = " + empleado.getCodigo() ;
      
        try 
        {
            PreparedStatement ps= bd.prepareStatement(sql);
            ps.setString(1, empleado.getCedula());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getTelefono());
            ps.setString(4, empleado.getSexo());
            ps.setString(5, empleado.getUsuario());
            
            
            ps.executeUpdate(); 
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosCRUDImp.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    
    
    
}
