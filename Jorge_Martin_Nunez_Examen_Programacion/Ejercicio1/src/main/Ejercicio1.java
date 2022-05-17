package main;

import javax.swing.JOptionPane;
import clases.gestor;
/**
 *
 * @author Jorge Martin
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        int menu = 0;
        String nombreMunicipio;
        String codPostal;
        int numHabitantes;
        int numHogares;
        gestor gestor = new gestor();
        do {
            try {

                menu = Integer.parseInt(JOptionPane.showInputDialog(
                        "1.Insertar municipio\n"
                        + "2.Registrar proximo consumo\n"
                        + "3.Listar los municipios y su consumo\n"
                        + "4.Consumo total de agua de todos los municipios\n"
                        + "5.Visualizar estadistica de municipio\n"
                        + "6.Salir."));

                switch (menu) { //Creo el menu
                    case 1:
                        nombreMunicipio = JOptionPane.showInputDialog("Introduzca el nombre del municipio");
                        codPostal = JOptionPane.showInputDialog("Introduzca el codigo postal del municipio");
                        numHabitantes = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de habitantes del municipio"));
                        numHogares = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de hogares del municipio"));
                        gestor.InsertarMuncicipio(nombreMunicipio, codPostal, numHabitantes, numHogares);
                        break;
                    case 2:
                        codPostal = JOptionPane.showInputDialog("Introduzca el codigo postal del municipio");
                        gestor.registrarConsumo(codPostal);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, gestor.listadoMunicipios());
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, gestor.consumoTotal());
                        break;
                    case 5:
                        codPostal = JOptionPane.showInputDialog("Introduzca el codigo postal del municipio");
                        JOptionPane.showMessageDialog(null, gestor.consumoMunicipio(codPostal));
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Gracias por utilizar esta aplicacion, esperamos verte pronto");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La opcion introducida no es valida");
                }

            } catch (java.lang.NumberFormatException e) {
                System.out.println("Ha introducido un caracter no valido");
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error");
            }
        } while (menu != 6);

    }
}
