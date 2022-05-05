/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parques;
/**
 *
 * @author jorma
 */
public abstract class Parques implements Interfaz.Visitable{
    protected double extension;
    protected int numeroEspecies;
    protected String nombre;
    protected String informacion;

    public Parques(double extension, int numeroEspecies, String nombre) {
        this.extension = extension;
        this.numeroEspecies = numeroEspecies;
        this.nombre = nombre;
    }
    public String devolverInformacion(int parque){
        
        return informacion;
    }

    public void setNumeroEspecies(int numeroEspecies) {
        this.numeroEspecies = numeroEspecies;
    }
    
    
}
