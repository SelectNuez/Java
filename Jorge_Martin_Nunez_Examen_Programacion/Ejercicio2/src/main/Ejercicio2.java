/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import bbdd.ConnectionDB;
import clases.gestor;
import java.sql.Connection;
import javax.swing.JOptionPane;
import utilidades.*;

/**
 *
 * @author Jorge Martin
 */
public class Ejercicio2 {


    public static void main(String[] args) {
        int menu = 0;
        String parametro = null;
        int num_incidencia;
        Connection con = ConnectionDB.openConnection();
        do {
            try {
                menu = Integer.parseInt(JOptionPane.showInputDialog(
                        "1.Alta Incidencia.\n"
                        + "2.Borrar Incidencia\n"
                        + "3.Cambiar estado incidencia a Arreglada\n"
                        + "4.Mostrar las incidencias No Arregladas y Urgentes ordenados por fecha\n"
                        + "5.Salir."));

                switch (menu) {
                    case 1:
                        gestor.altaIncidencia(con);
                        break;
                    case 2:
                        num_incidencia = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de Incidencia: "));
                        JOptionPane.showMessageDialog(null, gestor.bajaIncidencia(num_incidencia, con));
                        break;
                    case 3:
                        num_incidencia = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de Incidencia: "));
                        JOptionPane.showMessageDialog(null, gestor.cambioEstado(num_incidencia, con));
                        break;
                    case 4:
                        for (Object listado : gestor.listado(con)) {
                            JOptionPane.showMessageDialog(null, listado);
                        }

                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Hasta la proxima!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Introduzca una opcion valida");
                }
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Ha introducido un caracter no valido");
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error");
            }
        } while (menu != 5);

        ConnectionDB.closeConnection();
    }

}
