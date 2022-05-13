package Principal;

import Concesionario.Concesionario;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class principal {

    public static void main(String args[]) {
        int menu = 0; //Establecemos el menu como 0
        String matricula, marca, fechaMatriculacion, nombrePropietario, nombre, ape1, ape2, dni, descripcion; //Inicializamos las variables
        Double nKm, precio;
        Concesionario concesionario = new Concesionario();
        do { // Con un bucle hacemos que el menu se ejecute siempre mientras la opcion de salida no sea dada

            menu = Integer.parseInt(JOptionPane.showInputDialog(
                    "1.Nuevo Vehículo.\n"
                    + "2.Listar Vehiculos.\n"
                    + "3.Buscar Vehiculo.\n"
                    + "4.Modificar kms Vehículo.\n"
                    + "5.Eliminar Vehículo.\n"
                    + "6.Salir."));

            switch (menu) { //Creo el menu
                case 1:
                    do {
                        matricula = JOptionPane.showInputDialog("Introduzca la matricula del nuevo vehiculo: "); //Solicito la matricula
                        if (concesionario.compruebaMatricula(matricula) == true) { //Si la matricula es true, eso es que ya existe por lo que aviso del error y vuelvo a solicitarla
                            JOptionPane.showMessageDialog(null, "La matricula introducida ya existe");
                        }
                    } while (concesionario.compruebaMatricula(matricula) == true);

                    while (false == matricula.matches("^[0-9]{4}[A-Z]{3}$")) {  //Mientras que la matricula no tenga el formato correcto la vuelvo a solicitar, el formato se comptueba siendo del 0 al 9 4 veces y 1 vez de la A a la Z
                        matricula = JOptionPane.showInputDialog("Matricula erronea (Formato NNNNLLL)"
                                + "\nIntroduzca la matricula del nuevo vehiculo: ");
                    }
                    marca = JOptionPane.showInputDialog("Introduzca la marca del nuevo vehiculo: ");
                    nKm = Double.parseDouble(JOptionPane.showInputDialog("Introduzca los KM del nuevo vehiculo: "));
                    fechaMatriculacion = JOptionPane.showInputDialog("Introduzca la fecha de matriculacion del nuevo vehiculo (yyyy/MM/dd): ");
                    do { //Solicito el nombre y apellidos
                        nombre = JOptionPane.showInputDialog("Introduzca el nombre del propietario del nuevo vehiculo: ");
                        ape1 = JOptionPane.showInputDialog("Introduzca el primer apellido del propietario del nuevo vehiculo: ");
                        ape2 = JOptionPane.showInputDialog("Introduzca el segundo apellido del propietario del nuevo vehiculo: ");
                        nombrePropietario = nombre + " " + ape1 + " " + ape2; // uno todo en un mismo String
                        //Si el nombre es mayor de 40 caracteres, el nombre o los apellidos estan vacios se vuelve a solicitar
                        if (nombrePropietario.length() > 40 || nombre == null || ape1 == null || ape2 == null) {
                            JOptionPane.showMessageDialog(null, "El nombre introducido no es valido"
                                    + "\nAsegurese de que ha introducido el nombre y los dos apellidos"
                                    + "\nAsi como que el nombre completo no supera los 40 caracteres");
                        }
                    } while (nombrePropietario.length() > 40 || nombre == null || ape1 == null || ape2 == null);

                    dni = JOptionPane.showInputDialog("Introduzca el DNI del propietario del nuevo vehiculo: ");
                    // Compruebo que el DNI tenga 7 u 8 caracteres entre 0-9 y una letra de las validas, en caso negativo se solicita de nuevo
                    while (false == dni.matches("^[0-9]{7,8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$")) {
                        dni = JOptionPane.showInputDialog("DNI incorrecto, por favor introduzca el DNI del propietario del nuevo vehiculo: ");
                    }
                    descripcion = JOptionPane.showInputDialog("Introduzca una descripcion del nuevo vehiculo: ");
                    precio = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el precio del nuevo vehiculo: "));
                    concesionario.insertarVehiculo(matricula, marca, nKm, LocalDate.MIN, nombrePropietario, dni, descripcion, precio); //Llamo al metodo insertar vehiculo y le paso los argumentos necesarios
                    break;
                case 2:
                    concesionario.listaVehiculos(); //Llamo al metodo para que muestre la lista de vehiculos
                    break;
                case 3:
                    matricula = JOptionPane.showInputDialog("Introduzca la matricula del vehiculo a mostrar: ");
                    if (concesionario.buscaVehiculo(matricula) == null) { // Si el metodo llamado devuelve un null, quiere decir que no existe esa matricula
                        JOptionPane.showMessageDialog(null, "No existe vehículo con la matrícula introducida");
                    } else {
                        JOptionPane.showMessageDialog(null, concesionario.buscaVehiculo(matricula)); //En caso de que exista, devuelve un String con los datos
                    }
                    break;
                case 4:
                    matricula = JOptionPane.showInputDialog("Introduzca la matricula del vehiculo a actualizar: ");
                    nKm = Double.parseDouble(JOptionPane.showInputDialog("Introduzca los Km a actualizar "));
                    if (concesionario.actualizaKms(matricula, nKm) == true) { //Si el metodo devuelve true es que se ha actualizado con exito
                        JOptionPane.showMessageDialog(null, "Los Km han sido actualizados correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe el vehiculo con la matricula introducida");
                    }
                    break;
                case 5:
                    matricula = JOptionPane.showInputDialog("Introduzca la matricula del vehiculo a eliminar: ");
                    if (concesionario.eliminaVehiculo(matricula) == true) { //Si el metodo devuelve true es que se ha actualizado con exito
                        JOptionPane.showMessageDialog(null, "El vehiculo ha sido eliminado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe el vehiculo con la matricula introducida");
                    }
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar esta aplicacion, esperamos verte pronto"); //Muestro un mensaje de despedida
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opcion introducida no es valida"); //En caso de que se introduzca una opcion que no sean del 1 al 5

            }

        } while (menu != 6); //Mientras no se introduzca un 5 se vuelve a realizar el programa
    }
}
