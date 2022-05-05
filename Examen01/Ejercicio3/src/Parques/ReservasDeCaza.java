/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parques;

/**
 *
 * @author jorma
 */
public class ReservasDeCaza extends Parques {
    protected double costeLicencia;
    protected String arma;

    public ReservasDeCaza(double costeLicencia, String arma, double extension, int numeroEspecies, String nombre) {
        super(extension, numeroEspecies, nombre);
        this.costeLicencia = costeLicencia;
        this.arma = arma;
    }

    @Override
    public String visitar() {
      return "No son visitables";  
    }

    public String devolverDatos(){
     return "Reserva de caza: " + this.nombre +
             "\nEl coste de la licencia es: " + this.costeLicencia + 
             "\nSe podra usar el arma: " + this.arma +
             "\nLa extension es: " + this.extension +
             "\nHay: " + this.numeroEspecies + " especies";
    }
    
   
    
}
