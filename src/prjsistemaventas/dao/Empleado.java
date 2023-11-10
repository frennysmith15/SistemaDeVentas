/*
 * Frenny Smith De La Cruz All Rights Reserved <Propiedad Intelectual> *Solo personal autorizado*.
 * Matricula -> 100510483
 * UNIVERSIDAD AUTONOMA DE SANTO DOMINGO RECINTO UASD SAN FRANCISCO DE MACORIS (CURNE).
 */
package prjsistemaventas.dao;

import Factura.Factura;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Frensth
 */
public class Empleado {
    
    private int codigo;
    private String cedula;
    private String nombre;
    private String telefono;
    private String sexo;
    private String usuario;

    public Empleado() {
    }

    public Empleado(int codigo, String cedula, String nombre, String telefono,String sexo, String usuario) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.sexo = sexo;
        this.usuario = usuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public void reporte(ArrayList<Empleado> e)
    {
        Map<String, Object> parameters = new HashMap<String, Object>();
        InputStream inputImagen = null;
        JRBeanCollectionDataSource datos = new JRBeanCollectionDataSource(e);
        
        try {
            inputImagen = new FileInputStream(new File("src\\Imagenes\\Cruzrojasinfondos.png"));
            parameters.put("imagen", inputImagen);
            parameters.put("CollectionBeanParament", datos);
            
            
            InputStream input = new FileInputStream(new File("src\\Reportes\\Empleado.jrxml"));
            
             JasperDesign jasperDesign = JRXmlLoader.load(input);
        
            
            net.sf.jasperreports.engine.JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

           
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            
            JasperViewer.viewReport(jasperPrint, false);
            
            System.out.println(".:Archivo generado:.");
            
        } catch (Exception ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrio un error al momento generar la factura. " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        
        
        
        
    }
    
            
    
    
}
