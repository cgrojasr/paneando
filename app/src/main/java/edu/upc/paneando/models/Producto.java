package edu.upc.paneando.models;

public class Producto {
    private Integer id_producto;
    private String nombre;
    private Double valor_venta;
    private  Integer image;

    public Producto() {
    }

    public Producto(String nombre, Double valor_venta, Integer image) {
        this.nombre = nombre;
        this.valor_venta = valor_venta;
        this.image = image;
    }

    public Producto(Integer id_producto, String nombre, Double valor_venta, Integer image) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.valor_venta = valor_venta;
        this.image = image;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(Double valor_venta) {
        this.valor_venta = valor_venta;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
