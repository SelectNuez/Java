package prog04_ejer4;

import javax.swing.JOptionPane;

public class PROG04_Ejer4 {

    //Autor: Jorge Martin Nuñez 
    public static void main(String[] args) {
        //Si el usuario selecciona Jugar sin configurar previamente el número de intentos y el número máximo generado, se tomarán como valores por defecto: numInt=5 y numMax=10.
        int menu = 1, numInt = 5, numMax = 10, num = 0, intentos = 0;
        //Si el usuario pulsa la opción 3, el programa finaliza.
        while (menu != 3) {
            //El programa mostrará un pequeño menú en pantalla con las siguientes opciones (1. Configurar, 2. Jugar, 3. Salir).
            menu = Integer.parseInt(JOptionPane.showInputDialog("Elige una opcion\n1. Configurar\n2. Jugar\n3. Salir"));
            switch (menu) {
                //Si el usuario selecciona el la primera opción, se le solicitará por teclado el número de intentos permitidos (numInt) y el número máximo  (numMax) generado.
                case 1:
                    numInt = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de intentos permitidos"));
                    numMax = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero maximo"));
                    break;
                //Si el usuario selecciona la opción 2,  el programa generará un número aleatorio entre 0 y numMax que será el número a adivinar (numOculto). 

                case 2:
                    int numOculto = (int) Math.floor(Math.random() * numMax + 1); //genera un número aleatorio entre 0 y 20, ambos incluidos.
                    //A partir de este momento, se le solicitarán al usuario números hasta adivinar el número oculto.
                    JOptionPane.showMessageDialog(null, "El numero maximo es: " + numMax + "\nEl numero de intentos es: " + numInt);

                    do {
                        //En cada intento, si el usuario no adivina el número se le proporcionará una pista, por ejemplo, "El número oculto es menor".
                        if (num != 0) {
                            if (numOculto > num) {
                                JOptionPane.showMessageDialog(null, "El numero que has introducido es menor que el Oculto");
                            } else {
                                JOptionPane.showMessageDialog(null, "El numero que has introducido es mayor que el Oculto");
                            }
                        }
                        num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero"));
                        intentos++;
                        System.out.println(numOculto != num);
                    } while (numOculto != num && intentos < numInt);

                    //Si el usuario adivina el número, se mostrará un mensaje "Has ganado!. Has necesitado X intentos".
                    if (numOculto == num) {
                        System.out.println("Estas en numOculto == num");
                        JOptionPane.showMessageDialog(null, "Has ganado!. Has necesitado " + intentos + " intentos");

                    } //Si se consume el número de intentos sin adivinar el número, se mostrará el mensaje "Perdiste!. Intentos consumidos".
                    else if (intentos >= numInt) {
                        System.out.println("Estas en intentos > numInt");
                        JOptionPane.showMessageDialog(null, "Perdiste!. Intentos consumidos");
                        numInt = 5;
                        numMax = 10;
                        num = 0;
                        intentos = 0;

                    }
                    break;
                case 3:
                    break;
                
//En ambos casos, la siguiente acción será mostrar el menú.

                default:
                    JOptionPane.showMessageDialog(null, "Has introducido un valor erroneo");
            }
        }
    }

}
