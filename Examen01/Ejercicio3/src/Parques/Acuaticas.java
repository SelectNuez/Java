/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parques;

/**
 *
 * @author jorma
 */
public class Acuaticas extends AreasProtegidas{
    protected int numeroLagos;

    public Acuaticas(int numeroLagos, double subvencion, String ONG, double extension, int numeroEspecies, String nombre) {
        super(subvencion, ONG, extension, numeroEspecies, nombre);
        this.numeroLagos = numeroLagos;
    }
        @Override
    public String visitar() {
      return "Son Visitables";  
    }
}
