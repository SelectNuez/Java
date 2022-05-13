package Cuenta;

import java.io.Serializable;

public class Persona implements Serializable{
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

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

}
