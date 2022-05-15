/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.lang.*;
import javax.swing.JOptionPane;
import index.*;

/**
 *
 * @author Blitz
 */
public class HashMapEjercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int menu = 0;
        int stock = 0;
        String producto = null;
        //Como hay que meter datos lo inicializo para que se carguen
        index indice = new index();

        do {
            try {
                menu = Integer.parseInt(JOptionPane.showInputDialog(
                        "1.Añadir Producto\n"
                        + "2.Aumentar Stock.\n"
                        + "3.Eliminar Stock\n"
                        + "4.Mostrar productos\n"
                        + "5.Eliminar productos\n"
                        + "6.Salir."));

                switch (menu) {
                    case 1:
                        producto = JOptionPane.showInputDialog("Introduzca el nombre del producto");
                        stock = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el stock del producto"));
                        index.AñadirProducto(producto, stock);
                        break;
                    case 2:
                        producto = JOptionPane.showInputDialog("Introduzca el nombre del producto");
                        stock = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el nuevo stock del producto"));
                        index.AumentarStock(producto, stock);
                        break;
                    case 3:
                        producto = JOptionPane.showInputDialog("Introduzca el nombre del producto");
                        index.EliminarStock(producto);
                        break;
                    case 4:
                        index.MostrarProductos();
                        break;
                    case 5:
                        //Si el metodo no fuese estatico
                        producto = JOptionPane.showInputDialog("Introduzca el nombre del producto");

                        indice.EliminarProductos(producto);
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Hasta la proxima!");

                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Introduzca una opcion valida");
                }

            } catch (Exception e) {
                String fallo = e.toString();
                System.out.println(fallo);
                if (fallo.contains("java.lang.NumberFormatException: For input string:")) {
                    JOptionPane.showMessageDialog(null, "Ha introducido una cadena de caracteres no valida");

                } else {
                    JOptionPane.showMessageDialog(null, "Ha surgido un error, por favor, asegurese de introducir correctamente los valores");
                }
            }

        } while (menu != 6);

    }

}
