/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tiempos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jorma
 */
public class calculoTiempo {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    static Calendar calendar = Calendar.getInstance();
    static Date dateObj = calendar.getTime();

    public calculoTiempo() {

    }

    public static String obtenerHora() {
        return sdf.format(dateObj);
    }

    public static long calcularDiferencia(String entrada) throws ParseException {

        String fecha_hora_salida = sdf.format(dateObj);

        Date d1 = sdf.parse(entrada);
        Date d2 = sdf.parse(fecha_hora_salida);

        return ((d2.getTime() - d1.getTime()) / 1000);
    }
}
