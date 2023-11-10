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
public class Producto {
    private int codigo;
    private String nombres;
    private String laboratorio;
    private double precio;
    private int stock;
    private char estado;

    public Producto() {
    }

    public Producto(int codigo, String nombres,String lab ,double precio, int stock, char estado) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.laboratorio = lab;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    public void reporte(ArrayList<Producto> p)
    {
        Map<String, Object> parameters = new HashMap<String, Object>();
        InputStream inputImagen = null;
        JRBeanCollectionDataSource datos = new JRBeanCollectionDataSource(p);
        
        try {
            inputImagen = new FileInputStream(new File("src\\Imagenes\\Cruzrojasinfondos.png"));
            parameters.put("imagen", inputImagen);
            parameters.put("CollectionBeanParament", datos);
            
            
            InputStream input = new FileInputStream(new File("src\\Reportes\\Productos.jrxml"));
            
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
