/*
Ejercicio 3:  El Mínimo Común Múltiplo (MCM) de un conjunto de dos números 
es el número positivo más pequeño que es múltiplo de los dos números. 
Es posible calcular el MCM de tres o más números. 
Por ejemplo, el MCM (2,3) es 6. 
El 6 es el múltiplo mas pequeño de 2 y de 3. 
Implementa un programa Java que pida dos números por teclado, 
compruebe que son positivos y calcule su MCM. 
En caso de no ser ambos números positivos, el programa mostrará un mensaje por pantalla y finalizará.
 */
package prog04_ejer3;

import javax.swing.JOptionPane;

public class PROG04_Ejer3 {
    //Autor: Jorge Martin Nuñez 
    public static void main(String[] args) {
        int num1, num2, contador = 1;
        num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer numero"));
        num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el segundo numero"));

        if (num1 > 0 && num2 > 0) { //Si el numero 1 o el 2 son menores que 0 nos indicara que no es positivo

            while ((contador % num1 != 0) || (contador % num2 != 0)) {
                contador++;
            }

            JOptionPane.showMessageDialog(null, "El MCM es:" + contador);

        } else {
            JOptionPane.showMessageDialog(null, "ERROR: Uno o los dos numeros no son positivos");
        }
    }

}
