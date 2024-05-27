package com.example.frutas;
public class Fruta {
    private String nombre;
    private double precio;
    private String descripcion;
    private boolean seleccionada;

    public Fruta(String nombre, double precio, String descripcion, boolean seleccionada) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.seleccionada = seleccionada;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;
    }
}
