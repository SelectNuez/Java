// No se realizan comprobaciones de datos?
package Ejercicio2;

import javax.swing.JOptionPane;

public class Ejercicio2 {

    public static void main(String[] args) {
        int menu = 0, sala, puesto, contador = 0;
//El Departamento de Sistemas de la Universidad de Valladolid de Informática cuenta con cinco salas de ordenadores, cada una de ellas con 20 equipos.

        int ordenadores[][] = new int[5][20];
        //Inicializo todos los ordenadores a 0, siendo 0 que estan libres
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                ordenadores[i][j] = 0;
            }
        }

        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                1.Reservar Ordenador 
                                                                2.Cancelar reserva
                                                                3.Cantidad de equipos disponibles por sala
                                                                4.Cantidad de ordenadores asignados en toda la Universidad
                                                                5.Salir"""));

            switch (menu) {
                case 1:
                    //Para la reserva se solicitará al usuario la siguiente información (sala)
                    //a partir de ese dato el ordenador le asignará el primer ordenador libre de esa sala.
                    sala = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la sala en la que desea reservar el ordenador (1-5): "));
                    for (int i = 0; i < 20; i++) {
                        if (ordenadores[sala - 1][i] == 0) {
                            JOptionPane.showMessageDialog(null, "El ordenador reservado es el numero " + (i + 1) + " de la sala " + sala);
                            ordenadores[sala - 1][i] = 1;
                            break;
                        }
                        //Añadir comprobacion no mas PC disponibles

                    }

                    break;
                case 2:
                    //Se podrán hacer también cancelaciones dado la sala y el ordenador asignado.
                    sala = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la sala en la que tiene la reserva"));
                    puesto = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el puesto del ordenador reservado"));
                    if (ordenadores[sala][puesto - 1] == 1) {
                        JOptionPane.showMessageDialog(null, "Se ha cancelado la reserva del ordenador introducido");
                        ordenadores[sala][puesto - 1] = 0;
                    } else {
                        JOptionPane.showMessageDialog(null, "El ordenador introducido no esta reservado, por favor, vuelva a intentarlo");
                    }

                    break;
                case 3:
                    //Cantidad de equipos disponibles por sala
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 20; j++) {
                            if (ordenadores[i][j] == 0) {
                                contador++;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Estan disponibles " + contador + " ordenadores en la sala " + (i + 1));
                        contador = 0;
                    }

                    break;
                case 4:
                    //Cantidad de ordenadores asignados en toda la Universidad
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 20; j++) {
                            if (ordenadores[i][j] == 1) {
                                contador++;
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Estan ocupados " + contador + " ordenadores en toda la Universidad");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Hasta la proxima");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opcion introducida no es valida.");
                    break;
            }
        } while (menu != 5);

    }
}
