/*
Ejercicio 2: Un número es primo si solo tiene dos divisores: el 1 y el propio número. 
Implementa un programa Java que pida por teclado 5 números. Para cada uno de ellos:
Comprueba si es negativo. En caso afirmativo, muestra el mensaje por pantalla "El número es negativo".
Si es positivo, deberá mostrar por pantalla si es primo o no.
Procesados los 5 números, el programa finaliza.
 */
package prog04_ejer2;

import javax.swing.JOptionPane;

public class PROG04_Ejer2 {
    //Autor: Jorge Martin Nuñez 
    public static void main(String[] args) {
        int num, primo, contador;
        for (int i = 1; i < 6; i++) {
            num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero"));
            primo = 0; //Iniciamos un indicador para saber cuando es primo
            contador=2; // Iniciamos un contador en 2 ya que todos los numeros son divisibles por 1
            if (num > 0) { //Si el numero es mayor que 0 es positivo
                JOptionPane.showMessageDialog(null, "El numero introducido es positivo");
                while (contador < num) { //Siempre que el contador sea menor que el numero se evalua
                    if (num % contador == 0) { // Si el resto de dividir el numero al contador es 0 significa que es divisible entre ese numero
                        primo = 1; //Si ha sido posible dividirlo con resto 0 establecemos el indicador de primo como 1
                        System.out.println("Divisible entre: " + contador); //Sacamos por consola entre que es divisible, asi tenemos un control del proceso del programa
                    }
                    contador++; // Aumentamos en 1 el contador
                }
                if (primo == 0) { //Si el indicador es 0 es que no se ha podido dividir entre nada, por lo que es primo
                    JOptionPane.showMessageDialog(null, "El numero introducido es primo");
                } else{ //Si el indicador no es 0, quiere decir que es 1, por lo que no es primo
                    JOptionPane.showMessageDialog(null, "El numero introducido no es primo");

                }

            } else if (num < 0) { // Si el numero es menor que 0 es negativo
                JOptionPane.showMessageDialog(null, "El numero introducido es negativo");
            } else { //Si no es ni mayor que 0 ni menor que 0 es que es 0.
                JOptionPane.showMessageDialog(null, "El numero introducido es 0");
            }
        }

    }

}
