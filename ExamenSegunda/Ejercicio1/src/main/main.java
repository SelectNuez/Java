package main;

/*
Se pretende realizar una aplicación en Java que simule un parking, en el cual  se pueden estacionar vehículos por un tiempo limitado. 
De todos los vehículos hay que guardar su matrícula, la fecha/hora de entrada en el aparcamiento y si se trata de un vehículo con abono.
En el parking pueden estacionar 2 tipos de vehículos: vehículos de particulares y vehículos de residentes a los cuales no se les cobrará nada.

Menú:
1.- Entra un coche. Se le inserta en la lista solo si es particular, para ello se deberá mirar si dicha matricula NO está dentro del array de residentes.
2.- Sale un coche. No se le puede borrar de la lista si previamente NO ha pagado, en cuyo caso se mostrará un mensaje indicándolo.
3.- Coches dentro del parking. Solo los de los vehículos particulares.
4.- Cobrar por el tiempo estacionado. Nos mostrará un mensaje con la cantidad a pagar y se cambiará el campo pagado a true. 

 */
import objetos.parking;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import utilidades.calculoTiempo;

public class main {

    public static void main(String[] args) {

        parking parking = new parking();
        boolean residente = false;
        String matricula;
        String fecha;
        int menu = 0;
        do {
            try {

                menu = Integer.parseInt(JOptionPane.showInputDialog(
                        "1.Entra un coche.\n"
                        + "2.Sale un coche.\n"
                        + "3.Coches dentro del Parking\n"
                        + "4.Cobrar por el tiempo estacionado\n"
                        + "5.Salir."));

                switch (menu) { //Creo el menu
                    case 1:
                        matricula = JOptionPane.showInputDialog("Introduce la matricula: ");
                        String fecha_hora_entrada = calculoTiempo.obtenerHora();
                        JOptionPane.showMessageDialog(null, parking.entraCoche(matricula, fecha_hora_entrada));
                        break;
                    case 2:
                        matricula = JOptionPane.showInputDialog("Introduce la matricula: ");
                        JOptionPane.showMessageDialog(null, parking.saleCoche(matricula));
                        break;
                    case 3:
                        parking.listado();
                        break;
                    case 4:
                        matricula = JOptionPane.showInputDialog("Introduce la matricula: ");
                        JOptionPane.showMessageDialog(null, parking.pagar(matricula));
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Gracias por utilizar esta aplicacion, esperamos verte pronto");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La opcion introducida no es valida");
                }

            } catch (java.lang.NumberFormatException e) {
                menu = 5;
            }
            catch (Exception e) {
                System.out.println("Ha ocurrido un error");
            }
        } while (menu != 5);

    }
}
