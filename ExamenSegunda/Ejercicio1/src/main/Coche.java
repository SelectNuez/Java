/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Objects;

/**
 *
 * @author Blitz
 */
class Coche {
    private String matricula;
    private String fecha;
    private boolean pagado;

    public Coche(String matricula, String fecha, boolean pagado) {
        this.matricula = matricula;
        this.fecha = fecha;
        this.pagado = pagado;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.matricula);
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
        final Coche other = (Coche) obj;
        return Objects.equals(this.matricula, other.matricula);
    }
    
    
}
