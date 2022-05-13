package Concesionario;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Vehiculo {

    private String matricula;
    private String marca;
    private double nKm;
    private LocalDate fechaMatriculacion;
    private String nombrePropietario;
    private String dni;
    private String descripcion;
    private double precio;

    //Generamos el constructor de la clase Vehiculo con todos los atributos necesarios
    public Vehiculo(String matricula, String marca, double nKm, LocalDate fechaMatriculacion, String nombrePropietario, String dni, String descripcion, double precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.nKm = nKm;
        this.fechaMatriculacion = fechaMatriculacion;
        this.nombrePropietario = nombrePropietario;
        this.dni = dni;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    //Hacer las modificaciones a la clase Vehiculo para que sean objetos comparables por matrícula.
    /*@Override
    
    public boolean equals(Object obj) {

        if (obj instanceof Vehiculo) {
            Vehiculo otro = (Vehiculo) obj;

            return this.matricula.equals(otro.matricula);
        } else {
            return false;
        }
    }
*/

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.matricula, other.matricula);
    }
    
    
    
    public String getMarca() {
        return marca;
    }

    //Getter que devuelve el valor de matricula
    public String getMatricula() {
        return matricula;
    }
    //Getter  que devuelve el valor de los KM

    public double getnKm() {
        return nKm;
    }

    //Setter que establece los KM para cuando se actualicen
    public void setnKm(double nKm) {

        this.nKm = nKm;
    }

    public int get_Anios() { //Retorna un entero con el número de años del vehículo.
        LocalDate hoy = LocalDate.now();
        return (Period.between(this.fechaMatriculacion, hoy).getYears());
    }

    //Getter que devuelve el valor del nombre del propietario
    public String getNombrePropietario() {
        return nombrePropietario;
    }

    //Getter que devuelve el valor del DNI del propietario
    public String getdni() {
        return dni;
    }

    //Getter que devuelve el valor de la descripcion
    public String getDescripcion() {
        return descripcion;
    }

    //Getter que devuelve el valor del precio
    public double getPrecio() {
        return precio;
    }

}
