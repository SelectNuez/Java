/*
Programa Java que lea una serie de valores numéricos enteros desde el teclado y los guarde en un ArrayList de tipo Integer. 
La lectura de números enteros termina cuando se introduzca el valor -99. 
Este valor no se guarda en el ArrayList. 
A continuación el programa mostrará por pantalla el número de valores que se han leído, su suma y su media. 
Por último se mostrarán todos los valores leídos, indicando cuántos de ellos son mayores que la media.
 */
package principal;

import javax.swing.JOptionPane;
import clases.numeros;

public class Ejercicio1ArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        numeros numeros = new numeros();
        int numero;
        numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca un numero(Introduzca -99 para salir)"));
        do {
            numeros.agregarNumero(numero);
            numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca un numero(Introduzca -99 para salir)"));

        } while ((numero != -99));
        numeros.listadoNumeros();
        JOptionPane.showMessageDialog(null, "La suma de todos los numeros es: " + numeros.sumaNumeros());
        JOptionPane.showMessageDialog(null, "La media de todos los numeros es: " + numeros.mediaNumeros());

    }

}
