/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parques;

/**
 *
 * @author jorma
 */
public abstract class AreasProtegidas extends Parques{
    protected double subvencion;
    protected String ONG;

    public AreasProtegidas(double subvencion, String ONG, double extension, int numeroEspecies, String nombre) {
        super(extension, numeroEspecies, nombre);
        this.subvencion = subvencion;
        this.ONG = ONG;
    }
    
}
