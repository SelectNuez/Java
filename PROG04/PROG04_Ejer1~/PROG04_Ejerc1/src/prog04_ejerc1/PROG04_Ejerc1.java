/*
Implementar un programa que muestre la tabla de multiplicar de un número leido desde teclado 
utilizando al menos tres bucles diferentes. 
El número leído desde teclado debe ser menor que 30. 
En caso contrario se mostrará un mensaje por pantalla y el programa finalizará.
 */
package prog04_ejerc1;

import javax.swing.JOptionPane;

public class PROG04_Ejerc1 {
    //Autor: Jorge Martin Nuñez 
    public static void main(String[] args) {
        int num, contador = 1, selector;
        num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero menor que 30: "));
        selector = Integer.parseInt(JOptionPane.showInputDialog("Seleccione un sistema de calculo \n1.-While\n2.-IF\n3.-For"));

        if (num <= 30) { //Si el numero es menor o igual a 30

            switch (selector) { //Ejecutamos un selector en el que elegiras que bucle usaras para calcular su tabla de multiplicar
                case 1:
                    while (contador < 11) { //Con un contador hasta 10 , ya que la tabla de multiplicar es del 1 al 10
                        System.out.println(num * contador); //Multiplicamos dicho numero por 1,2...
                        contador++;
                    }
                    break;
                case 2:
                    if (contador < 11) {
                        System.out.println(num * contador);
                        contador++;
                    } else {
                        break;
                    }
                    ;
                case 3:
                    for (contador = 1; contador < 11; contador++) {
                        System.out.println(num * contador);
                    }
                    break;
            }

        } else { //Si es mayor que 30

            JOptionPane.showMessageDialog(null, "El numero es mayor que 30");
        }
    }
}
