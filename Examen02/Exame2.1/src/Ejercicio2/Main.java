/*
En un concurso deportivo 8 (1..8) jueces otorgan una nota entre 1 y 10 a cada participante, de esas puntuaciones se calculará la puntuación final. 

Para evitar que un juez otorgue puntuaciones exageradas, la puntuación más alta y la más baja se eliminan y del resto se calcula la media.

Por ejemplo. 
Si las puntuaciones fueran:  | 7 | 8 | 2 | 6 | 7 | 8 | 10 | 6 |      
se eliminarían el  2  y el 10  y del resto se calcula la media ..              42 / 6 --> 7

Si hubiera dos puntuaciones mínimas (o máximas) iguales se elimina una.
ej :  | 2 | 2 | 6 | 7 | 8 | 7 | 8 | 7 |  se elimina un 2 y un 8.

Realizar un programa que me introduzca la nota de cada juez (Aleatoriamente). Además, me visualice la puntuación media para el participante:
 */
package Ejercicio2;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int notaMax, notaMin, juezMin = 0, juezMax = 0;
        double notaMedia = 0;
        int notaJuez[] = new int[8];

        //Completamos las notas de todos los jueces
        for (int i = 0; i < 8; i++) {
            notaJuez[i] = (int) Math.floor(Math.random() * 10 + 1);
        }
        //Retiramos la nota minima
        notaMin = notaJuez[0];
        for (int i = 1; i < 8; i++) {
            if (notaMin > notaJuez[i]) {
                notaMin = notaJuez[i];
                juezMin = i;
            }
        }
        notaJuez[juezMin] = 0;
        //Retiramos la nota maxima
        notaMax = notaJuez[0];
        for (int i = 1; i < 8; i++) {
            if (notaMax < notaJuez[i]) {
                notaMax = notaJuez[i];
                juezMax = i;
            }
        }
        notaJuez[juezMax] = 0;

        //Calculamos nota media
        for (int i = 1; i < 8; i++) {
            notaMedia += notaJuez[i];
        }
        notaMedia /= 6;

        JOptionPane.showMessageDialog(null, "La nota media es: " + notaMedia);
    }
}
