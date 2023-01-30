package edu.upc.paneando.models;

public class CarritoItem {
    private Integer id_item;
    private Integer id_producto;
    private String nombre;
    private Double valor_unitario;
    private Integer cantidad;
    private Double valor_total;

    public CarritoItem(Integer id_item, Integer id_producto, String nombre, Double valor_unitario, Integer cantidad, Double valor_total) {
        this.id_item = id_item;
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.valor_unitario = valor_unitario;
        this.cantidad = cantidad;
        this.valor_total = valor_total;
    }

    public Integer getId_item() {
        return id_item;
    }

    public void setId_item(Integer id_item) {
        this.id_item = id_item;
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

    public Double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(Double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }
}
