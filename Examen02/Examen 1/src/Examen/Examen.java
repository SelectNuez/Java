package Examen;

import javax.swing.JOptionPane;

public class Examen {

    public static void main(String[] args) {
        int horasExtras, horasSemanales, nHijos = 0;
        double salarioSemanal = 0, salarioMensual = 0, impuesto = 0;

        horasSemanales = Integer.parseInt(JOptionPane.showInputDialog("Introduzca las horas semanales: "));

        if (horasSemanales < 36) {
            salarioSemanal = horasSemanales * 50;
        } else {
            salarioSemanal = 35 * 50;
            horasExtras = horasSemanales - 35;
            salarioSemanal = salarioSemanal + (horasExtras * (50 * 1.5));
        }

        if (salarioSemanal > 1400 && salarioSemanal < 3000) {
            //	Si esta entre 1400 y 3000 se aplicará el 20% sobre el sueldo mensual.
            impuesto = 0.2;
            
            //Si no se especifica una restriccion habria que ponerla?
            
        } else {
            //Para los sueldos mayores de 3000 se aplicará un 30% sobre el sueldo mensual
            impuesto = 0.3;
        }

        /*
Además, se podrán deducir un 2% por cada hijo que tengan. Es decir, para una persona que gane 2000 Є y tenga 2 hijos se le aplicara un impuesto de:
 20% – (2hijos*2%por hijo) = 20-4=16% es decir se le aplicaran sobre el sueldo un impuesto del 16%.
Por tanto, cobrará 2000 – 320= 1680 Є

         */
        nHijos = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de hijos: "));
        if (nHijos > 0) {
            impuesto = impuesto - (0.02 * nHijos);
        }

        salarioMensual = (salarioSemanal * 4);
        salarioMensual = salarioMensual - (salarioMensual * impuesto);
        JOptionPane.showMessageDialog(null, "Salario: " + salarioMensual);
        System.out.println("impuesto: " + impuesto);
        System.out.println("Salario semanal: " + salarioSemanal);
        System.out.println("Salario Mensual: " + salarioMensual);
    }
}
