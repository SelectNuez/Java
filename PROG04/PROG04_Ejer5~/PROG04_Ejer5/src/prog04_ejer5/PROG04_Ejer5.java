/*
Cuando dividimos un número entre 0 se genera un valor indeterminado. 
En cualquier lenguaje de programación este tipo de operaciones genera un error de ejecución 
que debe ser controlado desde el código para evitar malas experiencias al usuario. 
En Java, cuando se produce esta operación se genera la excepción ArithmeticException. 
Queremos implementar un programa Java que calcule la división de dos números solicitados por teclado (dividendo y divisor). 
El programa solicitará números indefinidamente hasta que los dos números solicitados sean -1. 
Se debe controlar mediante excepciones que el divisor no sea 0. En caso de serlo, 
se mostrará un mensaje por pantalla. También habrá que mostrar por pantalla el número de divisiones calculadas. 
Utiliza número enteros para las variables.
 */
package prog04_ejer5;

import javax.swing.JOptionPane;

public class PROG04_Ejer5 {

// Autor: Jorge Martin Nuñez
    public static void main(String[] args) {
        int num1, num2, res,i=0;
        num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer numero a dividir"));
        num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el segundo numero a dividir"));
        while (num1 != -1 && num2 != -1) {
            try {
                res = (num1 / num2);
            }
            catch(ArithmeticException e){
            num2 = Integer.parseInt(JOptionPane.showInputDialog("El divisor es 0. Por favor, introduce otro numero"));
            }
            res = (num1 / num2);
            i++;
            JOptionPane.showMessageDialog(null, "La division es: "+ res + " y llevas " + i + " divisiones calculadas");
            num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer numero a dividir"));
            num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el segundo numero a dividir"));
        }

    }

}
