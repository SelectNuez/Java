package main;

import javax.swing.JOptionPane;

public class Ejercicio2 {

    public static void main(String[] args) {
        int vacunasTotal = 1000, cont = 0;
        Integer vacunasSolicitadas[] = new Integer[7];
        Integer vacunasRepartidas[] = new Integer[7];
        do {
            vacunasSolicitadas[cont] = (int) (Math.random() * (200 - 150 + 1) + 150);

            if (vacunasSolicitadas[cont] > vacunasTotal) {
                vacunasRepartidas[cont] = vacunasTotal;
                vacunasTotal-=vacunasRepartidas[cont];
            }
            else{
            vacunasRepartidas[cont] = vacunasSolicitadas[cont];
            vacunasTotal-=vacunasRepartidas[cont];
            }
            cont++;
        } while (cont < 7);
        JOptionPane.showMessageDialog(null, 
                "Lunes: Vacunas Solicitadas : " + vacunasSolicitadas[0] + " Vacunas Repartidas: " + vacunasRepartidas[0]+
                "\nMartes: Vacunas Solicitadas : " + vacunasSolicitadas[1] + " Vacunas Repartidas: " + vacunasRepartidas[1]+
                "\nMiercoles: Vacunas Solicitadas : " + vacunasSolicitadas[2] + " Vacunas Repartidas: " + vacunasRepartidas[2]+
                "\nJueves: Vacunas Solicitadas : " + vacunasSolicitadas[3] + " Vacunas Repartidas: " + vacunasRepartidas[3]+
                "\nViernes: Vacunas Solicitadas : " + vacunasSolicitadas[4] + " Vacunas Repartidas: " + vacunasRepartidas[4]+
                "\nSabado Vacunas Solicitadas : " + vacunasSolicitadas[5] + " Vacunas Repartidas: " + vacunasRepartidas[5]+
                "\nDomingo: Vacunas Solicitadas : " + vacunasSolicitadas[6] + " Vacunas Repartidas: " + vacunasRepartidas[6]
                );
                if(vacunasTotal!=0){
                JOptionPane.showMessageDialog(null, "Las vacunas restantes son: " + vacunasTotal);
                }
    }

}
