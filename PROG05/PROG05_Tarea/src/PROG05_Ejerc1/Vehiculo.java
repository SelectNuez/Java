package PROG05_Ejerc1;

import java.time.LocalDate; //Importamos la libreria para saber el dia actual
import java.time.Period; //Importamos la libreria para conocer un periodo entre dos fechas
import java.time.format.DateTimeFormatter; //Importamos la libreria para tener un formato de los datos introducidos

public class Vehiculo { //Creamos las variables como private por encapsularlas
/*
    Autor: Jorge Martin
    Clase para la creacion y utilizacion de los atributos de los Vehiculos
 */
    private String matricula;
    private String marca;
    private double nKm;
    private String fechaMatriculacion;
    private int antiguedad; 
    private String nombrePropietario;
    private String dni;
    private String descripcion;
    private double precio;

    //Generamos el constructor de la clase Vehiculo con todos los atributos necesarios
    public Vehiculo(String matricula, String marca, double nKm, String fechaMatriculacion, String nombrePropietario, String dni, String descripcion, double precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.nKm = nKm;
        this.fechaMatriculacion = fechaMatriculacion;
        this.nombrePropietario = nombrePropietario;
        this.dni = dni;
        this.descripcion = descripcion;
        this.precio = precio;
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
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");   //Establecemos el formato de los datos que se introduciran
        //Creamos el objeto localFechamatriculacion con los datos del string fechaMatriculacion, con el formato de forma que el programa sepa cual es el año introducido
        LocalDate localFechamatriculacion = LocalDate.parse(fechaMatriculacion, fmt);
        
        LocalDate ahora = LocalDate.now();     //Creamos el objeto ahora con la fecha actual
        Period periodo = Period.between(localFechamatriculacion, ahora); //Creamos el periodo con el periodo comprendido entre la fecha de matriculacion y hoy.
        this.antiguedad = periodo.getYears(); //Asignamos a antiguedad el periodo comprendido entre el año de matriculacion y el año actual
        return antiguedad; //Devolvemos un entero como la antiguedad total
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
