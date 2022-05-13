/*
Modificar la clase Concesionario para que utilice una estructura de datos dinámica que mantenga los vehículos ordenados. 
Determina qué estructura es la más apropiada, justificando tu respuesta (Puedes hacerlo en la misma declaración de la propiedad).
 */
package Concesionario;

import java.time.LocalDate;
import java.util.*;
import javax.swing.JOptionPane;

public class Concesionario {
//Creo una estructura con LinkedList ya que queremos que este organizada y ademas es bastante mas eficiente a la hora de trabajar borrando objetos que un ArrayList.
    private LinkedList<Vehiculo> vehiculos;

    public Concesionario() { //Constructor, en el inizializo la LinkedList en el que se guardaran distintos vehiculos
        vehiculos = new LinkedList<Vehiculo>();
    }
//Solicito los datos necesarios para crear un vehiculo

    public int insertarVehiculo(String matricula, String marca, double nKm, LocalDate fechaMatriculacion, String nombrePropietario, String dni, String descripcion, double precio) {
        //Si los hay mas vehiculos que 50 devuelvo -1
        //if (this.buscaVehiculo(matricula) != null) {
            if (vehiculos.equals(matricula)) {
            return -2;
            //En cualquier otro caso genero el vehiculo y sumo 1 al contador del vehiculo para que al generar el siguiente vehiculo sea en el siguiente del array
        } else {
            Vehiculo veh = new Vehiculo(matricula, marca, nKm, fechaMatriculacion, nombrePropietario, dni, descripcion, precio);
            vehiculos.add(veh);
        }
        return 0;
    }
    
    
    public void listaVehiculos() {
        for (Vehiculo vehiculo : vehiculos) { //para cada vehiculo 
            JOptionPane.showMessageDialog(null, "Mostrando datos del coche " //Devuelve los datos solicitados
                    + "\nLa marca es: " + vehiculo.getMarca()
                    + "\nLa matricula es: " + vehiculo.getMatricula()
                    + "\nEl precio es: " + vehiculo.getPrecio()
                    + "\nTiene: " + vehiculo.getnKm() + " Km"
                    + "\nDescripcion: " + vehiculo.getDescripcion());
        }

    }

    public boolean compruebaMatricula(String Matricula) {
        for (Vehiculo vehiculo : vehiculos) { //Comprueba que la matricula introducida esta o no en los coches creados
            if (vehiculo.getMatricula().equals(Matricula)) {
                return true;//Si esta creado devuelvo true
            }
        }
        return false; //Si no, false
    }

    public String buscaVehiculo(String Matricula) {

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(Matricula)) { //Si la matricula existe
                return "Mostrando datos del coche " // Devuelve la Marca y la Matricula
                        + "\nLa marca es: " + vehiculo.getMarca()
                        + "\nLa matricula es: " + vehiculo.getMatricula();
            }
        }
        return null; //Si no existe, null
    }

    public boolean actualizaKms(String Matricula, double nKm) { //Si la matricula existe, actualiza los KM y devuelve true
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(Matricula)) {
                vehiculo.setnKm(nKm);
                return true;
            }
        }
        return false; //Si no,false
    }
/*
Añadir la opción Eliminar Vehículo: Dada una matrícula, eliminar el vehículo cuya matrícula coincide si existe.
 */
    public boolean eliminaVehiculo(String Matricula) {
        boolean eliminar = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(Matricula)) {
                vehiculos.remove(vehiculo);
                eliminar = true;
                break;
            }
        }
        return eliminar;
    }

}

