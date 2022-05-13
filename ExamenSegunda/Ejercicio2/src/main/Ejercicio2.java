package main;
/*
Vamos a realizar un programa que nos ha pedido el profesor de Historia para examinar a los alumnos de 3 de la ESO de las capitales de los países de Europa.
Para ello vamos a generar 5 números al azar sin que dichos números se puedan repetir, dichos números van a simular las 5 preguntas de las cuales consta el examen.
El programa nos pedirá el nombre del alumno para a continuación no irá pidiendo que el alumno teclee la capital del país que le haya salido aleatoriamente y comprobará que la contestación ha sido correcta, habrá que tener en cuenta que NO se distinguirá entre mayúsculas y minúsculas a la hora de contestar es decir el alumno podrá escribir tanto en mayúsculas como en minúsculas indistintamente. 

He añadido una mejora para poder definir el numero de preguntas
*/
import objetos.Capitales;
import javax.swing.JOptionPane;

public class Ejercicio2 {

    public static void main(String[] args) {
    String nombre;
    Capitales cap = new Capitales();
    Capitales.setNumPreg(Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de preguntas: ")));
    nombre  = JOptionPane.showInputDialog("Introduzca el nombre: ");
    JOptionPane.showMessageDialog(null, "Nombre: " +  nombre + "\n" + cap.getPregunta());
}

}
