/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Objects;

/**
 *
 * @author jorma
 */
public class ingrediente {
    private String nombre;
    private int n_personas;
    private double cantidad;
    private double precio_kg;

    public ingrediente(String nombre, int n_personas, double cantidad, double precio_kg) {
        this.nombre = nombre;
        this.n_personas = n_personas;
        this.cantidad = cantidad;
        this.precio_kg = precio_kg;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setN_personas(int n_personas) {
        this.n_personas = n_personas;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio_kg(double precio_kg) {
        this.precio_kg = precio_kg;
    }

    public String getNombre() {
        return nombre;
    }

    public int getN_personas() {
        return n_personas;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getPrecio_kg() {
        return precio_kg;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ingrediente other = (ingrediente) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
    
    
    
}
