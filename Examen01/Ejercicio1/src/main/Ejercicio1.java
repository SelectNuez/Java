package main;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class Ejercicio1 {

    public static void main(String[] args) {
        int tiempo = 0, valido = 1, tiempototal = 0, mediatiempo = 0, cont = 0, validez = 1;
        Integer tiempos[] = new Integer[5];
        try{
            do {
                do {

                    try {
                        tiempo = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el tiempo (13-22): "));
                    } catch (InputMismatchException e) {
                        JOptionPane.showMessageDialog(null, "No es un numero entero");
                        valido = 0;
                    }

                } while (tiempo < 13 || tiempo > 22);
                tiempos[cont] = tiempo;
                System.out.println("tiempos" + tiempos[cont]);
                tiempototal += tiempo;
                cont++;

                if (cont == 5) {
                    mediatiempo = tiempototal / 5;
                }
                System.out.println(mediatiempo);
                if (tiempo > 20) {
                    validez = 2;
                    if (validez == 2 && cont == 5) {
                        validez = 0;
                    }
                } else if (tiempo < 15) {
                    validez = 1;
                } else if (mediatiempo <= 17 && mediatiempo != 0) {
                    validez = 1;
                } else {
                    validez = 0;
                }
            } while (cont < 5 && validez != 1);

            if (validez == 1) {
                for (int j = 0; j < 5; j++) {
                    JOptionPane.showMessageDialog(null, "Tiempo " + (j + 1) + ": " + tiempos[j]);
                }
                if (mediatiempo <= 17) {
                    JOptionPane.showMessageDialog(null, "La media es: " + mediatiempo);
                }
                JOptionPane.showMessageDialog(null, "Apto");
            } else {
                for (int j = 0; j < 5; j++) {
                    JOptionPane.showMessageDialog(null, "Tiempo " + (j + 1) + ": " + tiempos[j]);
                }
                JOptionPane.showMessageDialog(null, "NO Apto");
                if (mediatiempo <= 17) {
                    JOptionPane.showMessageDialog(null, "La media es: " + mediatiempo);
                }
            }
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, "Algo ha fallado");
        }
    }
}
