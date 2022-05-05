/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parques;

/**
 *
 * @author jorma
 */
public class Terrestres extends AreasProtegidas {

    protected String tipoDeTerreno;

    public Terrestres(String tipoDeTerreno, double subvencion, String ONG, double extension, int numeroEspecies, String nombre) {
        super(subvencion, ONG, extension, numeroEspecies, nombre);
        this.tipoDeTerreno = tipoDeTerreno;
    }

    @Override
    public String visitar() {
        return "Son Visitables";
    }
}
