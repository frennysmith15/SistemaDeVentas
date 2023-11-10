/*
 * Frenny Smith De La Cruz All Rights Reserved <Propiedad Intelectual> *Solo personal autorizado*.
 * Matricula -> 100510483
 * UNIVERSIDAD AUTONOMA DE SANTO DOMINGO RECINTO UASD SAN FRANCISCO DE MACORIS (CURNE).
 */
package prjsistemaventas.dao;

/**
 *
 * @author Frensth
 */
public class DetalleVentas {
    private int codigo;
    private int codigoVenta;
    private int codigoProducto;
    private int cantidad;
    private double precioVenta;

    public DetalleVentas() {
    }

    public DetalleVentas(int codigo, int codigoVenta, int codigoProducto, int cantidad, double precioVenta) {
        this.codigo = codigo;
        this.codigoVenta = codigoVenta;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    
}
