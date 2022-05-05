package PROG05_Ejerc1;

import PROG05_Ejerc1_util.Validaciones;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Principal {

    /*
    Autor: Jorge Martin
    Clase en la que se realizaran las solicitudes de datos y enviara y recbira los
    datos gracias a los Getters y Setters, asi como de realizar las comprobaciones.
     */
    public static void main(String args[]) throws ParseException {
        int i = 0, menu, check = 0; //Creamos las variables
        String matricula, marca, nombrePropietario, dni, descripcion, fechaMatriculacion;
        double nKm = 0, nKmActu = 0, precio; //Inicializamos algunas en 0 para evitar posibles problemas
        boolean dniCorrecto = false;
        Date fechaactual = new Date(System.currentTimeMillis());
        Vehiculo vehiculo1 = null;  //Creamos el objeto vehiculo1 como null, de esta matera si no se genera el objeto con datos validos podemos volver a solicitarlo
        do {    //Generamos la estructura del programa, muestra el menu mientras la entrada no sea un 9
            menu = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                1.-Nuevo Veh\u00edculo.
                                                                2.-Ver Matr\u00edcula.
                                                                3.-Ver N\u00famero de Kil\u00f3metros.
                                                                4.-Actualizar Kil\u00f3metros.
                                                                5.-Ver a\u00f1os de antig\u00fcedad.
                                                                6.-Mostrar propietario.
                                                                7.-Mostrar descripci\u00f3n.
                                                                8.-Mostrar Precio.
                                                                9.-Salir."""));
            if (menu != 1 && vehiculo1 == null && menu != 9) {
                JOptionPane.showMessageDialog(null, "No se ha creado ningun vehiculo,por favor,cree uno y vuelva a intentarlo");
            } else {
                switch (menu) { //Generamos un menu en el que segun la opcion dada en la entrada se genere una respuesta valida
                    case 1: //Pedimos todos los datos necesarios para construir el objeto
                        matricula = JOptionPane.showInputDialog("Introduzca la matricula del nuevo vehiculo: ");
                        marca = JOptionPane.showInputDialog("Introduzca la marca del nuevo vehiculo: ");
                        nKm = Double.parseDouble(JOptionPane.showInputDialog("Introduzca los KM del nuevo vehiculo: "));
                        //Comprobamos que el numero de KM sea superior a 0
                        while (nKm <= 0) { //Si es menor se vuelve a solicitar hasta que se de una respuesta valida
                            nKm = Double.parseDouble(JOptionPane.showInputDialog("Los KM deberan ser superiores a 0\nIntroduzca los KM del nuevo vehiculo: "));
                        }
                        //Comprobamos que la fecha de matriculacion sea anterior a la actual
                        fechaMatriculacion = JOptionPane.showInputDialog("Introduzca la fecha de matriculacion del nuevo vehiculo (dd/MM/yyyy): ");
                        do { //Establecemos una fecha con un fomato dd/MM/yyyy
                            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                            Date formatFecha = date.parse(fechaMatriculacion);
                            //Si la fecha es posterior a la actual volvemos a solicitarla
                            if (formatFecha.after(fechaactual)) {
                                fechaMatriculacion = JOptionPane.showInputDialog("La fecha de matriculacion debe de ser anterior a la actual\nIntroduzca la fecha de matriculacion del nuevo vehiculo (dd/MM/yyyy): ");
                            } else { //Si es anterior, cambiamos el digito de control a 1 para salir del bucle con la fecha correcta
                                check = 1;
                            }
                        } while (check == 0);

                        nombrePropietario = JOptionPane.showInputDialog("Introduzca el nombre del propietario del nuevo vehiculo: ");
                        dni = JOptionPane.showInputDialog("Introduzca el DNI del propietario del nuevo vehiculo: ");
                        while (dniCorrecto == false) {
                            dni = JOptionPane.showInputDialog("El DNI es erroneo\nIntroduzca el DNI del propietario del nuevo vehiculo: ");
                            dniCorrecto = Validaciones.validar(dni);

                        }
                        descripcion = JOptionPane.showInputDialog("Introduzca una descripcion del nuevo vehiculo: ");
                        precio = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el precio del nuevo vehiculo: "));
                        //Generamos el objeto con los datos recibidos
                        vehiculo1 = new Vehiculo(matricula, marca, nKm, fechaMatriculacion, nombrePropietario, dni, descripcion, precio);
                        break;
                    case 2: //Ver Matrícula: Mostrará la matrícula del vehículo por pantalla.
                        JOptionPane.showMessageDialog(null, "La Matricula del vehiculo es: " + vehiculo1.getMatricula());
                        break;
                    case 3: //Ver Número de Kilómetros: Mostrará el número de kilómetros por pantalla.
                        JOptionPane.showMessageDialog(null, "El numero de KM del vehiculo es: " + vehiculo1.getnKm());
                        break;
                    case 4: //Actualiza Kilómetros: Permitirá actualizar el número de kilómetros del vehículo. Habrá que tener en cuenta que solo se podrán sumar kilómetros.
                        nKmActu = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el nuevo numero de KM"));
                        while (nKmActu <= nKm) {
                            //Si los nuevos KM son iguales o inferiores a los actuales mostramos un mensaje de error y lo volvemos a solicitar
                            nKmActu = Integer.parseInt(JOptionPane.showInputDialog("Por favor, introduce una cantidad de KM superior a la que esta actualmente registrada: (Registrada: " + vehiculo1.getnKm() + ")"));
                        }
                        vehiculo1.setnKm(nKmActu);
                        break;
                    case 5://Ver años de antigüedad: Mostrará por pantalla el número de años del vehículo desde que se matriculó, no la fecha de matriculación.
                        JOptionPane.showMessageDialog(null, "La antiguedad del vehiculo es: " + vehiculo1.get_Anios() + " años");
                        break;
                    case 6://Mostrar propietario: Mostrará por pantalla el nombre del propietario del vehículo junto a su dni.
                        JOptionPane.showMessageDialog(null, "El propietario del vehiculo es: " + vehiculo1.getNombrePropietario()
                                + "\nCon el DNI: " + vehiculo1.getdni());
                        break;
                    case 7://Mostrar Descripción: Mostrará una descripción del vehículo, incluyendo su matrícula y el número de kilómetros que tiene.
                        JOptionPane.showMessageDialog(null, "Descripcion:" + vehiculo1.getDescripcion()
                                + "\nMatricula: " + vehiculo1.getMatricula()
                                + "\nNº KM: " + vehiculo1.getnKm());
                        break;
                    case 8://Mostrar Precio: se mostrará el precio del vehículo.
                        JOptionPane.showMessageDialog(null, "El precio del vehiculo es: " + vehiculo1.getPrecio());
                        break;
                    case 9: //Introducimos un mensaje de despedida
                        JOptionPane.showMessageDialog(null, "Hasta la proxima!");
                        break;
                    default: //Cualquier opcion que no sean las dadas en los case devuelven un mensaje de error
                        JOptionPane.showMessageDialog(null, "Introduzca un numero valido del menu");
                }
            }
        } while (menu != 9);

    }

}
