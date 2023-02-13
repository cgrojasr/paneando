package edu.upc.paneando.models;

public class Producto {
    private Integer idProducto;
    private String nombre;
    private Double valorVenta;
    //private  Integer image = null;

    public Producto() {
    }

    public Producto(String nombre, Double valor_venta, Integer image) {
        this.nombre = nombre;
        this.valorVenta = valor_venta;
        //this.image = image;
    }

    public Producto(Integer id_producto, String nombre, Double valor_venta, Integer image) {
        this.idProducto = id_producto;
        this.nombre = nombre;
        this.valorVenta = valor_venta;
        //this.image = image;
    }

    public Integer getId_producto() {
        return idProducto;
    }

    public void setId_producto(Integer id_producto) {
        this.idProducto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor_venta() {
        return valorVenta;
    }

    public void setValor_venta(Double valor_venta) {
        this.valorVenta = valor_venta;
    }

//    public Integer getImage() {
//        return image;
//    }
//
//    public void setImage(Integer image) {
//        this.image = image;
//    }
}
