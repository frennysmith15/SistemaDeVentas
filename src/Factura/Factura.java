/*
 * Frenny Smith De La Cruz All Rights Reserved <Propiedad Intelectual> *Solo personal autorizado*.
 * Matricula -> 100510483
 * UNIVERSIDAD AUTONOMA DE SANTO DOMINGO RECINTO UASD SAN FRANCISCO DE MACORIS (CURNE).
 */
package Factura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class Factura{
    private String productoNombre;
    private String productoLaboratorio;
    private int productoCantidad;
    private double productoPrecio;

    public Factura() {
    }

    public Factura(String productoNombre, String productoLaboratorio, int cantidad, double precio) {
        this.productoNombre = productoNombre;
        this.productoLaboratorio = productoLaboratorio;
        this.productoCantidad = cantidad;
        this.productoPrecio = precio;
    }

    
    
    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public String getProductoLaboratorio() {
        return productoLaboratorio;
    }

    public void setProductoLaboratorio(String productoLaboratorio) {
        this.productoLaboratorio = productoLaboratorio;
    }

    public int getProductoCantidad() {
        return productoCantidad;
    }

    public void setProductoCantidad(int productoCantidad) {
        this.productoCantidad = productoCantidad;
    }

    public double getProductoPrecio() {
        return productoPrecio;
    }

    public void setProductoPrecio(double productoPrecio) {
        this.productoPrecio = productoPrecio;
    }

    public void generarFactura(double precioTotal, double impuestos, double subTotal, String empleadoNombre, int noFactura, ArrayList<Factura> f)
    {
        Map<String, Object> parameters = new HashMap<String, Object>();
        InputStream inputImagen = null;
        JRBeanCollectionDataSource datos = new JRBeanCollectionDataSource(f);
        
        try {
            inputImagen = new FileInputStream(new File("src\\Imagenes\\Cruzrojasinfondos.png"));
            parameters.put("imagen", inputImagen);
            parameters.put("CollectionBeanParament", datos);
            parameters.put("impuestos", impuestos);
            parameters.put("subtotal", subTotal);
            parameters.put("precioTotal", precioTotal);
            parameters.put("empleadoNombre", empleadoNombre);
            parameters.put("factura", noFactura);
            
            InputStream input = new FileInputStream(new File("src\\Factura\\factura.jrxml"));
            
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
