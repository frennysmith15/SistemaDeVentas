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
public class Venta {
    private int codigo;
    private String numeroSerie;
    private int codigoCliente;
    private int codigoEmpleado;
    private String fechaVenta;
    private double monto;
    private String estado;

    public Venta() {
    }

    public Venta(int codigo, String numeroSerie, int codigoCliente, int codigoEmpleado, String fechaventa, double monto, String estado) {
        this.codigo = codigo;
        this.numeroSerie = numeroSerie;
        this.codigoCliente = codigoCliente;
        this.codigoEmpleado = codigoEmpleado;
        this.fechaVenta = fechaventa;
        this.monto = monto;
        this.estado = estado;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaventa) {
        this.fechaVenta = fechaventa;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void reporte(ArrayList<Venta> v)
    {
        Map<String, Object> parameters = new HashMap<String, Object>();
        InputStream inputImagen = null;
        JRBeanCollectionDataSource datos = new JRBeanCollectionDataSource(v);
        
        try {
            inputImagen = new FileInputStream(new File("src\\Imagenes\\Cruzrojasinfondos.png"));
            parameters.put("imagen", inputImagen);
            parameters.put("CollectionBeanParament", datos);
            
            
            InputStream input = new FileInputStream(new File("src\\Reportes\\Ventas.jrxml"));
            
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
