package Cuenta;

public class Persona {
    //Titular de la cuenta (un objeto de la clase Persona, la cual contendrá información sobre el titular: nombre, apellidos y DNI).
    protected String nombre;
    protected String apellidos;
    protected String DNI;
    //Constructor
    public Persona(String nombre, String apellidos, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        
    }

}
