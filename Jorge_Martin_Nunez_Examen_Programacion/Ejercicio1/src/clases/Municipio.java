/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Objects;

/**
 *
 * @author Jorge Martin
 */
public class Municipio {
        String nombreMunicipio;
        String codPostal ;
        int nHabitantes ;
        int nHogares ;

        //Constructor que inicializa los atributos con valores
    public Municipio(String nombreMunicipio, String codPostal, int nHabitantes, int nHogares) {
        this.nombreMunicipio = nombreMunicipio;
        this.codPostal = codPostal;
        this.nHabitantes = nHabitantes;
        this.nHogares = nHogares;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public int getnHabitantes() {
        return nHabitantes;
    }

    public int getnHogares() {
        return nHogares;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public void setnHabitantes(int nHabitantes) {
        this.nHabitantes = nHabitantes;
    }

    public void setnHogares(int nHogares) {
        this.nHogares = nHogares;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nombreMunicipio);
        hash = 89 * hash + Objects.hashCode(this.codPostal);
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
        final Municipio other = (Municipio) obj;
        if (!Objects.equals(this.nombreMunicipio, other.nombreMunicipio)) {
            return false;
        }
        return Objects.equals(this.codPostal, other.codPostal);
    }
        
        

}//Fin de clase
